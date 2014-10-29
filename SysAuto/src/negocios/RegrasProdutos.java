package negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import modelos.ModeloProduto;
import persistencia.Persistencia_DB;

public class RegrasProdutos {

	Persistencia_DB bancodedados = new Persistencia_DB();

	public void conecta() throws SQLException {
		bancodedados.conexao();
	}

	public void desconecta() throws SQLException {
		bancodedados.disconnection();
	}

	public ModeloProduto consultaProduto(String codigo) throws SQLException {
		return bancodedados.consultarProduto(codigo);
	}

	public ArrayList<String> listaProdutos() throws SQLException {
		return bancodedados.listarProdutos();
	}

	public void excluiProduto(String codigo) throws SQLException {
		bancodedados.excluirProduto(codigo);
	}

	public void cadastraProduto(ModeloProduto produto) throws SQLException {
		bancodedados.salvarProduto(produto);
	}

	public void atualizaProduto(ModeloProduto produto) throws SQLException {
		bancodedados.alterarProduto(produto);
	}

}
