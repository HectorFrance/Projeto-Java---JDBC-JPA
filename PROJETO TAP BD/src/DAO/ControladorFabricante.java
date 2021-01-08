package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Fabricante;
import Util.ConnectionUtil;

public class ControladorFabricante {

	public List<Fabricante> FABpesquisaNOME(String modelo) {
		List<Fabricante> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando fabricantes");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from fabricante where nome like \"%" + modelo + "%\" ;");

			while (rs.next()) {
				Fabricante i = new Fabricante();
				i.setCod(rs.getInt("cod"));
				i.setNome(rs.getString("nome"));
				li.add(i);
				;
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
		return li;
	}

	public List<Fabricante> FABlistarTudo() {
		List<Fabricante> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Fabriantes");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from fabricante;");

			while (rs.next()) {
				Fabricante i = new Fabricante();
				i.setNome(rs.getString("nome"));
				i.setCod(rs.getInt("cod"));
				;
				li.add(i);

			}

			System.out.println();
			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
		return li;
	}

	public void adcinarFAB(Fabricante i) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Adcionando fabricante");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("insert into fabricante (nome) values ('" + i.getNome() + "');");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}

	public void removerFAB(int cod) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Removendo fabricante");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("delete from fabricante where cod = " + cod + ";");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}
}
