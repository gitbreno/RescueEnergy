package br.com.fiap.bo;

import br.com.fiap.beans.ConfiguracaoSistema;
import br.com.fiap.dao.ConfiguracaoSistemaDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ConfiguracaoSistemaBO {

    private ConfiguracaoSistemaDAO configuracaoDAO;

    public ConfiguracaoSistemaBO() {
        this.configuracaoDAO = new ConfiguracaoSistemaDAO();
    }

    // Método para salvar uma nova configuração
    public void salvarConfiguracao(ConfiguracaoSistema config) {
        try {
            configuracaoDAO.salvar(config);
            JOptionPane.showMessageDialog(null, "Configuração salva com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar configuração: " + e.getMessage());
        }
    }

    // Método para listar todas as configurações
    public List<ConfiguracaoSistema> listarConfiguracoes() {
        try {
            return configuracaoDAO.listar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar configurações: " + e.getMessage());
            return null;
        }
    }

    // Método para atualizar uma configuração existente
    public void atualizarConfiguracao(ConfiguracaoSistema config) {
        try {
            configuracaoDAO.atualizar(config);
            JOptionPane.showMessageDialog(null, "Configuração atualizada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar configuração: " + e.getMessage());
        }
    }

    // Método para excluir uma configuração pelo ID
    public void excluirConfiguracao(int id) {
        try {
            configuracaoDAO.excluir(id);
            JOptionPane.showMessageDialog(null, "Configuração excluída com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir configuração: " + e.getMessage());
        }
    }
}
