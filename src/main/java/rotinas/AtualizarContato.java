package rotinas;

import java.util.Objects;

import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

import dao.DAO;
import entidades.Contatos;

public class AtualizarContato {
	
	public static void menuAtualizar(String id, String att) {
		switch (Integer.parseInt(att)) {
		case 0:
			break;
		case 1:
			String nome = JOptionPane.showInputDialog(null, "Nome: ", "ALTERAR NOME", JOptionPane.PLAIN_MESSAGE);
			if(Objects.isNull(nome)) {
				break;
			}
			AtualizarContato.atualizarNome(Integer.parseInt(id), nome);
			break;
		case 2:
			String email = JOptionPane.showInputDialog(null, "E-mail: ", "ALTERAR E-MAIL", JOptionPane.PLAIN_MESSAGE);
			if(Objects.isNull(email)) {
				break;
			}
			AtualizarContato.atualizarEmail(Integer.parseInt(id), email);
			break;
		case 3:
			String telefone = JOptionPane.showInputDialog(null, "Telefone: ", "ALTERAR TELEFONE", JOptionPane.PLAIN_MESSAGE);
			if(Objects.isNull(telefone)) {
				break;
			}
			AtualizarContato.atualizarTelefone(Integer.parseInt(id), telefone);
			break;
		case 4:
			String rua = JOptionPane.showInputDialog(null, "Rua: ", "ALTERAR RUA", JOptionPane.PLAIN_MESSAGE);
			String bairro = JOptionPane.showInputDialog(null, "Bairro: ", "ALTERAR BAIRRO", JOptionPane.PLAIN_MESSAGE);
			String numero = JOptionPane.showInputDialog(null, "Número: ", "ALTERAR NÚMERO", JOptionPane.PLAIN_MESSAGE);	
			if(Objects.isNull(rua) || Objects.isNull(bairro) || Objects.isNull(numero)) {
				break;
			}
			AtualizarContato.atualizarEndereco(Integer.parseInt(id), rua, bairro, Integer.parseInt(numero));							
			break;
		case 5:
			nome = JOptionPane.showInputDialog(null, "Nome: ", "ALTERAR NOME", JOptionPane.PLAIN_MESSAGE);
			AtualizarContato.atualizarNome(Integer.parseInt(id), nome);
			email = JOptionPane.showInputDialog(null, "E-mail: ", "ALTERAR E-MAIL", JOptionPane.PLAIN_MESSAGE);
			AtualizarContato.atualizarEmail(Integer.parseInt(id), email);
			telefone = JOptionPane.showInputDialog(null, "Telefone: ", "ALTERAR TELEFONE", JOptionPane.PLAIN_MESSAGE);
			AtualizarContato.atualizarTelefone(Integer.parseInt(id), telefone);
			rua = JOptionPane.showInputDialog(null, "Rua: ", "ALTERAR RUA", JOptionPane.PLAIN_MESSAGE);
			bairro = JOptionPane.showInputDialog(null, "Bairro: ", "ALTERAR BAIRRO", JOptionPane.PLAIN_MESSAGE);
			numero = JOptionPane.showInputDialog(null, "Número: ", "ALTERAR NÚMERO", JOptionPane.PLAIN_MESSAGE);	
			if(Objects.isNull(nome) || Objects.isNull(email) || Objects.isNull(telefone) || Objects.isNull(rua) || Objects.isNull(bairro) || Objects.isNull(numero)) {
				break;
			}
			AtualizarContato.atualizarEndereco(Integer.parseInt(id), rua, bairro, Integer.parseInt(numero));							
			break;
		default:
			JOptionPane.showMessageDialog(null,"OPÇÃO ESCOLHIDA É INVÁLIDA", "OPÇÃO INVÁLIDA", JOptionPane.PLAIN_MESSAGE);
			break;
		}
	}
	
	public static void atualizarNome(Integer id, String nome) {
		DAO<Contatos> dao = new DAO<>(Contatos.class);		
		Contatos contato;		
		try {
			dao.beginTransaction();
			contato = dao.findByID(id);
			dao.detach(contato);
			contato.setNome(nome);			
			dao.merge(contato);
			dao.commitTransaction();
			JOptionPane.showMessageDialog(null, contato, "ATUALIZAÇÃO BEM SUCEDIDA", JOptionPane.PLAIN_MESSAGE);	
		} catch (NoResultException e) {
			JOptionPane.showMessageDialog(null, "Contato Não Encontrado", "ERRO", JOptionPane.PLAIN_MESSAGE);	
		}				
		dao.closeEM();
	}
	
	public static void atualizarEmail(Integer id, String email) {
		DAO<Contatos> dao = new DAO<>(Contatos.class);		
		Contatos contato;		
		try {
			dao.beginTransaction();
			contato = dao.findByID(id);
			dao.detach(contato);
			contato.setEmail(email);	
			dao.merge(contato);
			dao.commitTransaction();
			JOptionPane.showMessageDialog(null, contato, "ATUALIZAÇÃO BEM SUCEDIDA", JOptionPane.PLAIN_MESSAGE);	
		} catch (NoResultException e) {
			JOptionPane.showMessageDialog(null, "Contato Não Encontrado", "ERRO", JOptionPane.PLAIN_MESSAGE);	
		}				
		dao.closeEM();
	}
	
	public static void atualizarTelefone(Integer id, String telefone) {
		DAO<Contatos> dao = new DAO<>(Contatos.class);
		
		Contatos contato;		
		try {
			dao.beginTransaction();
			contato = dao.findByID(id);
			dao.detach(contato);
			contato.setTelefone(telefone);	
			dao.merge(contato);
			dao.commitTransaction();
			JOptionPane.showMessageDialog(null, contato, "ATUALIZAÇÃO BEM SUCEDIDA", JOptionPane.PLAIN_MESSAGE);	
		} catch (NoResultException e) {
			JOptionPane.showMessageDialog(null, "Contato Não Encontrado", "ERRO", JOptionPane.PLAIN_MESSAGE);	
		}				
		dao.closeEM();
	}
	
	public static void atualizarEndereco(Integer id, String rua, String bairro, int numero) {
		DAO<Contatos> dao = new DAO<>(Contatos.class);
		
		Contatos contato;		
		try {
			dao.beginTransaction();
			contato = dao.findByID(id);
			dao.detach(contato);
			contato.getEndereco().setRua(rua);
			contato.getEndereco().setBairro(bairro);
			contato.getEndereco().setNumero(numero);
			dao.merge(contato);
			dao.commitTransaction();
			JOptionPane.showMessageDialog(null, contato, "ATUALIZAÇÃO BEM SUCEDIDA", JOptionPane.PLAIN_MESSAGE);	
		} catch (NoResultException e) {
			JOptionPane.showMessageDialog(null, "Contato Não Encontrado", "ERRO", JOptionPane.PLAIN_MESSAGE);	
		}				
		dao.closeEM();
	}

}
