package br.com.fiap.dao;

import br.com.fiap.beans.*;
import br.com.fiap.conexoes.Conexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classe ConfiguracaoSistemaDAO
public class ConfiguracaoSistemaDAO {

    // Método para salvar uma nova configuração
    public void salvar(ConfiguracaoSistema config) throws SQLException {
        String sql = "INSERT INTO CONFIGURACOES (CHAVE, VALOR) VALUES (?, ?)";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, config.getChave());
            stmt.setString(2, config.getValor());
            stmt.executeUpdate();
        }
    }

    // Método para listar todas as configurações
    public List<ConfiguracaoSistema> listar() throws SQLException {
        List<ConfiguracaoSistema> configuracoes = new ArrayList<>();
        String sql = "SELECT * FROM CONFIGURACOES";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ConfiguracaoSistema config = new ConfiguracaoSistema(
                        rs.getInt("ID"),
                        rs.getString("CHAVE"),
                        rs.getString("VALOR")
                );
                configuracoes.add(config);
            }
        }
        return configuracoes;
    }

    // Método para atualizar uma configuração existente
    public void atualizar(ConfiguracaoSistema config) throws SQLException {
        String sql = "UPDATE CONFIGURACOES SET CHAVE = ?, VALOR = ? WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, config.getChave());
            stmt.setString(2, config.getValor());
            stmt.setInt(3, config.getId());
            stmt.executeUpdate();
        }
    }

    // Método para excluir uma configuração pelo ID
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM CONFIGURACOES WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
