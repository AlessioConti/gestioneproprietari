package it.prova.gestioneproprietari.test;

import java.util.List;

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

			System.out.println("In tabella Proprietario sono presenti "
					+ proprietarioService.listaTuttiProprietari().size() + " elementi");
			System.out.println("In tabella Automobile sono presenti " + automobileService.listaTutteAutomobili().size()
					+ " elementi");

			/*
			  testInserisciProprietario(proprietarioService);
			  System.out.println("In tabella Proprietario sono presenti "
			  +proprietarioService.listaTuttiProprietari().size()+ " elementi");
			  
			  testInserisciAutomobile(automobileService);
			  System.out.println("In tabella Automobile sono presenti "
			  +automobileService.listaTutteAutomobili().size()+ " elementi");
			  
			  testRimozioneProprietario(proprietarioService);
			  System.out.println("In tabella Proprietario sono presenti "
			  +proprietarioService.listaTuttiProprietari().size()+ " elementi");
			  
			  testRimozioneAutomobile(automobileService);
			  System.out.println("In tabella Automobile sono presenti "
			  +automobileService.listaTutteAutomobili().size()+ " elementi");
			  
			  testLetturaProprietari(proprietarioService);
			  
			  testLetturaAutomobili(automobileService);
			  
			  testUpdateProprietario(proprietarioService);
			 
			testUpdateAutomobile(automobileService);
			 
			testLetturaSingolaProprietario(proprietarioService);
			*/
			testLetturaSingolaAutomobile(automobileService);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {

			EntityManagerUtil.shutdown();
		}

	}

	public static void testInserisciProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("testInserisciProprietario inizializzato.......");
		Proprietario nuovoProprietario = new Proprietario("Alessio", "Conti", "CNTLSS02E10H501D");
		if (nuovoProprietario.getId() != null)
			throw new RuntimeException("testInserisciProprietario FAILED: record gia presente");

		proprietarioService.inserisci(nuovoProprietario);

		if (nuovoProprietario.getId() == null)
			throw new RuntimeException("testInserisciProprietario FAILED: record non inserito correttamente");

		System.out.println("testInserisciProprietario concluso.......");
	}

	public static void testInserisciAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("testInserisciAutomobile inizializzato......");
		Automobile nuovaAutomobile = new Automobile("Toyota", "Yaris", "EJ431DD", 2010);
		if (nuovaAutomobile.getId() != null)
			throw new RuntimeException("testInserisciAutomobile FAILED: record gia presente");

		automobileService.inserisci(nuovaAutomobile);

		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAutomobile FAILED: record non inserito correttamente");

		System.out.println("testInserisciAutomobile concluso......");
	}

	public static void testRimozioneProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("testRimozioneProprietario inizializzato......");

		List<Proprietario> listaProprietari = proprietarioService.listaTuttiProprietari();
		if (listaProprietari.isEmpty())
			throw new RuntimeException("testRimozioneProprietario FAILED: non sono presenti record");

		Proprietario proprietarioDaRimuovere = listaProprietari.get(0);

		Long idRimozione = proprietarioDaRimuovere.getId();

		proprietarioService.rimuovi(idRimozione);

		if (proprietarioService.caricaSingoloProprietario(idRimozione) != null)
			throw new RuntimeException("testRimozioneProprietario FAILED: record non cancellato");

		System.out.println("testRimozioneProprietario concluso.....");
	}

	public static void testRimozioneAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("testRimozioneAutomobile inizializzato.....");
		List<Automobile> listaAutomobili = automobileService.listaTutteAutomobili();

		if (listaAutomobili.isEmpty())
			throw new RuntimeException("testRimozioneAutomobile FAILED: non sono presenti record");

		Automobile automobileDaRimuovere = listaAutomobili.get(0);

		Long idRimozione = automobileDaRimuovere.getId();

		automobileService.rimuovi(idRimozione);

		if (automobileService.caricaSingolaAutomobile(idRimozione) != null)
			throw new RuntimeException("testRimozioneAutomobile FAILED: record non cancellato");

		System.out.println("testRimozioneAutomobile concluso.....");
	}

	public static void testLetturaProprietari(ProprietarioService proprietarioService) throws Exception {
		System.out.println("testLetturaProprietari inizializzato......");
		Proprietario nuovoProprietario = new Proprietario("Andrea", "Versace", "Prova Prova1");
		Proprietario nuovoProprietario2 = new Proprietario("Giulia", "Conti", "Prova Prova2");
		proprietarioService.inserisci(nuovoProprietario);
		proprietarioService.inserisci(nuovoProprietario2);
		List<Proprietario> listaTuttiProprietari = proprietarioService.listaTuttiProprietari();
		for (Proprietario proprietarioInput : listaTuttiProprietari)
			System.out.println(proprietarioInput);

		System.out.println("testLetturaProprietari concluso......");
	}

	public static void testLetturaAutomobili(AutomobileService automobileService) throws Exception {
		System.out.println("testLetturaAutomobili inizializzato.....");
		Automobile nuovaAutomobile = new Automobile("Fiat", "Multipla", "JB222AD", 2003);
		Automobile nuovaAutomobile2 = new Automobile("Nissan", "Qasqai", "AM000GS", 2016);
		automobileService.inserisci(nuovaAutomobile);
		automobileService.inserisci(nuovaAutomobile2);
		List<Automobile> listaTutteAutomobili = automobileService.listaTutteAutomobili();
		for (Automobile automobileInput : listaTutteAutomobili)
			System.out.println(automobileInput);
		System.out.println("testLetturaAutomobili concluso.....");
	}

	public static void testUpdateProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("testUpdateProprietario inizializzato......");
		List<Proprietario> listaProprietari = proprietarioService.listaTuttiProprietari();
		if (listaProprietari.isEmpty())
			throw new RuntimeException("testUpdateProprietario FAILED: non sono presenti record");

		Proprietario proprietarioDaAggiornare = listaProprietari.get(0);
		System.out.println(proprietarioDaAggiornare);
		proprietarioDaAggiornare.setNome("Luca");
		proprietarioService.aggiorna(proprietarioDaAggiornare);
		System.out.println(proprietarioDaAggiornare);
		System.out.println("testUpdateProprietario concluso........");
	}

	public static void testUpdateAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println("testUpdateAutomobile inizializzato.......");
		List<Automobile> listaAutomobili = automobileService.listaTutteAutomobili();
		if (listaAutomobili.isEmpty())
			throw new RuntimeException("testUpdateAutomobile FAILED: non sono presenti record");
		Automobile automobileDaAggiornare = listaAutomobili.get(0);
		System.out.println(automobileDaAggiornare);
		automobileDaAggiornare.setMarca("Fiat");
		automobileService.aggiorna(automobileDaAggiornare);
		System.out.println(automobileDaAggiornare);
		System.out.println("testUpdateAutomobile concluso.......");
	}
	
	
	public static void testLetturaSingolaProprietario(ProprietarioService proprietarioService) throws Exception{
		System.out.println("testLetturaSingolaProprietario inizializzato.......");
		Long idPerRicerca = 2L;
		Proprietario risultatoRicerca = proprietarioService.caricaSingoloProprietario(idPerRicerca);
		if(risultatoRicerca == null)
			throw new RuntimeException("testLetturaSingolaProprietario FAILED: record non trovato");
		System.out.println(risultatoRicerca);
		System.out.println("testLetturaSingolaProprietario concluso.......");
	}
	
	public static void testLetturaSingolaAutomobile(AutomobileService automobileService) throws Exception{
		System.out.println("testLetturaSingolaAutomobile inizializzato.......");
		Long idPerRicerca = 4L;
		Automobile automobileRicerca = automobileService.caricaSingolaAutomobile(idPerRicerca);
		if(automobileRicerca == null)
			throw new RuntimeException("testLetturaSingolaAutomobile FAILED: record non trovato");
		System.out.println(automobileRicerca);
		System.out.println("testLetturaSingolaAutomobile concluso.......");
	}

}
