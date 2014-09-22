package Modelos;

import java.lang.reflect.Field;
import javax.swing.JOptionPane;

public class Teste {
	public void updateTable(Object objeto, String condicao) {
		String query = "UPDATE " + objeto.getClass().getName() + " SET ";
		boolean first = true;
		for (Field field : objeto.getClass().getFields()) {
			try {
				if (!first) {
					query = query + ", ";
				}
				first = false;
				query = query + field.getName() + "=" + field.get(objeto).toString();
			} catch (IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, "Erro!\nDescrição:\n" + ex);
			} catch (IllegalAccessException ex) {
				JOptionPane.showMessageDialog(null, "Erro!\nDescrição:\n" + ex);
			}
		}
		query = query + " WHERE " + condicao;
		System.out.println(query);
	}
}