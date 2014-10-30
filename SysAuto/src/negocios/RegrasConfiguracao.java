package negocios;

import java.io.IOException;

import persistencia.Persistencia;

public class RegrasConfiguracao {

	public void configura(String IP, String usuario, String senha) throws IOException {

		Persistencia configuracao = new Persistencia();

		configuracao.criaConfiguracao(IP, usuario, senha);

	}

}
