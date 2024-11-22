package br.com.fiap.main;

import br.com.fiap.dao.*;
import br.com.fiap.beans.*;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // Instanciando os DAOs
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            ConfiguracaoSistemaDAO configuracaoDAO = new ConfiguracaoSistemaDAO();
            PisoInteligenteDAO pisoDAO = new PisoInteligenteDAO();
            NotificacaoDAO notificacaoDAO = new NotificacaoDAO();

            // Requisitar dados do usuário primeiro
            Usuario usuario = obterUsuario();
            usuarioDAO.salvar(usuario);

            // Inserir outros dados
            ConfiguracaoSistema config = obterConfiguracao();
            configuracaoDAO.salvar(config);

            PisoInteligente piso = obterPisoInteligente();
            pisoDAO.salvar(piso);

            Notificacao notificacao = obterNotificacao();
            notificacaoDAO.salvar(notificacao);

            // Listar configurações
            listarConfiguracoes(configuracaoDAO);

            // Atualizar configuração
            atualizarConfiguracao(configuracaoDAO);

            // Excluir um usuário
            excluirUsuario(usuarioDAO);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    private static Usuario obterUsuario() {
        String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
        String email = JOptionPane.showInputDialog("Digite o email do usuário:");
        String senha = JOptionPane.showInputDialog("Digite a senha do usuário:");
        return new Usuario(0, nome, email, senha); // ID será gerado automaticamente
    }

    private static ConfiguracaoSistema obterConfiguracao() {
        String chave = JOptionPane.showInputDialog("Digite a chave da configuração:");
        String valor = JOptionPane.showInputDialog("Digite o valor da configuração:");
        return new ConfiguracaoSistema(0, chave, valor); // ID será gerado automaticamente
    }

    private static PisoInteligente obterPisoInteligente() {
        String localizacao = JOptionPane.showInputDialog("Digite a localização do piso:");
        double energiaGerada = Double.parseDouble(JOptionPane.showInputDialog("Digite a energia gerada pelo piso:"));
        return new PisoInteligente(0, localizacao, energiaGerada); // ID será gerado automaticamente
    }

    private static Notificacao obterNotificacao() {
        String mensagem = JOptionPane.showInputDialog("Digite a mensagem da notificação:");
        String dataHora = JOptionPane.showInputDialog("Digite a data e hora da notificação (yyyy-MM-dd HH:mm:ss):");
        return new Notificacao(0, mensagem, dataHora); // ID será gerado automaticamente
    }

    private static void listarConfiguracoes(ConfiguracaoSistemaDAO configuracaoDAO) throws Exception {
        List<ConfiguracaoSistema> configuracoes = configuracaoDAO.listar();
        StringBuilder lista = new StringBuilder("Configurações do sistema:\n");
        for (ConfiguracaoSistema c : configuracoes) {
            lista.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    private static void atualizarConfiguracao(ConfiguracaoSistemaDAO configuracaoDAO) throws Exception {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da configuração a ser atualizada:"));
        ConfiguracaoSistema config = new ConfiguracaoSistema(
                id,
                JOptionPane.showInputDialog("Digite a nova chave da configuração:"),
                JOptionPane.showInputDialog("Digite o novo valor da configuração:")
        );
        configuracaoDAO.atualizar(config);
        JOptionPane.showMessageDialog(null, "Configuração atualizada com sucesso!");
    }

    private static void excluirUsuario(UsuarioDAO usuarioDAO) throws Exception {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuário para exclusão:"));
        usuarioDAO.excluir(id);
        JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
    }
}
