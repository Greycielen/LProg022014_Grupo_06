package Cadastros;

import java.util.ArrayList;

public class BancoDeDados {

	private ArrayList<Veiculo> listaCadastro;

	// Método construtor
	public BancoDeDados() {
		listaCadastro = new ArrayList<Veiculo>();
	}

	// Método para cadastrar veículos.
	public void cadastrarVeiculo(Veiculo cadastro) {
		listaCadastro.add(cadastro);
	}

	public Veiculo getVeiculo(String placa) {
		for (Veiculo veiculo : listaCadastro) {
			if (veiculo.getPlaca().contentEquals(placa)) {
				return veiculo;
			}
		}
		return null;
	}

}
