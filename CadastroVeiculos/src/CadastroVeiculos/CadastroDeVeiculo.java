package CadastroVeiculos;

public class CadastroDeVeiculo {
    private String modelo;
    private String cor;
    private String placa;
    private String proprietario;
    private String contato;
    private int ano;
    
    public String getModelo(){
        return modelo;
        
    }
    
    public String getCor(){
        return cor;
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public String getProprietario(){
        return proprietario;
    }
    
    public String getcontato(){
        return contato;
    }
    
    public int getAno(){
        return ano;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca (String placa){
        this.placa = placa;
    }
    
    public void setProprietario(String proprietario){
        this.proprietario = proprietario;
    }
    
    public void setContato (String contato){
        this.contato = contato;
    }
    
    public void setAno(int ano){
        this.ano = ano;
    }

}