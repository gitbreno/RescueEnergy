package br.com.fiap.resource;

import br.com.fiap.beans.LogSistema;
import br.com.fiap.bo.LogSistemaBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/logs")
public class LogSistemaResource {

    private LogSistemaBO logBO = new LogSistemaBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarLog(LogSistema log) {
        logBO.salvarLog(log);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LogSistema> listarLogs() {
        return logBO.listarLogs();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarLog(LogSistema log) {
        logBO.atualizarLog(log);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirLog(@PathParam("id") int id) {
        logBO.excluirLog(id);
        return Response.noContent().build();
    }
}
