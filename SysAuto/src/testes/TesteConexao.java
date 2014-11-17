package testes;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.junit.Test;

import persistencia.Persistencia;

public class TesteConexao {

	@Test
	public void test() {

		Persistencia db = new Persistencia();

		try {

			db.conexao();
			JOptionPane.showMessageDialog(null, "Conectado com sucesso!");

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}

		try {

			Thread.sleep(2000);

		} catch (InterruptedException ex) {

			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}

		try {

			db.desconexao();
			JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");

		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Descrição do erro:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

		}

	}

}
