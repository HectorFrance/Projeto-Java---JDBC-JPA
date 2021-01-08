package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Funcionario;

public class Controlador_Funcionario {

	EntityManagerFactory emf;
	EntityManager em;

	public Controlador_Funcionario() {
		emf = Persistence.createEntityManagerFactory("funcionario");
		em = emf.createEntityManager();
		
	}

	public void FUNC_adicioanr(Funcionario i) {
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
	}

	public List<Funcionario> FUNC_listarTudo() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT f FROM Funcionario f");
		List<Funcionario> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void FUNC_encerrar() {
		em.close();
	}

	public Funcionario FUNC_pesquisaCod(int cod) {
		return em.find(Funcionario.class, cod);
	}

	public void FUNC_r(Funcionario i) {
		em.getTransaction().begin();
		i = em.find(Funcionario.class, i.getCod());
		em.remove(i);
		em.getTransaction().commit();
	}

	public void FUNC_remover(int cod) {
		Funcionario i = FUNC_pesquisaCod(cod);
		FUNC_r(i);
	}

	public List<Funcionario> FUNC_pesquisaNome(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT f FROM Funcionario f WHERE nome like '%" + c + "%'");
		List<Funcionario> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Funcionario> FUNC_pesquisaCpf(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT f FROM Funcionario f WHERE cpf like '%" + c + "%'");
		List<Funcionario> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Funcionario> FUNC_pesquisaSetor(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT f FROM Funcionario f WHERE setor like '%" + c + "%'");
		List<Funcionario> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void FUNC_alterar(String c, int cod) {
		em.getTransaction().begin();
		Query query = em.createQuery("UPDATE Funcionario f SET setor = '" + c + "' WHERE cod = " + cod);
		query.executeUpdate();
		em.getTransaction().commit();

	}

}
