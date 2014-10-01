package Testes;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.junit.Test;

import Persistencia.Persistencia;

public class Teste_Conexao_DB {

	Persistencia bancodedados = new Persistencia();

	@Test
	public void test() {
		try {
			bancodedados.conexao();
			JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}

		try {
			bancodedados.desconexao();
			JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
		}
	}

}
