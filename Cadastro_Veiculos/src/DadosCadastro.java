import java.util.Scanner;


public class DadosCadastro {
	public Funcionario func;

	public DadosCadastro() {
		this.func = new Funcionario();
	}
	

	public Funcionario consultarDados(){
		return func;
	}
	
	public void armazenarDados(Funcionario funcionario) {
		this.func = funcionario;
	}

}