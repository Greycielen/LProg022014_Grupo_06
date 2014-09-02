package CadastroVeiculos;

import java.util.Scanner;

public class InterfaceCadastro {

	private BancoDeDados banco;

	private void escreverOpcoes() {
		System.out.printlnpackage CadastroVeiculos;

import java.util.Scanner;

public class InterfaceCadastro {

	private BancoDeDados banco;

	private void escreverOpcoes() {
		System.out.println("Bem vindo ao Cadastro de Veículos, digite a opção desejada:");
		System.out.println();
		System.out.println("1) Cadastrar veículo");
		System.out.println("2) Consultar/Alterar cadastro de veículo");
		System.out.println("3) Excluir cadastro de veículo");
		System.out.println("4) Sair");

	}

	public void iniciar() {

		banco = new BancoDeDados();
		escreverOpcoes(); // Chamou o método escreverOpções.

		Scanner teclado = new Scanner(System.in);
		int opcao = teclado.nextInt();

		while (opcao != 4) {
			switch (opcao) {
			case 1:
				cadastrarVeiculo();
				break;package CadastroVeiculos;

import java.util.Scanner;

public class InterfaceCadastro {

	private BancoDeDados banco;

	private void escreverOpcoes() {
		System.out.println("Bem vindo ao Cadastro de Veículos, digite a opção desejada:");
		System.out.println();
		System.out.println("1) Cadastrar veículo");
		System.out.println("2) Consultar/Alterar cadastro de veículo");
		System.out.println("3) Excluir cadastro de veículo");
		System.out.println("4) Sair");

	}

	public void iniciar() {

		banco = new BancoDeDados();
		escreverOpcoes(); // Chamou o método escreverOpções.

		Scanner teclado = new Scanner(System.in);
		int opcao = teclado.nextInt();

		while (opcao != 4) {
			switch (opcao) {
			case 1:
				cadastrarVeiculo();
				break;
			case 2:
				String placa = "JHE3064";
				consultarVeiculo(banco, placa);
			}
			escreverOpcoes();
			opcao = teclado.nextInt();
		}
	}

	private void consultarVeiculo(BancoDeDados banco, String placa) {
		Carro veiculo = banco.getVeiculo(placa);
		if (veiculo == null) {
			System.out.println("Veículo não cadastrado!");
		}

		System.out.println("Modelo: " + veiculo.getModelo());
		System.out.println("Cor: " + veiculo.getCor());
		System.out.println("Placa: " + veiculo.getPlaca());
		System.out.println("Ano de Fabricação: " + veiculo.getAno());
		System.out.println("Nome do Proprietário: " + veiculo.getProprietario());
		System.out.println("Contato do Proprietário: " + veiculo.getContato() + "\n");
	}

	public void cadastrarVeiculo() {
		Scanner scanner = new Scanner(System.in);

		Carro veiculo = new Carro();

		System.out.println("1) Cadastro de veículos");

		System.out.println();

		System.out.println("Digite o modelo do veículo");
		veiculo.setModelo(scanner.nextLine());

		System.out.println("Digite a cor do veículo");
		veiculo.setCor(scanner.nextLine());

		System.out.println("Digite a placa do veículo");
		veiculo.setPlaca(scanner.nextLine());

		System.out.println("Digite o nome do proprietário do veículo");
		veiculo.setProprietario(scanner.nextLine());

		System.out.println("Digite o contato do proprietário do veículo");
		veiculo.setContato(scanner.nextLine());

		System.out.println("Digite o ano de fabricação do veículo");
		veiculo.setAno(scanner.nextInt());

		banco.cadastrarVeiculo(veiculo);
	}

	public static void main(String[] args) {
		InterfaceCadastro sistema = new InterfaceCadastro();
		sistema.iniciar();
	}
}

			case 2:
				String placa = "JHE3064";
				consultarVeiculo(banco, placa);
			}
			escreverOpcoes();
			opcao = teclado.nextInt();
		}
	}

	private void consultarVeiculo(BancoDeDados banco, String placa) {
		Carro veiculo = banco.getVeiculo(placa);
		if (veiculo == null) {
			System.out.println("Veículo não cadastrado!");
		}

		System.out.println("Modelo: " + veiculo.getModelo());
		System.out.println("Cor: " + veiculo.getCor());
		System.out.println("Placa: " + veiculo.getPlaca());
		System.out.println("Ano de Fabricação: " + veiculo.getAno());
		System.out.println("Nome do Proprietário: " + veiculo.getProprietario());
		System.out.println("Contato do Proprietário: " + veiculo.getContato() + "\n");
	}

	public void cadastrarVeiculo() {
		Scanner scanner = new Scanner(System.in);

		Carro veiculo = new Carro();

		System.out.println("1) Cadastro de veículos");

		System.out.println();

		System.out.println("Digite o modelo do veículo");
		veiculo.setModelo(scanner.nextLine());

		System.out.println("Digite a cor do veículo");
		veiculo.setCor(scanner.nextLine());

		System.out.println("Digite a placa do veículo");
		veiculo.setPlaca(scanner.nextLine());

		System.out.println("Digite o nome do proprietário do veículo");
		veiculo.setProprietario(scanner.nextLine());

		System.out.println("Digite o contato do proprietário do veículo");
		veiculo.setContato(scanner.nextLine());

		System.out.println("Digite o ano de fabricação do veículo");
		veiculo.setAno(scanner.nextInt());

		banco.cadastrarVeiculo(veiculo);
	}

	public static void main(String[] args) {
		InterfaceCadastro sistema = new InterfaceCadastro();
		sistema.iniciar();
	}
}
("Bem vindo ao Cadastro de Veículos, digite a opção desejada:");
		System.out.println();
		System.out.println("1) Cadastrar veículo");
		System.out.println("2) Consultar/Alterar cadastro de veículo");
		System.out.println("3) Excluir cadastro de veículo");
		System.out.println("4) Sair");

	}

