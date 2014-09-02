package CadastroVeiculos;

import java.util.ArrayList;

public class BancoDeDados {

	private ArrayList<Carro> listaCadastro;

	// Método construtor
	public BancoDeDados() {
		listaCadastro = new ArrayList<Carro>();
	}

	// Método para cadastrar veículos.
	public void cadastrarVeiculo(Carro cadastro) {
		listaCadastro.add(cadastro);
	}

	public Carro getVeiculo(String placa) {
		for (Carro veiculo : listaCadastro) {
			if (veiculo.getPlaca().contentEquals(placa)) {
				return veiculo;
			}
		}
		return null;
	}

}
