package CadastroVeiculos;

import java.util.ArrayList;

public class BancoDeDados {
    
    private ArrayList<CadastroDeVeiculo> listaCadastro;
    
    //Método construtor
    public BancoDeDados() {
        listaCadastro = new ArrayList<CadastroDeVeiculo>();
    }
    
    //Método para cadastrar veículos.
    public void cadastrarVeiculo(CadastroDeVeiculo cadastro){
        listaCadastro.add(cadastro);
    }
    
}

