package Negocios;

import javax.swing.JComboBox;
import Modelos.ModeloProduto;
import Persistencia.Persistencia;

public class RegrasProdutos {

	Persistencia bancodedados = new Persistencia();

	public void consultaProduto(ModeloProduto produto) {
		bancodedados.consultarProduto(produto);
	}

	public void preencheCombo(JComboBox<String> comboProduto) {
		bancodedados.preencherComboProdutos(comboProduto);
	}

	public void excluiProduto(ModeloProduto produto) {
		bancodedados.excluirProduto(produto);
	}

	public void cadastraProduto(ModeloProduto produto) {
		bancodedados.salvarProduto(produto);
	}

	public void atualizaProduto(ModeloProduto produto) {
		bancodedados.alterarProduto(produto);
	}

}
