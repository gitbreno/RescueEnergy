package br.com.fiap.bo;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
    }

    // Método para salvar um novo usuário
    public void salvarUsuario(Usuario usuario) {
        try {
            usuarioDAO.salvar(usuario);
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar usuário: " + e.getMessage());
        }
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        try {
            return usuarioDAO.listar(); // Retorna a lista diretamente do DAO
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários: " + e.getMessage());
            return new ArrayList<>(); // Retorna uma lista vazia em caso de erro
        }
    }

    // Método para atualizar um usuário
    public void atualizarUsuario(Usuario usuario) {
        try {
            usuarioDAO.atualizar(usuario);
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    // Método para excluir um usuário pelo ID
    public void excluirUsuario(int id) {
        try {
            usuarioDAO.excluir(id);
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário: " + e.getMessage());
        }
    }
}
