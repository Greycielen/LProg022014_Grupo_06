package negocios;

import java.io.File;
import java.io.IOException;

import persistencia.Persistencia_File;

public class RegrasConfiguracao {

	Persistencia_File arquivo = new Persistencia_File();
	File file = new File("C://SysAuto/config.txt");

	public void Configuracao(String IP, String usuario, String senha)
			throws IOException {

		arquivo.Configuracao(IP, usuario, senha);

	}

}
