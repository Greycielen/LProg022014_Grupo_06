package negocios;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.ModeloVeiculo;
import persistencia.Persistencia;

public class RegrasVeiculos {
	Persistencia bancodedados = new Persistencia();

	public void conecta() throws SQLException, IOException {
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