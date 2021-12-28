package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("Projeto_Agenda");
		} catch (Exception e) {

		}
	}

	public DAO() {
		this(null);
	}

	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	public DAO<E> beginTransaction() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> commitTransaction() {
		em.getTransaction().commit();
		return this;
	}

	public DAO<E> persist(E entidade) {
		em.persist(entidade);
		return this;
	}

	public DAO<E> fullPersist(E entidade) {
		return this.beginTransaction().persist(entidade).commitTransaction();
	}

	public DAO<E> detach(E entidade) {
		em.detach(entidade);
		return this;
	}

	public DAO<E> merge(E entidade) {
		em.merge(entidade);
		return this;
	}

	public void closeEM() {
		em.close();
	}

	public E findByID(Object id) {
		return em.find(classe, id);
	}

	public void delete(E entidade) {
		em.remove(entidade);
	}

	public List<E> searchAll() {
		return this.searchAll(10, 0);
	}

	public List<E> searchAll(int limite, int deslocamento) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}

		String jpql = "SELECT c FROM " + classe.getName() + " c";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(limite);
		query.setFirstResult(deslocamento);

		return query.getResultList();
	}

	public List<E> search(String nome) {
		String jpql = "SELECT c FROM Contatos c WHERE nome LIKE '%" + nome + "%'";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		return query.getResultList();

	}

}
