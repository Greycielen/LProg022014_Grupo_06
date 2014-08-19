import java.util.ArrayList;
import java.util.Scanner;


public class DadosCadastro {
	public ArrayList<Funcionario> funcionarios;

	public DadosCadastro() {
		funcionarios = new ArrayList<Funcionario>();
	}
	

	public Funcionario consultarDados(){
		return funcionarios.get(0);
	}
	
	public Funcionario consultarDados(String nome){
		for (Funcionario func : funcionarios) {
			if(func.getNome()==nome)
				return func;
		}
		
		for (int i = 0; i < funcionarios.size(); i++) {
			if(funcionarios.get(i).getNome() == nome)
				return funcionarios.get(i);
		}
		return null;
	}
	
	
	
	public void armazenarDados(Funcionario funcionario) {
		this.funcionarios.add(funcionario);
	}

}