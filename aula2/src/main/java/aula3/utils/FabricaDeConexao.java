package aula3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	// Classe utilitária que carrega os dados de um arquivo
	private static final String USERNAME = "root";

	// Senha do banco
	private static final String PASSWORD = "";

	// Caminho do banco de dados, porta, nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/usuarios";

	/*
	 * Conexão com o banco de dados
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;

	}

}
