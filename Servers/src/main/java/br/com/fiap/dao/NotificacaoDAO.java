package br.com.fiap.dao;

import br.com.fiap.beans.*;
import br.com.fiap.conexoes.Conexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classe NotificacaoDAO
public class NotificacaoDAO {

    // Método para salvar uma nova notificação
    public void salvar(Notificacao notificacao) throws SQLException {
        String sql = "INSERT INTO NOTIFICACOES (MENSAGEM, DATA_HORA) VALUES (?, ?)";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, notificacao.getMensagem());
            stmt.setString(2, notificacao.getDataHora());
            stmt.executeUpdate();
        }
    }

    // Método para listar todas as notificações
    public List<Notificacao> listar() throws SQLException {
        List<Notificacao> notificacoes = new ArrayList<>();
        String sql = "SELECT * FROM NOTIFICACOES";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Notificacao notificacao = new Notificacao(
                        rs.getInt("ID"),
                        rs.getString("MENSAGEM"),
                        rs.getString("DATA_HORA")
                );
                notificacoes.add(notificacao);
            }
        }
        return notificacoes;
    }

    // Método para atualizar uma notificação existente
    public void atualizar(Notificacao notificacao) throws SQLException {
        String sql = "UPDATE NOTIFICACOES SET MENSAGEM = ?, DATA_HORA = ? WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, notificacao.getMensagem());
            stmt.setString(2, notificacao.getDataHora());
            stmt.setInt(3, notificacao.getId());
            stmt.executeUpdate();
        }
    }

    // Método para excluir uma notificação pelo ID
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM NOTIFICACOES WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
