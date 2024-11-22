package br.com.fiap.bo;

import br.com.fiap.beans.EnergiaHistorica;
import br.com.fiap.dao.EnergiaHistoricaDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class EnergiaHistoricaBO {

    private EnergiaHistoricaDAO energiaDAO;

    public EnergiaHistoricaBO() {
        this.energiaDAO = new EnergiaHistoricaDAO();
    }

    // Método para salvar um novo registro de energia histórica
    public void salvarEnergiaHistorica(EnergiaHistorica energia) {
        try {
            energiaDAO.salvar(energia);
            JOptionPane.showMessageDialog(null, "Registro de energia histórica salvo com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar energia histórica: " + e.getMessage());
        }
    }

    // Método para listar todos os registros de energia histórica
    public List<EnergiaHistorica> listarEnergiaHistorica() {
        try {
            return energiaDAO.listar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar energia histórica: " + e.getMessage());
            return null;
        }
    }

    // Método para atualizar um registro de energia histórica
    public void atualizarEnergiaHistorica(EnergiaHistorica energia) {
        try {
            energiaDAO.atualizar(energia);
            JOptionPane.showMessageDialog(null, "Energia histórica atualizada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar energia histórica: " + e.getMessage());
        }
    }

    // Método para excluir um registro de energia histórica pelo ID
    public void excluirEnergiaHistorica(int id) {
        try {
            energiaDAO.excluir(id);
            JOptionPane.showMessageDialog(null, "Registro de energia histórica excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir energia histórica: " + e.getMessage());
        }
    }
}
