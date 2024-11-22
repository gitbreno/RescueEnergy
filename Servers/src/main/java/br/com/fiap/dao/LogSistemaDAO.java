package br.com.fiap.dao;

import br.com.fiap.beans.*;
import br.com.fiap.conexoes.Conexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classe LogSistemaDAO
public class LogSistemaDAO {

    // Método para salvar um novo registro de log
    public void salvar(LogSistema log) throws SQLException {
        String sql = "INSERT INTO LOGS (ACAO, USUARIO, DATA_HORA) VALUES (?, ?, ?)";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, log.getAcao());
            stmt.setString(2, log.getUsuario());
            stmt.setString(3, log.getDataHora());
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os logs
    public List<LogSistema> listar() throws SQLException {
        List<LogSistema> logs = new ArrayList<>();
        String sql = "SELECT * FROM LOGS";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                LogSistema log = new LogSistema(
                        rs.getInt("ID"),
                        rs.getString("ACAO"),
                        rs.getString("USUARIO"),
                        rs.getString("DATA_HORA")
                );
                logs.add(log);
            }
        }
        return logs;
    }

    // Método para atualizar um registro de log existente
    public void atualizar(LogSistema log) throws SQLException {
        String sql = "UPDATE LOGS SET ACAO = ?, USUARIO = ?, DATA_HORA = ? WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, log.getAcao());
            stmt.setString(2, log.getUsuario());
            stmt.setString(3, log.getDataHora());
            stmt.setInt(4, log.getId());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um registro de log pelo ID
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM LOGS WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
