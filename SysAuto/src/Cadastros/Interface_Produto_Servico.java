package Cadastros;

import java.util.Scanner;

public class Interface_ProdutosServi�os {

	private BancoDeDados banco;

	private void escreverOpcoes() {
		System.out.println("Bem vindo ao Cadastro de Produtos e Servi�os, digite a op��o desejada:");
		System.out.println();
		System.out.println("1) Cadastrar Produtos e Servi�os");
		System.out.println("2) Consultar/Alterar cadastro de Produtos e Servi�os");
		System.out.println("3) Excluir cadastro de Produtos e Servi�os");
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
				cadastrarProduto_Servi�os();
				break;
			case 2:
				System.out.println("\n" + "2) Consultar/Alterar cadastro de produto e servi�o" + "\n");
				System.out.println("Digite o codigo do produto ou servi�o:");
				String codigo = teclado.next();
				consultarProduto_Servi�o(banco, codigo);
			}
			escreverOpcoes();
			opcao = teclado.nextInt();
		}
	}

	private void consultarProduto_Servi�o(BancoDeDados banco, String codigo) {
		codigo = banco.getProduto_Servi�o(codigo);
		if (produto_servi�o == null) {
			System.out.println("Produto ou Servi�o n�o cadastrado!");
		}

		System.out.println("\n" + "nome " + codigo.getNome());
		System.out.println("Enquandramento: " + codigo.getEnquadramento());
        System.out.println("Valor: " + codigo.getValor() + "\n");
	}

	public void cadastrarProduto_Servi�o() {
		Scanner scanner = new Scanner(System.in);

		Produto_Servi�o produto_servi�o = new Produto_Servi�o();

		System.out.println("\n" + "1) Cadastro de produto e servi�o");

		System.out.println();

		System.out.println("Digite o nome  do produto ou servi�o");
		veiculo.setModelo(scanner.nextLine());

		System.out.println("Digite o enquadramento do produto ou servi�o");
		veiculo.setCor(scanner.nextLine());

		System.out.println("Digite o valor  do produto ou servi�o");
		veiculo.setPlaca(scanner.nextLine());

		banco.salvarProduto_Servi�o(produto_servi�o);
	}

	public static void main(String[] args) {
		Interface_Produto_Servi�o sistema = new Interface_Produto_Servi�o();
		sistema.iniciar();
	}
}