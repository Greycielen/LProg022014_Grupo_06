import java.util.Scanner;

public class Cadastro {


	public static void main() {
		DadosCadastro data = new DadosCadastro();

		menu();
		int opcao = lerOpcao();

		switch (opcao) {
		case 1:
			Funcionario func = obter_dados();
			data.armazenarDados(func);
			break;

		case 2:
			consultarDados(data);
			alterarDados();
			break;

		case 3:
			break;

		default:
			break;
		}

	}

	private static void alterarDados() {
		
	}

	private static void consultarDados(DadosCadastro data) {
		Funcionario func = data.consultarDados();
		//Exibir os dados
		System.out.println("Nome: " + func.getNome());
		System.out.println("Login: " + func.getLogin());
		System.out.println("Enquadramento Funcional: " + func.getEnquadramento_funcional());
	}

	private static int lerOpcao() {
		Scanner leitor = new Scanner(System.in);
		int opcao = leitor.nextInt();
		return opcao;
	}

	private static void menu() {
		System.out
				.println("Bem-vindo ao cadastro, selecione a opção desejada:");
		System.out.println("1) Cadastrar Usuario");
		System.out.println("2) Alterar Dados de Usuario");
		System.out.println("3) Excluir Usuario");
	}
	
	private static Funcionario obterDados() {
		Scanner leitor = new Scanner(System.in);
		Funcionario func = new Funcionario();
		
		System.out.println("Digite o nome do usuario");
		String nome = leitor.next();
		func.setNome(nome);

		System.out.println("Digite o login do usuario");
		String login = leitor.next();
		func.setLogin(login);

		System.out.println("Digite uma senha para o usuario");
		String senha = leitor.next();
		func.setLogin(senha);

		System.out.println("Qual o enquadramento funcional (cargo) do usuario ?");
		String enquadramento_funcional = leitor.next();
		func.setEnquadramento_funcional(enquadramento_funcional);		
	}
}
