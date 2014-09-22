package Negocios;

import javax.swing.JComboBox;
import Modelos.*;
import Persistencia.Persistencia;

public class RegrasFuncionarios {

	Persistencia bancodedados = new Persistencia();
	Teste teste = new Teste();

	public void consultaFuncionario(ModeloFuncionario funcionario) {
		bancodedados.consultarFuncionario(funcionario);
	}

	public void preencheCombo(JComboBox<String> comboFuncionario) {
		bancodedados.preencherComboFuncionarios(comboFuncionario);
	}

	public void excluiFuncionario(ModeloFuncionario funcionario) {
		bancodedados.conexao();
		String login = funcionario.getLogin();
		bancodedados.excluirFuncionario(login);
	}

	public void cadastraFuncionario(ModeloFuncionario funcionario) {
		bancodedados.salvarFuncionario(funcionario);
	}

	public void atualizaFuncionario(ModeloFuncionario funcionario) {
		bancodedados.alterarFuncionario(funcionario);
	}
}