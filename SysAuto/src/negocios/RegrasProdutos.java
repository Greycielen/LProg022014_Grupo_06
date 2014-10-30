package negocios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.ModeloProduto;
import persistencia.Persistencia;

public class RegrasProdutos {

	Persistencia bancodedados = new Persistencia();

	public void conecta() throws SQLException, IOException {
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
