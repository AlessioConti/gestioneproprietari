package it.prova.gestioneproprietari.service.automobile;

import java.util.List;

import it.prova.gestioneproprietari.model.Automobile;
import it.prova.gestioneproprietari.dao.automobile.AutomobileDAO;

public interface AutomobileService {
	
	public List<Automobile> listaTutteAutomobili() throws Exception;
	
	public Automobile caricaSingolaAutomobile(Long id) throws Exception;
	
	public void aggiorna(Automobile automobileInstance) throws Exception;
	
	public void inserisci(Automobile automobileInstance) throws Exception;
	
	public void rimuovi(Long idAutomobileInstance) throws Exception;
	
	public List<Automobile> cercaTuttiConCFProprietarioIniziaCon(String iniziale) throws Exception;
	
	public List<Automobile> cercaTutteAutomobiliConProprietariMinorenni() throws Exception;
	
	public void setAutomobileDAO(AutomobileDAO automobileDAO);
}
