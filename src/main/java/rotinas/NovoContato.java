package rotinas;

import java.util.Objects;

import javax.swing.JOptionPane;

import dao.DAO;
import entidades.Contatos;
import entidades.Endereco_emb;

public class NovoContato {

	public static void cadastrar() {

		String nome = JOptionPane.showInputDialog(null, "Nome do Contato: ", "MENSAGEM", JOptionPane.PLAIN_MESSAGE);
		if(Objects.isNull(nome)) {
			return;			
		}
		
		Endereco_emb endereco = new Endereco_emb();
		if(Objects.isNull(endereco)) {
			System.exit(0);
		}
		
		String end = JOptionPane.showInputDialog(null, "Rua: ", "RUA", JOptionPane.PLAIN_MESSAGE);
		endereco.setRua(end);
		end = JOptionPane.showInputDialog(null, "Número: ", "NÚMERO", JOptionPane.PLAIN_MESSAGE);
		endereco.setNumero(Integer.parseInt(end));
		end = JOptionPane.showInputDialog(null, "Bairro: ", "BAIRRO", JOptionPane.PLAIN_MESSAGE);
		endereco.setBairro(end);

		String telefone = JOptionPane.showInputDialog(null, "Telefone: ", "TELEFONE", JOptionPane.PLAIN_MESSAGE);
		if(Objects.isNull(telefone)) {
			System.exit(0);
		}
		
		String email = JOptionPane.showInputDialog(null, "E-mail: ", "E-MAIL", JOptionPane.PLAIN_MESSAGE);
		if(Objects.isNull(email)) {
			System.exit(0);
		}
		
		DAO<Contatos> dao = new DAO<>();
		
		Contatos novoContato = new Contatos(nome, endereco, telefone, email);
		dao.fullPersist(novoContato);
		
		JOptionPane.showMessageDialog(null, "Contato " + nome + " Inserido Com Sucesso.", "MENSAGEM", JOptionPane.PLAIN_MESSAGE );
		dao.closeEM();

	}

}
