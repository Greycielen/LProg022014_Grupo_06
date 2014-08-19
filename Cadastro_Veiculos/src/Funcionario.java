public class Funcionario {
	private String nome;
	private String login;
	private String senha;
	private String enquadramento_funcional;

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getEnquadramento_funcional() {
		return enquadramento_funcional;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;

	}

	public void setEnquadramento_funcional(String enquadramento_funcional) {
		this.enquadramento_funcional = enquadramento_funcional;
	}

}
