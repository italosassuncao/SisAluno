package br.edu.unicid.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {
		try {

			Class.forName("com.mysql.jsbc.Driver");

			return DriverManager.getConnection("jdbc.mysql://localhost:3306/sislauno", "root", "@Legale12@");

		} catch (Exception erro) {
			throw new Exception(erro.getMessage());
		}

	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		close(conn, stmt, rs);
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception erro) {

		}
	};
}