package br.com.fiap.beans;

public class Sessao {
    private int id;
    private int usuarioId;
    private String token;
    private String dataInicio;

    public Sessao(int id, int usuarioId, String token, String dataInicio) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.token = token;
        this.dataInicio = dataInicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
}
