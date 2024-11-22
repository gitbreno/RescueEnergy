package br.com.fiap.beans;

// Classe ConfiguracaoSistema
public class ConfiguracaoSistema {
    private int id;
    private String chave;
    private String valor;

    public ConfiguracaoSistema(int id, String chave, String valor) {
        this.id = id;
        this.chave = chave;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}