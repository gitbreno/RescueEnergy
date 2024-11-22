package br.com.fiap.beans;

public class LogSistema {
    private int id;
    private String acao;
    private String usuario;
    private String dataHora;

    public LogSistema(int id, String acao, String usuario, String dataHora) {
        this.id = id;
        this.acao = acao;
        this.usuario = usuario;
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}