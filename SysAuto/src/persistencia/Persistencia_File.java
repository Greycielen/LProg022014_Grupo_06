package persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Persistencia_File {

	public void Configuracao(String IP, String usuario, String senha)
			throws IOException {

		File diretorio = new File("C:\\SysAuto");
		File arquivo = new File(diretorio, "server.conf");

		if (!diretorio.exists()) {

			diretorio.mkdir();

			if (!arquivo.exists()) {

				arquivo.createNewFile();

			}

		} else {

			if (!arquivo.exists()) {

				arquivo.createNewFile();

			}

		}

		FileWriter filewriter = new FileWriter(arquivo, false);
		PrintWriter printwriter = new PrintWriter(filewriter);

		printwriter.println(IP);
		printwriter.println(usuario);
		printwriter.println(senha);

		printwriter.flush();
		printwriter.close();

	}

}