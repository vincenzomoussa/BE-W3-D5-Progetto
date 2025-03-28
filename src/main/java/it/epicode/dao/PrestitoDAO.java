package it.epicode.dao;
import it.epicode.entities.Prestito;
import it.epicode.exceptions.ErroreGenericoException;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {

    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) throws ErroreGenericoException {
        try {
            em.persist(prestito);
        } catch (Exception e) {
            throw new ErroreGenericoException("Errore durante il salvataggio del prestito: " + e.getMessage());
        }
    }

    public List<Prestito> findByNumeroTessera(String numeroTessera) throws ErroreGenericoException {
        try {
            return em
                    .createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera", Prestito.class)
                    .setParameter("numeroTessera", numeroTessera)
                    .getResultList();
        } catch (Exception e) {
            throw new ErroreGenericoException(
                    "Errore durante la ricerca dei prestiti per numero tessera: " + e.getMessage());
        }
    }

    public List<Prestito> findPrestitiScadutiNonRestituiti() throws ErroreGenericoException {
        try {
            LocalDate oggi = LocalDate.now();
            return em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :oggi AND p.dataRestituzioneEffettiva IS NULL", Prestito.class)
                    .setParameter("oggi", oggi)
                    .getResultList();
        } catch (Exception e) {
            throw new ErroreGenericoException(
                    "Errore durante la ricerca dei prestiti scaduti non restituiti: " + e.getMessage());
        }
    }

}