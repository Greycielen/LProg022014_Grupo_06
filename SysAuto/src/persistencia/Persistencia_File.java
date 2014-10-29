package persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Persistencia_File {

	public void criaConfiguracao() throws IOException {
	
		java.io.File diretorio = new java.io.File("C://SysAuto/Config");
		java.io.File arquivo = new java.io.File(diretorio, "config.txt");
		arquivo.createNewFile();
		
		FileWriter fileWriter = new FileWriter(arquivo, false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		printWriter.println();
		
	}
	
}