package br.com.fiap.beans;

public class PisoInteligente {
    private int id;
    private String localizacao;
    private double energiaGerada;

    public PisoInteligente(int id, String localizacao, double energiaGerada) {
        this.id = id;
        this.localizacao = localizacao;
        this.energiaGerada = energiaGerada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public double getEnergiaGerada() {
        return energiaGerada;
    }

    public void setEnergiaGerada(double energiaGerada) {
        this.energiaGerada = energiaGerada;
    }
}