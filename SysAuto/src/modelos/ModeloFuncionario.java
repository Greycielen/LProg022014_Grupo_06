package modelos;

public class ModeloFuncionario {
	private String nome;
	private String enquadramento_funcional;
	private String login;
	private String senha;
	private String nivel_acesso;

	public String getNivel_acesso() {
		return nivel_acesso;
	}

	public void setNivel_acesso(String nivel_acesso) {
		this.nivel_acesso = nivel_acesso;
	}

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
