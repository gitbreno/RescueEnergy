package br.com.fiap.dao;

import br.com.fiap.beans.*;
import br.com.fiap.conexoes.Conexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Classe UsuarioDAO
public class UsuarioDAO {

    // Método para salvar um novo usuário
    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO USUARIOS (NOME, EMAIL, SENHA) VALUES (?, ?, ?)";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os usuários
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIOS";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("ID"),
                        rs.getString("NOME"),
                        rs.getString("EMAIL"),
                        rs.getString("SENHA")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // Método para atualizar um usuário existente
    public void atualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIOS SET NOME = ?, EMAIL = ?, SENHA = ? WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um usuário pelo ID
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM USUARIOS WHERE ID = ?";
        try (Connection conn = Conexoes.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
