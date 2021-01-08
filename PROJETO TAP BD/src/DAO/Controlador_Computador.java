package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Computadores;
import Util.ConnectionUtil;

public class Controlador_Computador {

	public List<Computadores> COMP_pesquisaPreco(int preco) {
		List<Computadores> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Computadores");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from computadores where preco <= " + preco + " ;");

			while (rs.next()) {
				Computadores i = new Computadores();
				i.setCod(rs.getInt("cod"));
				i.setHD(rs.getInt("HD"));
				i.setRAM(rs.getInt("RAM"));
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

	public List<Computadores> pesquisaCodFab_COMP(int fab) {
		List<Computadores> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Computadores");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from computadores where cod_fab = " + fab + " ;");

			while (rs.next()) {
				Computadores i = new Computadores();
				i.setCod(rs.getInt("cod"));
				i.setHD(rs.getInt("HD"));
				i.setRAM(rs.getInt("RAM"));
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

	public List<Computadores> pesquisaModelo_COMP(String modelo) {
		List<Computadores> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Computadores");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from computadores where modelo like \"%" + modelo + "%\" ;");

			while (rs.next()) {
				Computadores i = new Computadores();
				i.setCod(rs.getInt("cod"));
				i.setHD(rs.getInt("HD"));
				i.setRAM(rs.getInt("RAM"));
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


	public List<Computadores> listarTudo_COMP() {
		List<Computadores> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Computadores");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from computadores;");

			while (rs.next()) {
				Computadores i = new Computadores();
				i.setCod(rs.getInt("cod"));
				i.setHD(rs.getInt("HD"));
				i.setRAM(rs.getInt("RAM"));
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

	public void adcinar_COMP(Computadores i) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Adcionando Computador");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("insert into computadores(HD, RAM, cod_fab, modelo, preco) values (" + i.getHD() + ","
					+ i.getRAM() + "," + i.getCod_fab() + ", '" + i.getModelo() + "', " + i.getPreco() + ");");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}

	public void removerCOMP(int cod) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Removendo Computador");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("delete from computadores where cod = " + cod + ";");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}

	public void mudarPreco_COMP(int preco, int cod) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: alterando preço da Computadores");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("update computadores set preco = " + preco + "  where cod = " + cod + ";");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}
}
