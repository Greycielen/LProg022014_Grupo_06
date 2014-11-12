package modelos;

public class ModeloOS {

	private int codigo;
	private ModeloVeiculo veiculo;
	private ModeloProduto produtos;
	private ModeloFuncionario funcionario;

	public int getCodigo() {

		return codigo;

	}

	public void setCodigo(int codigo) {

		this.codigo = codigo;

	}

	public ModeloVeiculo getVeiculo() {

		return veiculo;

	}

	public void setVeiculo(ModeloVeiculo veiculo) {

		this.veiculo = veiculo;

	}

	public ModeloProduto getProdutos() {

		return produtos;

	}

	public void setProdutos(ModeloProduto produtos) {

		this.produtos = produtos;

	}

	public ModeloFuncionario getFuncionario() {

		return funcionario;

	}

	public void setFuncionario(ModeloFuncionario funcionario) {

		this.funcionario = funcionario;

	}

}
