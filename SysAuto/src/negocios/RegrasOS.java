package negocios;

import java.sql.SQLException;

import persistencia.Persistencia;

public class RegrasOS {

	Persistencia bancodedados = new Persistencia();

	public void conecta() throws SQLException {

		bancodedados.conexao();

	}

	public void desconecta() throws SQLException {

		bancodedados.desconexao();

	}

}
