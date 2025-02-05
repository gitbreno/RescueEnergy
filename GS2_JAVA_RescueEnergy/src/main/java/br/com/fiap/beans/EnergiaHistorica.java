package br.com.fiap.beans;

public class EnergiaHistorica {
    private int id;
    private int pisoId;
    private String data;
    private double energiaGerada;

    public EnergiaHistorica(int id, int pisoId, String data, double energiaGerada) {
        this.id = id;
        this.pisoId = pisoId;
        this.data = data;
        this.energiaGerada = energiaGerada;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getEnergiaGerada() {
        return energiaGerada;
    }

    public void setEnergiaGerada(double energiaGerada) {
        this.energiaGerada = energiaGerada;
    }
}