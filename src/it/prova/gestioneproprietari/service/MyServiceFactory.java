package it.prova.gestioneproprietari.service;

import it.prova.gestioneproprietari.dao.MyDaoFactory;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioService;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioServiceImpl;
import it.prova.gestioneproprietari.service.automobile.AutomobileService;
import it.prova.gestioneproprietari.service.automobile.AutomobileServiceImpl;

public class MyServiceFactory {

	// rendiamo le istanze restituite SINGLETON
	private static ProprietarioService proprietarioServiceInstance = null;
	private static AutomobileService automobileServiceInstance = null;

	public static ProprietarioService getProprietarioServiceInstance() {
		if (proprietarioServiceInstance == null) {
			proprietarioServiceInstance = new ProprietarioServiceImpl();
			proprietarioServiceInstance.setProprietarioDAO(MyDaoFactory.getProprietarioDAOInstance());
		}
		return proprietarioServiceInstance;
	}

	public static AutomobileService getAutomobileServiceInstance() {
		if (automobileServiceInstance == null) {
			automobileServiceInstance = new AutomobileServiceImpl();
			automobileServiceInstance.setAutomobileDAO(MyDaoFactory.getAutomobileDAOInstance());
		}
		return automobileServiceInstance;
	}

}
