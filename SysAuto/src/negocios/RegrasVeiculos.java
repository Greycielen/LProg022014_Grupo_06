package negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import modelos.ModeloVeiculo;
import persistencia.Persistance_DB;

public class RegrasVeiculos {
	Persistencia_DB bancodedados = new Persistencia_DB();

	public void conecta() throws SQLException {
		bancodedados.conexao();
	}

	public void desconecta() throws SQLException {
		bancodedados.disconnection();
	}

	public ModeloVeiculo consultaVeiculo(String placa) throws SQLException {
		return bancodedados.consultarVeiculo(placa);
	}

	public ArrayList<String> listaVeiculos() throws SQLException {
		return bancodedados.listarVeiculos();
	}

	public void excluiVeiculo(String placa) throws SQLException {
		bancodedados.excluirVeiculo(placa);
	}

	public void cadastraVeiculo(ModeloVeiculo veiculo) throws SQLException {
		bancodedados.salvarVeiculo(veiculo);
	}

	public void atualizaVeiculo(ModeloVeiculo veiculo) throws SQLException {
		bancodedados.alterarVeiculo(veiculo);
	}
}