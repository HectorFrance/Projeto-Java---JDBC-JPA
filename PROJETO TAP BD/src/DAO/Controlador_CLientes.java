package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Cliente;

public class Controlador_CLientes {

	EntityManagerFactory emf;
	EntityManager em;

	public Controlador_CLientes() {
		emf = Persistence.createEntityManagerFactory("cliente");
		em = emf.createEntityManager();
	}

	public void CL_adicioanr(Cliente i) {
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
	}

	public List<Cliente> CL_listarTudo() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c FROM Cliente c");
		List<Cliente> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void CL_encerrar() {
		em.close();
	}

	public Cliente CL_pesquisaCod(int cod) {
		return em.find(Cliente.class, cod);
	}

	public void CL_r(Cliente i) {
		em.getTransaction().begin();
		i = em.find(Cliente.class, i.getCod());
		em.remove(i);
		em.getTransaction().commit();
	}

	public void CL_remover(int cod) {
		Cliente i = CL_pesquisaCod(cod);
		CL_r(i);
	}

	public List<Cliente> CL_pesquisaNome(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c FROM Cliente c WHERE nome like '%" + c + "%'");
		List<Cliente> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Cliente> CL_pesquisaCpf(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c FROM Cliente c WHERE cpf like '%" + c + "%'");
		List<Cliente> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Cliente> CL_pesquisaTelefone(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c FROM Cliente c WHERE telefone like '%" + c + "%'");
		List<Cliente> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void CL_alterar(String c, int cod) {
		em.getTransaction().begin();
		Query query = em.createQuery("UPDATE Cliente c SET telefone = '" + c + "' WHERE cod = " + cod);
		query.executeUpdate();
		em.getTransaction().commit();

	}

}
