package it.prova.gestioneproprietari.dao.proprietario;

import it.prova.gestioneproprietari.dao.IBaseDAO;
import it.prova.gestioneproprietari.model.Proprietario;

public interface ProprietarioDAO extends IBaseDAO<Proprietario> {
	
	public int contaQuantiConMacchinaDataImmatricolazioneDopo(int dataControllo) throws Exception;
}