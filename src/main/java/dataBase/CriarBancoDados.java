package dataBase;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

import javax.swing.JOptionPane;

public class CriarBancoDados {
	
	public static void main(String[] args) {
		
	}

	public static void criar() {

		DAO_DB.openConnection();

		try {
			DAO_DB.createDatabase();
		}catch (SQLSyntaxErrorException e) {
			JOptionPane.showMessageDialog(null, "Erro de Sintaxe SQL", "ERRO", JOptionPane.PLAIN_MESSAGE);	
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Banco de Dados Já Existente", "MENSAGEM", JOptionPane.PLAIN_MESSAGE);	
		}catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Erro Desconhecido.", "ERRO", JOptionPane.PLAIN_MESSAGE);	
		}
		
		DAO_DB.closeConnection();

	}

}
