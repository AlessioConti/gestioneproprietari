package it.prova.gestioneproprietari.test;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
import it.prova.gestioneproprietari.model.Automobile;
import it.prova.gestioneproprietari.model.Proprietario;
import it.prova.gestioneproprietari.service.MyServiceFactory;
import it.prova.gestioneproprietari.service.automobile.AutomobileService;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioService;

public class TestProprietarioAutomobile {

	public static void main(String[] args) {
		
		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();
		
		try {
			
			System.out.println("In tabella Proprietario sono presenti " +proprietarioService.listaTuttiProprietari().size()+ " elementi");
			System.out.println("In tabella Automobile sono presenti " +automobileService.listaTutteAutomobili().size()+ " elementi");
			
			/*
			testInserisciProprietario(proprietarioService);
			System.out.println("In tabella Proprietario sono presenti " +proprietarioService.listaTuttiProprietari().size()+ " elementi");
			*/
			testInserisciAutomobile(automobileService);
			System.out.println("In tabella Automobile sono presenti " +automobileService.listaTutteAutomobili().size()+ " elementi");
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			
			EntityManagerUtil.shutdown();
		}
		
	}
	
	public static void testInserisciProprietario(ProprietarioService proprietarioService) throws Exception{
		System.out.println("testInserisciProprietario inizializzato.......");
		Proprietario nuovoProprietario = new Proprietario("Alessio", "Conti", "CNTLSS02E10H501D");
		if(nuovoProprietario.getId() != null)
			throw new RuntimeException("testInserisciProprietario FAILED: record gia presente");
		
		proprietarioService.inserisci(nuovoProprietario);
		
		if(nuovoProprietario.getId() == null)
			throw new RuntimeException("testInserisciProprietario FAILED: record non inserito correttamente");
			
		System.out.println("testInserisciProprietario concluso.......");
	}
	
	public static void testInserisciAutomobile(AutomobileService automobileService) throws Exception{
		System.out.println("testInserisciAutomobile inizializzato......");
		Automobile nuovaAutomobile = new Automobile("Toyota", "Yaris", "EJ431DD", 2010);
		if(nuovaAutomobile.getId() != null)
			throw new RuntimeException("testInserisciAutomobile FAILED: record gia presente");
		
		automobileService.inserisci(nuovaAutomobile);
		
		if(nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAutomobile FAILED: record non inserito correttamente");
		
		System.out.println("testInserisciAutomobile concluso......");
	}

}
