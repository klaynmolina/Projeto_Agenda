package rotinas;

import java.util.List;
import javax.swing.JOptionPane;

import dao.DAO;
import entidades.Contatos;

public class ExibirContatos {
		
	public static void exibirTodos() {
		
		DAO<Contatos> dao = new DAO<>(Contatos.class);

		List<Contatos> c = dao.searchAll();

		JOptionPane.showMessageDialog(null, c.toArray(), "CONTATOS", JOptionPane.PLAIN_MESSAGE);

		dao.closeEM();
		
	}
}
