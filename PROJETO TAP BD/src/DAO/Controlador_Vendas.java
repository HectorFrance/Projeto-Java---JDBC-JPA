package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Vendas;

public class Controlador_Vendas {

	EntityManagerFactory emf;
	EntityManager em;

	public Controlador_Vendas() {
		emf = Persistence.createEntityManagerFactory("vendas");
		em = emf.createEntityManager();

	}

	public void V_adicioanr(Vendas i) {
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
	}

	public List<Vendas> V_listarTudo() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT v FROM Vendas v");
		List<Vendas> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void v_encerrar() {
		em.close();
	}

	public Vendas V_pesquisaC(int cod) {
		return em.find(Vendas.class, cod);
	}

	public void V_r(Vendas i) {
		em.getTransaction().begin();
		i = em.find(Vendas.class, i.getCod());
		em.remove(i);
		em.getTransaction().commit();
	}

	public void V_remover(int cod) {
		Vendas i = V_pesquisaC(cod);
		V_r(i);
	}

	public List<Vendas> V_pesquisaCodVendedor(int cod) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT v FROM Vendas v WHERE cod_vendedor = " + cod);
		List<Vendas> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Vendas> V_pesquisaClente(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT v FROM Vendas v WHERE nome_Cliente like '%" + c + "%'");
		List<Vendas> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Vendas> V_pesquisaEndereco(int c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT v FROM Vendas v WHERE cod_endereco =  " + c);
		List<Vendas> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void V_alterar(double d, int cod) {
		em.getTransaction().begin();
		Query query = em.createQuery("UPDATE Vendas v SET preco = '" + d + "' WHERE cod = " + cod);
		query.executeUpdate();
		em.getTransaction().commit();

	}

}
