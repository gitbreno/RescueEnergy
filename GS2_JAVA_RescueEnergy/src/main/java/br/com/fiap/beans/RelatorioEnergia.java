package br.com.fiap.beans;

public class RelatorioEnergia {
    private int id;
    private String periodo;
    private double totalEnergia;

    public RelatorioEnergia(int id, String periodo, double totalEnergia) {
        this.id = id;
        this.periodo = periodo;
        this.totalEnergia = totalEnergia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public double getTotalEnergia() {
        return totalEnergia;
    }

    public void setTotalEnergia(double totalEnergia) {
        this.totalEnergia = totalEnergia;
    }
}