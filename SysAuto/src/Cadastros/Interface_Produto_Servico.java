package Cadastros;

import java.util.Scanner;

public class Interface_ProdutosServiços {

	private BancoDeDados banco;

	private void escreverOpcoes() {
		System.out.println("Bem vindo ao Cadastro de Produtos e Serviços, digite a opção desejada:");
		System.out.println();
		System.out.println("1) Cadastrar Produtos e Serviços");
		System.out.println("2) Consultar/Alterar cadastro de Produtos e Serviços");
		System.out.println("3) Excluir cadastro de Produtos e Serviços");
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
				cadastrarProduto_Serviços();
				break;
			case 2:
				System.out.println("\n" + "2) Consultar/Alterar cadastro de produto e serviço" + "\n");
				System.out.println("Digite o codigo do produto ou serviço:");
				String codigo = teclado.next();
				consultarProduto_Serviço(banco, codigo);
			}
			escreverOpcoes();
			opcao = teclado.nextInt();
		}
	}

	private void consultarProduto_Serviço(BancoDeDados banco, String codigo) {
		codigo = banco.getProduto_Serviço(codigo);
		if (produto_serviço == null) {
			System.out.println("Produto ou Serviço não cadastrado!");
		}

		System.out.println("\n" + "nome " + codigo.getNome());
		System.out.println("Enquandramento: " + codigo.getEnquadramento());
        System.out.println("Valor: " + codigo.getValor() + "\n");
	}

	public void cadastrarProduto_Serviço() {
		Scanner scanner = new Scanner(System.in);

		Produto_Serviço produto_serviço = new Produto_Serviço();

		System.out.println("\n" + "1) Cadastro de produto e serviço");

		System.out.println();

		System.out.println("Digite o nome  do produto ou serviço");
		veiculo.setModelo(scanner.nextLine());

		System.out.println("Digite o enquadramento do produto ou serviço");
		veiculo.setCor(scanner.nextLine());

		System.out.println("Digite o valor  do produto ou serviço");
		veiculo.setPlaca(scanner.nextLine());

		banco.salvarProduto_Serviço(produto_serviço);
	}

	public static void main(String[] args) {
		Interface_Produto_Serviço sistema = new Interface_Produto_Serviço();
		sistema.iniciar();
	}
}