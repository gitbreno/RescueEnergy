package br.com.fiap.bo;

import br.com.fiap.beans.Notificacao;
import br.com.fiap.dao.NotificacaoDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class NotificacaoBO {

    private NotificacaoDAO notificacaoDAO;

    public NotificacaoBO() {
        this.notificacaoDAO = new NotificacaoDAO();
    }

    // Método para salvar uma nova notificação
    public void salvarNotificacao(Notificacao notificacao) {
        try {
            notificacaoDAO.salvar(notificacao);
            JOptionPane.showMessageDialog(null, "Notificação salva com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar notificação: " + e.getMessage());
        }
    }

    // Método para listar todas as notificações
    public List<Notificacao> listarNotificacoes() {
        try {
            return notificacaoDAO.listar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar notificações: " + e.getMessage());
            return null;
        }
    }

    // Método para atualizar uma notificação existente
    public void atualizarNotificacao(Notificacao notificacao) {
        try {
            notificacaoDAO.atualizar(notificacao);
            JOptionPane.showMessageDialog(null, "Notificação atualizada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar notificação: " + e.getMessage());
        }
    }

    // Método para excluir uma notificação pelo ID
    public void excluirNotificacao(int id) {
        try {
            notificacaoDAO.excluir(id);
            JOptionPane.showMessageDialog(null, "Notificação excluída com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir notificação: " + e.getMessage());
        }
    }
}
