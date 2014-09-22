package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Modelos.ModeloProduto;
import Modelos.ModeloFuncionario;
import Modelos.ModeloVeiculo;

public class Persistencia {
	public Statement stm;
	public ResultSet rs;
	private String drive = "com.mysql.jdbc.Driver.jar";
	private String caminho = "jdbc:mysql://localhost/sysautobd";
	private String usuario = "root";
	private String senha = "";
	public Connection conn;

	public void conexao() {
		try {
			System.setProperty("jdbc.Drivers", drive);
			conn = DriverManager.getConnection(caminho, usuario, senha);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar banco de dados!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void desconexao() {
		try {
			conn.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao desconectar o banco de dados!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void executaSql(String sql) {
		try {
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro de Execução SQL!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void preencherComboProdutos(JComboBox<String> comboProduto) {
		this.conexao();
		try {
			this.executaSql("SELECT concat('<',idProduto, '> ', nome) FROM produtos ORDER BY concat('<',idProduto, '> ', nome) ASC");
			this.rs.first();
			comboProduto.addItem("<NOVO PRODUTO>");
			do {
				comboProduto.addItem(this.rs.getString("concat('<',idProduto, '> ', nome)"));
			} while (this.rs.next());
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Cadastre ao menos um produto!");
		}
	}

	public ModeloProduto consultarProduto(ModeloProduto produto) {
		this.conexao();
		try {
			this.executaSql("SELECT * FROM produtos WHERE idProduto = '" + produto.getCodigo() + "'");
			this.rs.first();
			produto.setCodigo(this.rs.getString("idProduto"));
			produto.setNome(this.rs.getString("nome"));
			produto.setEnquadramento(this.rs.getString("enquadramento"));
			produto.setValor(this.rs.getString("valor"));
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro de Persistência!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		return produto;
	}

	public void salvarProduto(ModeloProduto produto) {
		this.conexao();
		try {
			PreparedStatement pst = this.conn.prepareStatement("INSERT INTO produtos(idProduto, nome, enquadramento, valor) values(?, ?, ?, ?)");
			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getEnquadramento());
			pst.setString(4, produto.getValor());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		this.desconexao();
	}

	public void alterarProduto(ModeloProduto produto) {
		this.conexao();
		try {
			PreparedStatement pst = this.conn.prepareStatement("UPDATE produtos SET idProduto = ?, nome = ? , enquadramento = ?, valor = ? WHERE idProduto = ?");
			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getEnquadramento());
			pst.setString(4, produto.getValor());
			pst.setString(5, produto.getCodigo());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o cadastro!\nErro:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		this.desconexao();
	}

	public void excluirProduto(ModeloProduto produto) {
		this.conexao();
		try {
			PreparedStatement pst = this.conn.prepareStatement("DELETE FROM sysautobd.produtos WHERE produtos.idProduto = ?");
			pst.setString(1, produto.getCodigo());
			pst.execute();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir produto!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
		this.desconexao();
	}

	public void preencherComboVeiculos(JComboBox<String> comboVeiculo) {
		this.conexao();
		try {
			this.executaSql("SELECT concat(modelo,' <',placa,'> ') FROM sysautobd.veiculos ORDER BY concat(modelo,' <',placa,'> ') ASC");
			this.rs.first();
			comboVeiculo.addItem("<NOVO VEICULO>");
			do {
				comboVeiculo.addItem(this.rs.getString("concat(modelo,' <',placa,'> ')"));
			} while (this.rs.next());
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Cadastre ao menos um veículo!");
		}
	}

	public ModeloVeiculo consultarVeiculo(ModeloVeiculo veiculo) {
		this.conexao();
		try {
			this.executaSql("SELECT * FROM veiculos WHERE modelo = '" + veiculo.getModelo() + "'");
			this.rs.first();
			veiculo.setPlaca(this.rs.getString("placa"));
			veiculo.setModelo(this.rs.getString("modelo"));
			veiculo.setCor(this.rs.getString("cor"));
			veiculo.setAno(this.rs.getString("ano"));
			veiculo.setProprietario(this.rs.getString("proprietario"));
			veiculo.setContato(this.rs.getString("contato_proprietario"));
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro de Persistência!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		return veiculo;
	}

	public void salvarVeiculo(ModeloVeiculo veiculo) {
		this.conexao();
		try {
			PreparedStatement pst = this.conn.prepareStatement("INSERT INTO veiculos(placa, modelo, cor, ano, proprietario, contato_proprietario) values(?, ?, ?, ?, ?, ?)");
			pst.setString(1, veiculo.getPlaca().toUpperCase());
			pst.setString(2, veiculo.getModelo());
			pst.setString(3, veiculo.getCor());
			pst.setString(4, veiculo.getAno());
			pst.setString(5, veiculo.getProprietario());
			pst.setString(6, veiculo.getContato());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o veiculo!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		this.desconexao();
	}

	public void alterarVeiculo(ModeloVeiculo veiculo) {
		this.conexao();
		try {
			PreparedStatement pst = this.conn.prepareStatement("UPDATE veiculos SET placa = ? , modelo = ?, cor = ?, ano = ?, proprietario = ?, contato_proprietario = ? where placa = ?");
			pst.setString(1, veiculo.getPlaca());
			pst.setString(2, veiculo.getModelo());
			pst.setString(3, veiculo.getCor());
			pst.setString(4, veiculo.getAno());
			pst.setString(5, veiculo.getProprietario());
			pst.setString(6, veiculo.getContato());
			pst.setString(7, veiculo.getPlaca());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o cadastro!\nErro:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		this.desconexao();
	}

	public void excluirVeiculo(String placa) {
		this.conexao();
		try {
			PreparedStatement pst = this.conn.prepareStatement("DELETE FROM sysautobd.veiculos WHERE veiculos.placa = ?");
			pst.setString(1, placa);
			pst.execute();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir veículo!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Veículo excluido com sucesso!");
		this.desconexao();
	}

	public void preencherComboFuncionarios(JComboBox<String> comboFuncionario) {
		this.conexao();
		try {
			this.executaSql("SELECT * FROM funcionarios ORDER BY nome");
			this.rs.first();
			comboFuncionario.addItem("<NOVO FUNCIONARIO>");
			do {
				comboFuncionario.addItem(this.rs.getString("nome"));
			} while (this.rs.next());
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Cadastre ao menos um funcionário!");
		}
	}

	public ModeloFuncionario consultarFuncionario(ModeloFuncionario funcionario) {
		this.conexao();
		try {
			this.executaSql("SELECT * FROM funcionarios WHERE nome ='" + funcionario.getNome() + "'");
			this.rs.first();
			funcionario.setNome(this.rs.getString("nome"));
			funcionario.setLogin(this.rs.getString("login"));
			funcionario.setEnquadramento_funcional(this.rs.getString("enquadramento_funcional"));
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro de Persistência!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		return funcionario;
	}

	public void salvarFuncionario(ModeloFuncionario funcionario) {
		this.conexao();
		try {
			PreparedStatement pst = this.conn.prepareStatement("INSERT INTO funcionarios(login, senha, nome, enquadramento_funcional) values(?, ?, ?, ?)");
			pst.setString(1, funcionario.getLogin());
			pst.setString(2, funcionario.getSenha());
			pst.setString(3, funcionario.getNome());
			pst.setString(4, funcionario.getEnquadramento_funcional());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o funcionario!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		this.desconexao();
	}

	public void alterarFuncionario(ModeloFuncionario funcionario) {
		this.conexao();
		try {
			PreparedStatement pst = this.conn.prepareStatement("UPDATE funcionarios SET login = ? , senha = ?, nome = ?, enquadramento_funcional = ? where login = ?");
			pst.setString(1, funcionario.getLogin());
			pst.setString(2, funcionario.getSenha());
			pst.setString(3, funcionario.getNome());
			pst.setString(4, funcionario.getEnquadramento_funcional());
			pst.setString(5, funcionario.getLogin());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o cadastro!\nDescrição:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		this.desconexao();
	}

	public void excluirFuncionario(String login) {
		this.conexao();
		try {
			PreparedStatement pst = this.conn.prepareStatement("DELETE FROM sysautobd.funcionarios WHERE funcionarios.login = ?");
			pst.setString(1, login);
			pst.execute();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário!\n" + "Descrição do erro:\n" + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Funcionário excluido com sucesso!");
		this.desconexao();
	}
}