package br.com.fiap.beans;

public class PisoStatus {
    private int id;
    private int pisoId;
    private boolean ativo;
    private String mensagemStatus;

    public PisoStatus(int id, int pisoId, boolean ativo, String mensagemStatus) {
        this.id = id;
        this.pisoId = pisoId;
        this.ativo = ativo;
        this.mensagemStatus = mensagemStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPisoId() {
        return pisoId;
    }

    public void setPisoId(int pisoId) {
        this.pisoId = pisoId;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getMensagemStatus() {
        return mensagemStatus;
    }

    public void setMensagemStatus(String mensagemStatus) {
        this.mensagemStatus = mensagemStatus;
    }
}