package br.com.fiap.beans;

public class Notificacao {
    private int id;
    private String mensagem;
    private String dataHora;

    public Notificacao(int id, String mensagem, String dataHora) {
        this.id = id;
        this.mensagem = mensagem;
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}