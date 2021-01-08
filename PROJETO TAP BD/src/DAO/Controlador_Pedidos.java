package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Pedido;

public class Controlador_Pedidos {

	EntityManagerFactory emf;
	EntityManager em;

	public Controlador_Pedidos() {
		emf = Persistence.createEntityManagerFactory("pedido");
		em = emf.createEntityManager();

	}

	public void P_adicioanr(Pedido i) {
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
	}

	public List<Pedido> P_listarTudo() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p FROM Pedido p");
		List<Pedido> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void P_encerrar() {
		em.close();
	}

	public Pedido P_pesquisaC(int cod) {
		return em.find(Pedido.class, cod);
	}

	public void P_r(Pedido i) {
		em.getTransaction().begin();
		i = em.find(Pedido.class, i.getCod());
		em.remove(i);
		em.getTransaction().commit();
	}

	public void P_remover(int cod) {
		Pedido i = P_pesquisaC(cod);
		P_r(i);
	}

	public List<Pedido> P_pesquisaCod(int cod) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p FROM Pedido p WHERE cod = " + cod);
		List<Pedido> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Pedido> P_pesquisaTipo(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p FROM Pedido p WHERE tipo like '%" + c + "%'");
		List<Pedido> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Pedido> P_pesquisaPreco(float c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT p FROM Pedido p WHERE preco >=  " + c);
		List<Pedido> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void P_alterar(double d, int cod) {
		em.getTransaction().begin();
		Query query = em.createQuery("UPDATE Pedido p SET preco = '" + d + "' WHERE cod = " + cod);
		query.executeUpdate();
		em.getTransaction().commit();

	}

}
