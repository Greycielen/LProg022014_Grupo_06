package negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import modelos.ModeloFuncionario;
import persistencia.Persistencia_DB;

public class RegrasFuncionarios {

	Persistencia_DB bancodedados = new Persistencia_DB();

	public void conecta() throws SQLException {
		bancodedados.conexao();
	}

	public void desconecta() throws SQLException {
		bancodedados.disconnection();
	}

	public ModeloFuncionario consultaFuncionario(String nome)
			throws SQLException {
		return bancodedados.consultarFuncionario(nome);
	}

	public ModeloFuncionario consultaFuncionarioLogin(String login)
			throws SQLException {
		return bancodedados.consultarFuncionarioLogin(login);
	}

	public ArrayList<String> listaFuncionarios() throws SQLException {
		return bancodedados.listarFuncionarios();
	}

	public void excluiFuncionario(String login) throws SQLException {
		bancodedados.excluirFuncionario(login);
	}

	public void cadastraFuncionario(ModeloFuncionario funcionario)
			throws SQLException {
		bancodedados.salvarFuncionario(funcionario);
	}

	public void atualizaFuncionario(ModeloFuncionario funcionario)
			throws SQLException {
		bancodedados.alterarFuncionario(funcionario);
	}
}