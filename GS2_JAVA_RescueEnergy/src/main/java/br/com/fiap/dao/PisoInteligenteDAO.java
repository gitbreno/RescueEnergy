package br.com.fiap.dao;

import br.com.fiap.beans.*;
import br.com.fiap.conexoes.Conexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classe PisoInteligenteDAO
public class PisoInteligenteDAO {

    // Método para salvar um novo piso inteligente
    public void salvar(PisoInteligente piso) throws SQLException {
        String sql = "INSERT INTO PISOS (LOCALIZACAO, ENERGIA_GERADA) VALUES (?, ?)";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, piso.getLocalizacao());
            stmt.setDouble(2, piso.getEnergiaGerada());
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os pisos inteligentes
    public List<PisoInteligente> listar() throws SQLException {
        List<PisoInteligente> pisos = new ArrayList<>();
        String sql = "SELECT * FROM PISOS";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PisoInteligente piso = new PisoInteligente(
                        rs.getInt("ID"),
                        rs.getString("LOCALIZACAO"),
                        rs.getDouble("ENERGIA_GERADA")
                );
                pisos.add(piso);
            }
        }
        return pisos;
    }

    // Método para atualizar um piso inteligente existente
    public void atualizar(PisoInteligente piso) throws SQLException {
        String sql = "UPDATE PISOS SET LOCALIZACAO = ?, ENERGIA_GERADA = ? WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, piso.getLocalizacao());
            stmt.setDouble(2, piso.getEnergiaGerada());
            stmt.setInt(3, piso.getId());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um piso inteligente pelo ID
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM PISOS WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
