package Cadastros;

import java.util.ArrayList;

public class BancoDeDados {

	private ArrayList<Veiculo> listaVeiculos;
	private ArrayList<Funcionario> listaFuncionarios;

	public BancoDeDados() {
		listaVeiculos = new ArrayList<Veiculo>();
		listaFuncionarios = new ArrayList<Funcionario>();
	}

	public void salvarFuncionario(Funcionario cadastro) {
		listaFuncionarios.add(cadastro);
	}

	public void salvarVeiculo(Veiculo cadastro) {
		listaVeiculos.add(cadastro);
	}

	public Veiculo getVeiculo(String placa) {
		for (Veiculo veiculo : listaVeiculos) {
			if (veiculo.getPlaca().contentEquals(placa)) {
				return veiculo;
			}
		}
		return null;
	}

	public Funcionario getFuncionario(String login) {
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getLogin().contentEquals(login)) {
				return funcionario;
			}
		}
		return null;
	}
}