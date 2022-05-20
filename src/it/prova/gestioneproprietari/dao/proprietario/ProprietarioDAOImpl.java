package it.prova.gestioneproprietari.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneproprietari.model.Proprietario;

public class ProprietarioDAOImpl implements ProprietarioDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Proprietario> list() throws Exception {
		return entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();
	}

	public Proprietario get(Long id) throws Exception {
		return entityManager.find(Proprietario.class, id);
	}

	public void update(Proprietario proprietarioInstance) throws Exception {
		if (proprietarioInstance == null)
			throw new Exception("Errore nel valore inserito");

		proprietarioInstance = entityManager.merge(proprietarioInstance);
	}

	public void insert(Proprietario proprietarioInstance) throws Exception {
		if (proprietarioInstance == null)
			throw new Exception("Errore nel valore inserito");

		entityManager.persist(proprietarioInstance);
	}

	public void delete(Proprietario proprietarioInstance) throws Exception {
		if (proprietarioInstance == null)
			throw new Exception("Errore nel valore inserito");

		entityManager.remove(entityManager.merge(proprietarioInstance));
	}

	public Long contaQuantiConMacchinaDataImmatricolazioneDopo(int dataControllo) throws Exception {
		TypedQuery<Long> query = entityManager.createQuery(
				"select count(p) from Proprietario p join p.automobili a where a.annoImmatricolazione > ?1",
				Long.class);
		return query.setParameter(1, dataControllo).getSingleResult();
	}
}
