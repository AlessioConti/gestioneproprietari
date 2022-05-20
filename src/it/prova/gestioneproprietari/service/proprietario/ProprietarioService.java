package it.prova.gestioneproprietari.service.proprietario;

import java.util.List;

import it.prova.gestioneproprietari.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietari.model.Proprietario;

public interface ProprietarioService {

	public List<Proprietario> listaTuttiProprietari() throws Exception;

	public Proprietario caricaSingoloProprietario(Long id) throws Exception;

	public void inserisci(Proprietario proprietarioInstance) throws Exception;

	public void aggiorna(Proprietario proprietarioInstance) throws Exception;

	public void rimuovi(Long idProprietarioInstance) throws Exception;

	public Long contaQuantiMacchinaImmatricolataDopo(int dataCheck) throws Exception;

	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);

}
