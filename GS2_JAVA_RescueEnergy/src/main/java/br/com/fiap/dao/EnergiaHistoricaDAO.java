package br.com.fiap.dao;

import br.com.fiap.beans.*;
import br.com.fiap.conexoes.Conexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnergiaHistoricaDAO {

    // Método para salvar um novo registro de energia histórica
    public void salvar(EnergiaHistorica energia) throws SQLException {
        String sql = "INSERT INTO ENERGIA_HISTORICA (PISO_ID, DATA, ENERGIA_GERADA) VALUES (?, ?, ?)";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, energia.getPisoId());
            stmt.setString(2, energia.getData());
            stmt.setDouble(3, energia.getEnergiaGerada());
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os registros de energia histórica
    public List<EnergiaHistorica> listar() throws SQLException {
        List<EnergiaHistorica> energias = new ArrayList<>();
        String sql = "SELECT * FROM ENERGIA_HISTORICA";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                EnergiaHistorica energia = new EnergiaHistorica(
                        rs.getInt("ID"),
                        rs.getInt("PISO_ID"),
                        rs.getString("DATA"),
                        rs.getDouble("ENERGIA_GERADA")
                );
                energias.add(energia);
            }
        }
        return energias;
    }

    // Método para atualizar um registro existente de energia histórica
    public void atualizar(EnergiaHistorica energia) throws SQLException {
        String sql = "UPDATE ENERGIA_HISTORICA SET PISO_ID = ?, DATA = ?, ENERGIA_GERADA = ? WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, energia.getPisoId());
            stmt.setString(2, energia.getData());
            stmt.setDouble(3, energia.getEnergiaGerada());
            stmt.setInt(4, energia.getId());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um registro de energia histórica pelo ID
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM ENERGIA_HISTORICA WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
