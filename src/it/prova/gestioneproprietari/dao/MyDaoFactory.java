package it.prova.gestioneproprietari.dao;

import it.prova.gestioneproprietari.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietari.dao.automobile.AutomobileDAOImpl;
import it.prova.gestioneproprietari.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietari.dao.proprietario.ProprietarioDAOImpl;

public class MyDaoFactory {

	// rendiamo questo factory SINGLETON
	private static AbitanteDAO abitanteDAOInstance = null;
	private static MunicipioDAO municipioDAOInstance = null;

	public static AbitanteDAO getAbitanteDAOInstance() {
		if (abitanteDAOInstance == null)
			abitanteDAOInstance = new AbitanteDAOImpl();
		return abitanteDAOInstance;
	}

	public static MunicipioDAO getMunicipioDAOInstance(){
		if(municipioDAOInstance == null)
			municipioDAOInstance= new MunicipioDAOImpl();
		return municipioDAOInstance;
	}

}
