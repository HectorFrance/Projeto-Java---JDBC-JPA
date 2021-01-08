package Controller;

import java.sql.Connection;
import java.sql.SQLException;

import Util.ConnectionUtil;

public class testeJDBC {
	public static void main(String[] args) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("DEU CERTO");
			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}
}