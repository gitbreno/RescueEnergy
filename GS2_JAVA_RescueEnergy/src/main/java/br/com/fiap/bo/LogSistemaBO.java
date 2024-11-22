package br.com.fiap.bo;

import br.com.fiap.beans.LogSistema;
import br.com.fiap.dao.LogSistemaDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class LogSistemaBO {

    private LogSistemaDAO logDAO;

    public LogSistemaBO() {
        this.logDAO = new LogSistemaDAO();
    }

    // Método para salvar um novo log
    public void salvarLog(LogSistema log) {
        try {
            logDAO.salvar(log);
            JOptionPane.showMessageDialog(null, "Log salvo com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar log: " + e.getMessage());
        }
    }

    // Método para listar todos os logs
    public List<LogSistema> listarLogs() {
        try {
            return logDAO.listar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar logs: " + e.getMessage());
            return null;
        }
    }

    // Método para atualizar um log existente
    public void atualizarLog(LogSistema log) {
        try {
            logDAO.atualizar(log);
            JOptionPane.showMessageDialog(null, "Log atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar log: " + e.getMessage());
        }
    }

    // Método para excluir um log pelo ID
    public void excluirLog(int id) {
        try {
            logDAO.excluir(id);
            JOptionPane.showMessageDialog(null, "Log excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir log: " + e.getMessage());
        }
    }
}
