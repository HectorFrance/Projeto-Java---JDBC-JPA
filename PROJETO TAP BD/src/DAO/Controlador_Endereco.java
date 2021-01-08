package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Endereco;

public class Controlador_Endereco {

	EntityManagerFactory emf;
	EntityManager em;

	public Controlador_Endereco() {
		emf = Persistence.createEntityManagerFactory("endereco");
		em = emf.createEntityManager();
	}

	public void END_adicioanr(Endereco i) {
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
	}

	public List<Endereco> END_listarTudo() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Endereco e");
		List<Endereco> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void END_encerrar() {
		em.close();
	}

	public Endereco END_pesquisaCod(int cod) {
		return em.find(Endereco.class, cod);
	}

	public void END_r(Endereco i) {
		em.getTransaction().begin();
		i = em.find(Endereco.class, i.getCod());
		em.remove(i);
		em.getTransaction().commit();
	}

	public void END_remover(int cod) {
		Endereco i = END_pesquisaCod(cod);
		END_r(i);
	}

	public List<Endereco> END_pesquisaCidade(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Endereco e WHERE cidade like '%" + c + "%'");
		List<Endereco> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Endereco> END_pesquisaBairro(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Endereco e WHERE bairro like '%" + c + "%'");
		List<Endereco> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public List<Endereco> END_pesquisaRua(String c) {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT e FROM Endereco e WHERE rua like '%" + c + "%'");
		List<Endereco> l = query.getResultList();
		em.getTransaction().commit();
		return l;
	}

	public void END_alterar(String c, int cod) {
		em.getTransaction().begin();
		Query query = em.createQuery("UPDATE Endereco e SET complemento = '" + c + "' WHERE cod = " + cod);
		query.executeUpdate();
		em.getTransaction().commit();

	}

}
