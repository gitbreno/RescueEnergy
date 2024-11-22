package br.com.fiap.resource;

import br.com.fiap.beans.ConfiguracaoSistema;
import br.com.fiap.bo.ConfiguracaoSistemaBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/configuracoes")
public class ConfiguracaoSistemaResource {

    private ConfiguracaoSistemaBO configuracaoBO = new ConfiguracaoSistemaBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarConfiguracao(ConfiguracaoSistema config) {
        configuracaoBO.salvarConfiguracao(config);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ConfiguracaoSistema> listarConfiguracoes() {
        return configuracaoBO.listarConfiguracoes();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarConfiguracao(ConfiguracaoSistema config) {
        configuracaoBO.atualizarConfiguracao(config);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirConfiguracao(@PathParam("id") int id) {
        configuracaoBO.excluirConfiguracao(id);
        return Response.noContent().build();
    }
}
