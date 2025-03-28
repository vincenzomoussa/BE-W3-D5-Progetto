package it.epicode.dao;
import it.epicode.entities.Utente;
import it.epicode.exceptions.ErroreGenericoException;
import jakarta.persistence.EntityManager;

public class UtenteDAO {

    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) throws ErroreGenericoException {
        try {
            em.persist(utente);
        } catch (Exception e) {
            throw new ErroreGenericoException("Errore durante il salvataggio dell'utente: " + e.getMessage());
        }
    }

}