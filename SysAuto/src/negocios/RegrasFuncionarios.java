package negocios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.ModeloFuncionario;
import persistencia.Persistencia;

public class RegrasFuncionarios {

	Persistencia bancodedados = new Persistencia();

	public void conecta() throws SQLException, IOException {
		bancodedados.conexao();
	}

	public void desconecta() throws SQLException {
		bancodedados.disconnection();
	}

	public ModeloFuncionario consultaFuncionario(String nome) throws SQLException {
		return bancodedados.consultarFuncionario(nome);
	}

	public ModeloFuncionario consultaFuncionarioLogin(String login) throws SQLException {
		return bancodedados.consultarFuncionarioLogin(login);
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