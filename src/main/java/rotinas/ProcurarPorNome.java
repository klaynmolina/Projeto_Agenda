package rotinas;

import java.util.List;

import javax.swing.JOptionPane;
import dao.DAO;
import entidades.Contatos;

public class ProcurarPorNome {
	
	public static void procurar(String nome) {

		DAO<Contatos> dao = new DAO<>(Contatos.class);

		List<Contatos> c = dao.search(nome);
		
		if(c.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existe contato com esse nome.", "CONTATO ", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(null, c.toArray(), "CONTATO ", JOptionPane.PLAIN_MESSAGE);

	}

}
