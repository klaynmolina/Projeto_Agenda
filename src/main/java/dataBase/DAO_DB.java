package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_DB {

	public static Connection conexao = null;

	public static Connection openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String usuario = "root";
			String senha = "123456789";

			conexao = DriverManager.getConnection(url, usuario, senha);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return conexao;
	}

	public static void closeConnection() {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static Statement stmt;

	public static void closeStmt() {
		try {
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Statement createDatabase() throws SQLException {
		stmt = conexao.createStatement();
		stmt.execute("CREATE SCHEMA IF NOT EXISTS Projeto_Agenda;");
		return stmt;
	}

	public static Statement deleteDatabase() throws SQLException {

		stmt = conexao.createStatement();
		stmt.execute("DROP SCHEMA IF EXISTS Programa_Agenda;");
		return stmt;
	}

}
