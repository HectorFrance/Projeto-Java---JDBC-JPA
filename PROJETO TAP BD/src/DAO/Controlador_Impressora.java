package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Impressora;
import Util.ConnectionUtil;

public class Controlador_Impressora {

	public List<Impressora> IMPpesquisaPreco(int preco) {
		List<Impressora> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Impressoras");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT impressora.* from impressora where preco <= " + preco + " ;");

			while (rs.next()) {
				Impressora i = new Impressora();
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("impressora.modelo"));
				i.setCod(rs.getInt("cod"));
				i.setCod_fab(rs.getInt("cod_fab"));
				i.setTipo(rs.getString("tipo"));
				li.add(i);
			}

			System.out.println();
			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
		return li;
	}

	public List<Impressora> IMPpesquisaCodFab(int fab) {
		List<Impressora> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Impressoras");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT impressora.* from impressora where cod_fab = " + fab + " ;");

			while (rs.next()) {
				Impressora i = new Impressora();
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("impressora.modelo"));
				i.setCod(rs.getInt("cod"));
				i.setCod_fab(rs.getInt("cod_fab"));
				i.setTipo(rs.getString("tipo"));
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

	public List<Impressora> IMPpesquisaModelo(String modelo) {
		List<Impressora> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Impressoras");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm
					.executeQuery("SELECT impressora.* from impressora where modelo like \"%" + modelo + "%\" ;");

			while (rs.next()) {
				Impressora i = new Impressora();
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("impressora.modelo"));
				i.setCod(rs.getInt("cod"));
				i.setCod_fab(rs.getInt("cod_fab"));
				i.setTipo(rs.getString("tipo"));
				li.add(i);
				System.out.println(i.getModelo());
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
		return li;
	}

	public List<Impressora> IMPlistarTudo() {
		List<Impressora> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Impressoras");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT impressora.* from impressora;");

			while (rs.next()) {
				Impressora i = new Impressora();
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("impressora.modelo"));
				i.setCod(rs.getInt("cod"));
				i.setCod_fab(rs.getInt("cod_fab"));
				i.setTipo(rs.getString("tipo"));
				li.add(i);

			}

			System.out.println();
			conn.close();
		} catch (SQLException e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
		return li;
	}

	public void adcinarIMP(Impressora i) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Adcionando Inpressora");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("insert into impressora(cod_fab, modelo, preco, tipo) values (" + i.getCod_fab() + ",'"
					+ i.getModelo() + "'," + i.getPreco() + ", '" + i.getTipo() + "');");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}

	public void removerIMP(int cod) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Removendo Inpressora");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("delete from impressora where cod = " + cod + ";");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}

	public void IMPmudarPreco(int preco, int cod) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: alterando preço da Inpressora");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("update impressora set preco = " + preco + "  where cod = " + cod + ";");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}
}
