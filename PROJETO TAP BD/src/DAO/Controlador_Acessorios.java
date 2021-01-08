package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Acessorios;
import Util.ConnectionUtil;

public class Controlador_Acessorios {

	public List<Acessorios> AC_pesquisaPreco(int preco) {
		List<Acessorios> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Acessorios");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from acessorios where preco <= " + preco + " ;");

			while (rs.next()) {
				Acessorios i = new Acessorios();
				i.setCod(rs.getInt("cod"));
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("modelo"));
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

	public List<Acessorios> pesquisaCodFab_AC(int fab) {
		List<Acessorios> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Acessorios");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from acessorios where cod_fab = " + fab + " ;");

			while (rs.next()) {
				Acessorios i = new Acessorios();
				i.setCod(rs.getInt("cod"));
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("modelo"));
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

	public List<Acessorios> pesquisaModelo_AC(String modelo) {
		List<Acessorios> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Acessorios");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from acessorios where modelo like \"%" + modelo + "%\" ;");

			while (rs.next()) {
				Acessorios i = new Acessorios();
				i.setCod(rs.getInt("cod"));
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("modelo"));
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

	public List<Acessorios> listarTudo_AC() {
		List<Acessorios> li = new ArrayList<>();
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Buscando Acessorios");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * from acessorios;");

			while (rs.next()) {
				Acessorios i = new Acessorios();
				i.setCod(rs.getInt("cod"));
				i.setPreco(rs.getInt("preco"));
				i.setModelo(rs.getString("modelo"));
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

	public void adcionar_AC(Acessorios i) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Adcionando Acessorio");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("insert into acessorios(cod_fab, modelo, preco, tipo) values (" + i.getCod_fab() + ", '"
					+ i.getModelo() + "', " + i.getPreco() + ", '" + i.getTipo() + "');");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}

	public void remover_AC(int cod) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: Removendo Acessorios");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("delete from acessorios where cod = " + cod + ";");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}

	public void mudarPreco_AC(int preco, int cod) {
		try {
			Connection conn = null;
			conn = ConnectionUtil.getConnection();
			if (conn.getMetaData().getDatabaseProductName().equals("MySQL"))
				System.out.println("Conexão estabelecida: alterando preço da Acessorios");
			Statement stm = (Statement) conn.createStatement();
			stm = (Statement) conn.createStatement();
			stm.executeUpdate("update acessorios set preco = " + preco + "  where cod = " + cod + ";");

		} catch (Exception e) {
			System.out.println("DEU ERRADO" + e.getMessage());
		}
	}
}
