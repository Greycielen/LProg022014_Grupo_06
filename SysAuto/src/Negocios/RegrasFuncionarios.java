package Negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import Modelos.ModeloFuncionario;
import Persistencia.Persistencia;

public class RegrasFuncionarios {

	Persistencia bancodedados = new Persistencia();

	public void conecta() throws SQLException {
		bancodedados.conexao();
	}

	public void desconecta() throws SQLException {
		bancodedados.desconexao();
	}

	public ModeloFuncionario consultaFuncionario(String nome) throws SQLException {
		return bancodedados.consultarFuncionario(nome);
	}

	public ArrayList<String> listaFuncionarios() throws SQLException {
		return bancodedados.listarFuncionarios();
	}

	public void excluiFuncionario(String login) throws SQLException {
		bancodedados.excluirFuncionario(login);
	}

	public void cadastraFuncionario(ModeloFuncionario funcionario) throws SQLException {
		bancodedados.salvarFuncionario(funcionario);
	}

	public void atualizaFuncionario(ModeloFuncionario funcionario) throws SQLException {
		bancodedados.alterarFuncionario(funcionario);
	}
}