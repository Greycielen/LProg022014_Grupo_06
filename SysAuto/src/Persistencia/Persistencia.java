package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelos.ModeloFuncionario;
import Modelos.ModeloProduto;
import Modelos.ModeloVeiculo;

public class Persistencia {

	public Statement stm;
	public ResultSet rs;
	private String drive = "com.mysql.jdbc.Driver.jar";
	private String caminho = "jdbc:mysql://127.0.0.1/sysautodb";
	private String usuario = "root";
	private String senha = "";
	public Connection con;

	public void conexao() throws SQLException {

		System.setProperty("jdbc.Drivers", drive);
		con = DriverManager.getConnection(caminho, usuario, senha);

	}

	public void disconnection() throws SQLException {

		con.close();

	}

	public void executaSQL(String SQL) throws SQLException {

		stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(SQL);

	}

	public ArrayList<String> listarProdutos() throws SQLException {

		ArrayList<String> lista_produtos = new ArrayList<String>();

		this.executaSQL("SELECT concat('<',idProduto, '> ', nome) FROM produtos ORDER BY concat('<',idProduto, '> ', nome) ASC");
		this.rs.first();
		do {
			lista_produtos.add(this.rs
					.getString("concat('<',idProduto, '> ', nome)"));
		} while (this.rs.next());

		return lista_produtos;
	}

	public ModeloProduto consultarProduto(String codigo) throws SQLException {

		ModeloProduto produto = new ModeloProduto();

		this.executaSQL("SELECT * FROM produtos WHERE idProduto = '" + codigo
				+ "'");
		this.rs.first();
		produto.setCodigo(this.rs.getString("idProduto"));
		produto.setNome(this.rs.getString("nome"));
		produto.setEnquadramento(this.rs.getString("enquadramento"));
		produto.setValor(this.rs.getString("valor"));

		return produto;
	}

	public void salvarProduto(ModeloProduto produto) throws SQLException {

		PreparedStatement pst = this.con
				.prepareStatement("INSERT INTO produtos(idProduto, nome, enquadramento, valor) values(?, ?, ?, ?)");
		pst.setString(1, produto.getCodigo());
		pst.setString(2, produto.getNome());
		pst.setString(3, produto.getEnquadramento());
		pst.setString(4, produto.getValor());
		pst.execute();

	}

	public void alterarProduto(ModeloProduto produto) throws SQLException {

		PreparedStatement pst = this.con
				.prepareStatement("UPDATE produtos SET idProduto = ?, nome = ? , enquadramento = ?, valor = ? WHERE idProduto = ?");
		pst.setString(1, produto.getCodigo());
		pst.setString(2, produto.getNome());
		pst.setString(3, produto.getEnquadramento());
		pst.setString(4, produto.getValor());
		pst.setString(5, produto.getCodigo());
		pst.execute();

	}

	public void excluirProduto(String codigo) throws SQLException {

		PreparedStatement pst = this.con
				.prepareStatement("DELETE FROM produtos WHERE idProduto = ?");
		pst.setString(1, codigo);
		pst.execute();

	}

	public ArrayList<String> listarVeiculos() throws SQLException {

		ArrayList<String> lista_veiculos = new ArrayList<String>();

		this.executaSQL("SELECT concat(' <',placa,'> ', modelo) FROM veiculos ORDER BY concat(' <',placa,'> ', modelo) ASC");
		this.rs.first();
		do {
			lista_veiculos.add(this.rs
					.getString("concat(' <',placa,'> ', modelo)"));
		} while (this.rs.next());

		return lista_veiculos;
	}

	public ModeloVeiculo consultarVeiculo(String placa) throws SQLException {

		ModeloVeiculo veiculo = new ModeloVeiculo();

		this.executaSQL("SELECT * FROM veiculos WHERE placa = '" + placa + "'");
		this.rs.first();
		veiculo.setPlaca(this.rs.getString("placa"));
		veiculo.setModelo(this.rs.getString("modelo"));
		veiculo.setCor(this.rs.getString("cor"));
		veiculo.setAno(this.rs.getString("ano"));
		veiculo.setProprietario(this.rs.getString("proprietario"));
		veiculo.setContato(this.rs.getString("contato_proprietario"));

		return veiculo;
	}

