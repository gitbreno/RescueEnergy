package br.com.fiap.excecoes;

import java.sql.SQLException;

public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;

	public CustomException() {
		super("Uma exceção personalizada ocorreu.");
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(Exception e) {
		super(e);
		handleException(e);
	}

	private void handleException(Exception e) {
		if (e instanceof ClassNotFoundException) {
			System.out.println("Falha no Driver");
		} else if (e instanceof SQLException) {
			System.out.println("Falha nas informações de comunicação com o Banco de Dados");
		} else {
			System.out.println("Falha Desconhecida");
		}
		e.printStackTrace();
	}
}
