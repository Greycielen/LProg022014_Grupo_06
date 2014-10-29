package modelos;

public class ModeloProduto {
	private String codigo;
	private String nome;
	private String enquadramento;
	private String valor;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnquadramento() {
		return enquadramento;
	}

	public void setEnquadramento(String enquadramento) {
		this.enquadramento = enquadramento;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}