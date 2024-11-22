package br.com.fiap.bo;

import br.com.fiap.beans.PisoInteligente;
import br.com.fiap.dao.PisoInteligenteDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class PisoInteligenteBO {

    private PisoInteligenteDAO pisoDAO;

    public PisoInteligenteBO() {
        this.pisoDAO = new PisoInteligenteDAO();
    }

    // Método para salvar um novo piso inteligente
    public void salvarPiso(PisoInteligente piso) {
        try {
            pisoDAO.salvar(piso);
            JOptionPane.showMessageDialog(null, "Piso inteligente salvo com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar piso inteligente: " + e.getMessage());
        }
    }

    // Método para listar todos os pisos inteligentes
    public List<PisoInteligente> listarPisos() {
        try {
            return pisoDAO.listar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pisos inteligentes: " + e.getMessage());
            return null;
        }
    }

    // Método para atualizar um piso inteligente existente
    public void atualizarPiso(PisoInteligente piso) {
        try {
            pisoDAO.atualizar(piso);
            JOptionPane.showMessageDialog(null, "Piso inteligente atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar piso inteligente: " + e.getMessage());
        }
    }

    // Método para excluir um piso inteligente pelo ID
    public void excluirPiso(int id) {
        try {
            pisoDAO.excluir(id);
            JOptionPane.showMessageDialog(null, "Piso inteligente excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir piso inteligente: " + e.getMessage());
        }
    }
}
