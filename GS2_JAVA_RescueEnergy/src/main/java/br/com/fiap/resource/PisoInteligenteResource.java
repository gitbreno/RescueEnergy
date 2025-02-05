package br.com.fiap.resource;

import br.com.fiap.beans.PisoInteligente;
import br.com.fiap.bo.PisoInteligenteBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pisos")
public class PisoInteligenteResource {

    private PisoInteligenteBO pisoBO = new PisoInteligenteBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarPiso(PisoInteligente piso) {
        pisoBO.salvarPiso(piso);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PisoInteligente> listarPisos() {
        return pisoBO.listarPisos();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarPiso(PisoInteligente piso) {
        pisoBO.atualizarPiso(piso);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirPiso(@PathParam("id") int id) {
        pisoBO.excluirPiso(id);
        return Response.noContent().build();
    }
}
