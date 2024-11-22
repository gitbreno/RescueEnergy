package br.com.fiap.resource;

import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.UsuarioBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

    private UsuarioBO usuarioBO = new UsuarioBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarUsuario(Usuario usuario) {
        usuarioBO.salvarUsuario(usuario);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarUsuarios() {
        return usuarioBO.listarUsuarios();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarUsuario(Usuario usuario) {
        usuarioBO.atualizarUsuario(usuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirUsuario(@PathParam("id") int id) {
        usuarioBO.excluirUsuario(id);
        return Response.noContent().build();
    }
}
