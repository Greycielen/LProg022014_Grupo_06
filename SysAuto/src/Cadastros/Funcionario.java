package Cadastros;

public class Funcionario {
	private String nome;
	private String enquadramento_funcional;
	private String login;
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnquadramento_funcional() {
		return enquadramento_funcional;
	}

	public void setEnquadramento_funcional(String enquadramento_funcional) {
		this.enquadramento_funcional = enquadramento_funcional;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}