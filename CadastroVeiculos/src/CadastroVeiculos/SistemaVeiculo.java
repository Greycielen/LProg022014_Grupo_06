package CadastroVeiculos;

import java.util.Scanner;

public class SistemaVeiculo {
    
    private BancoDeDados banco;
    
    private void escreverOpcoes() {
        System.out.println("------------------------");
        System.out.println("Cadastro de Veiculos");
        System.out.println();
        System.out.println("Opções:");
        System.out.println("1-Cadastrar veículo");
        System.out.println("9-Fechar");
        
    }
    
    public void iniciar() {
        
        banco = new BancoDeDados();
        escreverOpcoes(); //Chamou o método escreverOpções.
                
        Scanner teclado = new Scanner(System.in);
        int opcao = teclado.nextInt();
        
        while (opcao != 9){
            switch (opcao){
                case 1:
                    cadastrarVeiculo();
                    break;
         
            }
            
            escreverOpcoes();
            opcao = teclado.nextInt();
        }
    }
    
    public void cadastrarVeiculo(){
        Scanner scanner = new Scanner(System.in);
        
        CadastroDeVeiculo veiculo = new CadastroDeVeiculo();
        
        System.out.println("1-Cadastro de veículos");
        System.out.println();
        
        System.out.println("Digite o modelo");
        veiculo.setModelo(scanner.nextLine());
        
        System.out.println("Digite a cor");
        veiculo.setCor(scanner.nextLine());
        
        System.out.println("Digite a placa");
        veiculo.setPlaca(scanner.nextLine());
        
        System.out.println("Digite o proprietário");
        veiculo.setProprietario(scanner.nextLine());
        
        System.out.println("Digite o ano");
        veiculo.setAno(scanner.nextInt());
        
        banco.cadastrarVeiculo(veiculo);
    }
    
    public static void main(String[] args) {
        SistemaVeiculo sistema = new SistemaVeiculo();
        sistema.iniciar();
    }
}