	public void iniciar() {

		banco = new BancoDeDados();
		escreverOpcoes(); // Chamou o método escreverOpções.

		Scanner teclado = new Scanner(System.in);
		int opcao = teclado.nextInt();

		while (opcao != 4) {
			switch (opcao) {
			case 1:
				cadastrarVeiculo();
				break;
			case 2:
				String placa = "JHE3064";
				consultarVeiculo(banco, placa);
			}
			escreverOpcoes();
			opcao = teclado.nextInt();
		}
	}

	private void consultarVeiculo(BancoDeDados banco, String placa) {
		Carro veiculo = banco.getVeiculo(placa);
		if (veiculo == null) {
			System.out.println("Veículo não cadastrado!");
		}

		System.out.println("Modelo: " + veiculo.getModelo());
		System.out.println("Cor: " + veiculo.getCor());
		System.out.println("Placa: " + veiculo.getPlaca());
		System.out.println("Ano de Fabricação: " + veiculo.getAno());
		System.out.println("Nome do Proprietário: " + veiculo.getProprietario());
		System.out.println("Contato do Proprietário: " + veiculo.getContato() + "\n");
	}

	public void cadastrarVeiculo() {
		Scanner scanner = new Scanner(System.in);

		Carro veiculo = new Carro();

		System.out.println("1) Cadastro de veículos");

		System.out.println();

		System.out.println("Digite o modelo do veículo");
		veiculo.setModelo(scanner.nextLine());

		System.out.println("Digite a cor do veículo");
		veiculo.setCor(scanner.nextLine());

		System.out.println("Digite a placa do veículo");
		veiculo.setPlaca(scanner.nextLine());

		System.out.println("Digite o nome do proprietário do veículo");
		veiculo.setProprietario(scanner.nextLine());

		System.out.println("Digite o contato do proprietário do veículo");
		veiculo.setContato(scanner.nextLine());

		System.out.println("Digite o ano de fabricação do veículo");
		veiculo.setAno(scanner.nextInt());

		banco.cadastrarVeiculo(veiculo);
	}

	public static void main(String[] args) {
		InterfaceCadastro sistema = new InterfaceCadastro();
		sistema.iniciar();
	}
}
