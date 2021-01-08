package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Consoles;
import Util.ConnectionUtil;

public class Controlador_Consoles{

	public List<Consoles> CS_pesquisaPreco(int preco) {
		List<Consoles> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Consoles");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from consoles where preco <= " + preco + " ;");

			while (rs.next()) {
				Consoles i = new Consoles();
				i.setCod(rs.getInt("cod"));
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("modelo"));
				i.setCod_fab(rs.getInt("cod_fab"));
				li.add(i);
			}

			System.out.println();
			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
		return li;
	}

	public List<Consoles> pesquisaCodFab_CS(int fab) {
		List<Consoles> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Consoles");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from consoles where cod_fab = " + fab + " ;");

			while (rs.next()) {
				Consoles i = new Consoles();
				i.setCod(rs.getInt("cod"));
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("modelo"));
				i.setCod_fab(rs.getInt("cod_fab"));
				li.add(i);
				System.out.println(i.getModelo());
			}

			System.out.println();
			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
		return li;
	}

	public List<Consoles> pesquisaModelo_CS(String modelo) {
		List<Consoles> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Consoles");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from consoles where modelo like \"%" + modelo + "%\" ;");

			while (rs.next()) {
				Consoles i = new Consoles();
				i.setCod(rs.getInt("cod"));
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("modelo"));
				i.setCod_fab(rs.getInt("cod_fab"));
				li.add(i);
				System.out.println(i.getModelo());
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
		return li;
	}

	public List<Consoles> listarTudo_CS() {
		List<Consoles> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Consoles");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from consoles;");

			while (rs.next()) {
				Consoles i = new Consoles();
				i.setCod(rs.getInt("cod"));
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("modelo"));
				i.setCod_fab(rs.getInt("cod_fab"));
				li.add(i);

			}

			System.out.println();
			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
		return li;
	}

	public void adcionar_CS(Consoles i) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Adcionando Consoles");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("insert into consoles(cod_fab, modelo, preco) values (" + i.getCod_fab() + ", '"
					+ i.getModelo() + "', " + i.getPreco() + ");");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}

	public void remover_CS(int cod) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Removendo Consoles");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("delete from consoles where cod = " + cod + ";");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}

	public void mudarPreco_AC(int preco, int cod) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: alterando preço da Consoles");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("update consoles set preco = " + preco + "  where cod = " + cod + ";");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}
}
