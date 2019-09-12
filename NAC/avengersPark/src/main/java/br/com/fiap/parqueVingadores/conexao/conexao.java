package br.com.fiap.parqueVingadores.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {
	public static Connection conectar() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm82943", "080201");
	}
}
