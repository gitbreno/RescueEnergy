package br.com.fiap.resource;

import br.com.fiap.beans.Notificacao;
import br.com.fiap.bo.NotificacaoBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notificacoes")
public class NotificacaoResource {

    private NotificacaoBO notificacaoBO = new NotificacaoBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarNotificacao(Notificacao notificacao) {
        notificacaoBO.salvarNotificacao(notificacao);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notificacao> listarNotificacoes() {
        return notificacaoBO.listarNotificacoes();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarNotificacao(Notificacao notificacao) {
        notificacaoBO.atualizarNotificacao(notificacao);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirNotificacao(@PathParam("id") int id) {
        notificacaoBO.excluirNotificacao(id);
        return Response.noContent().build();
    }
}
