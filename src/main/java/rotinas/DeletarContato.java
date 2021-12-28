package rotinas;

import java.util.Objects;

import javax.swing.JOptionPane;

import dao.DAO;
import entidades.Contatos;

public class DeletarContato {

	public static void deletarContato(int id) {
		DAO<Contatos> dao = new DAO<>(Contatos.class);

		Contatos contato = dao.findByID(id);
		
		if (Objects.nonNull(contato)) {
			dao.beginTransaction();
			dao.delete(contato);
			dao.commitTransaction();
			JOptionPane.showMessageDialog(null, "Contato Deletado com Sucesso", "CONTATO DELETADO",	JOptionPane.PLAIN_MESSAGE);
		}


		dao.closeEM();
	}

}