	public void salvarVeiculo(ModeloVeiculo veiculo) throws SQLException {

		PreparedStatement pst = this.con
				.prepareStatement("INSERT INTO veiculos(placa, modelo, cor, ano, proprietario, contato_proprietario) values(?, ?, ?, ?, ?, ?)");
		pst.setString(1, veiculo.getPlaca().toUpperCase());
		pst.setString(2, veiculo.getModelo());
		pst.setString(3, veiculo.getCor());
		pst.setString(4, veiculo.getAno());
		pst.setString(5, veiculo.getProprietario());
		pst.setString(6, veiculo.getContato());
		pst.execute();

	}

	public void alterarVeiculo(ModeloVeiculo veiculo) throws SQLException {

		PreparedStatement pst = this.con
				.prepareStatement("UPDATE veiculos SET placa = ? , modelo = ?, cor = ?, ano = ?, proprietario = ?, contato_proprietario = ? where placa = ?");
		pst.setString(1, veiculo.getPlaca());
		pst.setString(2, veiculo.getModelo());
		pst.setString(3, veiculo.getCor());
		pst.setString(4, veiculo.getAno());
		pst.setString(5, veiculo.getProprietario());
		pst.setString(6, veiculo.getContato());
		pst.setString(7, veiculo.getPlaca());
		pst.execute();

	}

	public void excluirVeiculo(String placa) throws SQLException {

		PreparedStatement pst = this.con
				.prepareStatement("DELETE FROM veiculos WHERE placa = ?");
		pst.setString(1, placa);
		pst.execute();

	}

	public ArrayList<String> listarFuncionarios() throws SQLException {

		ArrayList<String> lista_funcionarios = new ArrayList<String>();

		this.executaSQL("SELECT * FROM funcionarios ORDER BY funcionarios.nome");
		this.rs.first();
		do {
			lista_funcionarios.add(this.rs.getString("nome"));
		} while (this.rs.next());

		return lista_funcionarios;

	}

	public ModeloFuncionario consultarFuncionario(String nome)
			throws SQLException {

		ModeloFuncionario funcionario = new ModeloFuncionario();

		this.executaSQL("SELECT * FROM funcionarios WHERE nome ='" + nome + "'");
		this.rs.first();
		funcionario.setNome(this.rs.getString("nome"));
		funcionario.setLogin(this.rs.getString("login"));
		funcionario.setSenha(this.rs.getString("senha"));
		funcionario.setEnquadramento_funcional(this.rs
				.getString("enquadramento_funcional"));
		funcionario.setNivel_acesso(this.rs.getString("nivel_acesso"));

		return funcionario;
	}

	public ModeloFuncionario consultarFuncionarioLogin(String login)
			throws SQLException {

		ModeloFuncionario funcionario = new ModeloFuncionario();

		this.executaSQL("SELECT * FROM funcionarios WHERE login ='" + login
				+ "'");
		this.rs.first();
		funcionario.setNome(this.rs.getString("nome"));
		funcionario.setLogin(this.rs.getString("login"));
		funcionario.setSenha(this.rs.getString("senha"));
		funcionario.setEnquadramento_funcional(this.rs
				.getString("enquadramento_funcional"));
		funcionario.setNivel_acesso(this.rs.getString("nivel_acesso"));

		return funcionario;
	}

	public void salvarFuncionario(ModeloFuncionario funcionario)
			throws SQLException {

		PreparedStatement pst = this.con
				.prepareStatement("INSERT INTO funcionarios(login, senha, nome, enquadramento_funcional, nivel_acesso) values(?, ?, ?, ?, ?)");
		pst.setString(1, funcionario.getLogin());
		pst.setString(2, funcionario.getSenha());
		pst.setString(3, funcionario.getNome());
		pst.setString(4, funcionario.getEnquadramento_funcional());
		pst.setString(5, funcionario.getNivel_acesso());
		pst.execute();

	}

	public void alterarFuncionario(ModeloFuncionario funcionario)
			throws SQLException {

		PreparedStatement pst = this.con
				.prepareStatement("UPDATE funcionarios SET login = ? , senha = ?, nome = ?, enquadramento_funcional = ?, nivel_acesso = ? where login = ?");
		pst.setString(1, funcionario.getLogin());
		pst.setString(2, funcionario.getSenha());
		pst.setString(3, funcionario.getNome());
		pst.setString(4, funcionario.getEnquadramento_funcional());
		pst.setString(5, funcionario.getNivel_acesso());
		pst.setString(6, funcionario.getLogin());
		pst.execute();

	}

	public void excluirFuncionario(String login) throws SQLException {

		PreparedStatement pst = this.con
				.prepareStatement("DELETE FROM funcionarios WHERE login = ?");
		pst.setString(1, login);
		pst.execute();

	}
}