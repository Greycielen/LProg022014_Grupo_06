package Negocios;

import javax.swing.JComboBox;
import Modelos.ModeloVeiculo;
import Persistencia.Persistencia;

public class RegrasVeiculos {
	Persistencia bancodedados = new Persistencia();

	public void consultaVeiculo(ModeloVeiculo veiculo) {
		bancodedados.consultarVeiculo(veiculo);
	}

	public void preencheCombo(JComboBox<String> comboVeiculo) {
		bancodedados.preencherComboVeiculos(comboVeiculo);
	}

	public void excluiVeiculo(ModeloVeiculo veiculo) {
		bancodedados.conexao();
		String placa = veiculo.getPlaca();
		bancodedados.excluirVeiculo(placa);
	}

	public void cadastraVeiculo(ModeloVeiculo veiculo) {
		bancodedados.salvarVeiculo(veiculo);
	}

	public void atualizaVeiculo(ModeloVeiculo veiculo) {
		bancodedados.alterarVeiculo(veiculo);
	}
}