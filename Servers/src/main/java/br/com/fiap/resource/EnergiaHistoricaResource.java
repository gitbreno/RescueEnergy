package br.com.fiap.resource;

import br.com.fiap.beans.EnergiaHistorica;
import br.com.fiap.bo.EnergiaHistoricaBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/energia-historica")
public class EnergiaHistoricaResource {

    private EnergiaHistoricaBO energiaBO = new EnergiaHistoricaBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarEnergiaHistorica(EnergiaHistorica energia) {
        energiaBO.salvarEnergiaHistorica(energia);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnergiaHistorica> listarEnergiaHistorica() {
        return energiaBO.listarEnergiaHistorica();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarEnergiaHistorica(EnergiaHistorica energia) {
        energiaBO.atualizarEnergiaHistorica(energia);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirEnergiaHistorica(@PathParam("id") int id) {
        energiaBO.excluirEnergiaHistorica(id);
        return Response.noContent().build();
    }
}
