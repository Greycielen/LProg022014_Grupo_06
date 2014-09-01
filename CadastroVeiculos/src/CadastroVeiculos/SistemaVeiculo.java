package CadastroVeiculos;

import java.util.Scanner;

public class SistemaVeiculo {
    
    private BancoDeDados banco;
    
    private void escreverOpcoes() {
        System.out.println("------------------------");
        System.out.println("Cadastro de Veículos");
        System.out.println();
        System.out.println("Digite o número da opção desejada");
        System.out.println("1) Cadastrar veículo");
        System.out.println("9) Fechar");
        
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
        
        System.out.println("Digite o contato do proprietário do 	veículo");
        veiculo.setContato(scanner.nextLine());
        
        System.out.println("Digite o ano de fabricação do veículo");
        veiculo.setAno(scanner.nextInt());
        
        banco.cadastrarVeiculo(veiculo);
    }
    
    public static void main(String[] args) {
        SistemaVeiculo sistema = new SistemaVeiculo();
        sistema.iniciar();
    }
}
