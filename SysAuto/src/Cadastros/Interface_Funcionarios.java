package Cadastros;

import java.util.Scanner;

public class Interface_Funcionarios {

	private BancoDeDados banco;

	private void escreverOpcoes() {
		System.out.println("\n" + "Bem vindo ao Cadastro de Funcionarios, digite a opção desejada:");
		System.out.println();
		System.out.println("1) Cadastrar funcionário");
		System.out.println("2) Consultar/Alterar cadastro de funcionário");
		System.out.println("3) Excluir cadastro de funcionário");
		System.out.println("4) Sair");
	}

	public void iniciar() {

		banco = new BancoDeDados();
		escreverOpcoes();

		Scanner teclado = new Scanner(System.in);
		int opcao = teclado.nextInt();

		while (opcao != 4) {
			switch (opcao) {
			case 1:
				cadastrarFuncionario();
				break;
			case 2:
				System.out.println("\n" + "2) Consultar/Alterar cadastro de funcionário" + "\n");
				System.out.println("Digite o login do funcionário:");
				String login = teclado.next();
				consultarFuncionario(banco, login);
			}
			escreverOpcoes();
			opcao = teclado.nextInt();
		}
	}

	private void consultarFuncionario(BancoDeDados banco, String login) {
		Funcionario funcionario = banco.getFuncionario(login);
		if (funcionario == null) {
			System.out.println("Funcionario não cadastrado!");
		}

		System.out.println("\n" + "Nome: " + funcionario.getNome());
		System.out.println("login: " + funcionario.getLogin());
		System.out.println("Senha: ********");
		System.out.println("Enquadramento Funcional: " + funcionario.getEnquadramento_funcional());
	}

	public void cadastrarFuncionario() {
		Scanner scanner = new Scanner(System.in);

		Funcionario funcionario = new Funcionario();

		System.out.println("\n" + "1) Cadastro de funcionários");

		System.out.println();

		System.out.println("Digite o nome do funcionário");
		funcionario.setNome(scanner.nextLine());

		System.out.println("Digite o login do funcionário");
		funcionario.setLogin(scanner.nextLine());

		System.out.println("Peça ao funcionário que digite uma senha");
		funcionario.setSenha(scanner.nextLine());

		System.out.println("Digite o enquadramento funcional do funcionário");
		funcionario.setEnquadramento_funcional(scanner.nextLine());

		banco.salvarFuncionario(funcionario);
	}

	public static void main(String[] args) {
		Interface_Funcionarios sistema = new Interface_Funcionarios();
		sistema.iniciar();
	}
}