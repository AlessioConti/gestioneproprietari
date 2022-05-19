package it.prova.gestioneproprietari.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneproprietari.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Automobile> list() throws Exception{
		return entityManager.createQuery("from automobile", Automobile.class).getResultList();
	}
	
	public Automobile get(Long id) throws Exception{
		return entityManager.find(Automobile.class, id);
	}
	
	public void update(Automobile automobileInstance) throws Exception{
		if(automobileInstance == null)
			throw new Exception("Valore in input non valido");
		
			automobileInstance = entityManager.merge(automobileInstance);
	}
	
	public void insert(Automobile automobileInstance) throws Exception{
		if(automobileInstance == null)
			throw new Exception("Valore in input non valido");
		
		entityManager.persist(automobileInstance);
	}
	
	public void delete(Automobile automobileInstance) throws Exception{
		if(automobileInstance == null)
			throw new Exception("Valore in input non valido");
		
		entityManager.remove(entityManager.merge(automobileInstance));
	}
	
	public List<Automobile> findAllProprietarioConCFIniziaCon(String iniziale) throws Exception{
		if(iniziale == null)
			throw new Exception("Valore in input non valido");
		
		TypedQuery<Automobile> query = entityManager.createQuery("from automobile a join a.proprietario p where p.nome like ?1", Automobile.class);
		return query.setParameter(1, iniziale+ "%").getResultList();
	}
	
	public List<Automobile> findAllAutomobiliConProprietariMinorenni() throws Exception{
		TypedQuery<Automobile> query = entityManager.createQuery("from automobile a join a.proprietario p where p.datanascita-2022 < 18", Automobile.class);
		
		return query.getResultList();
	}
}
