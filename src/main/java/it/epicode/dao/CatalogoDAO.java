package it.epicode.dao;
import it.epicode.entities.Catalogo;
import it.epicode.exceptions.ElementoNonTrovatoException;
import it.epicode.exceptions.ErroreGenericoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;

public class CatalogoDAO {

    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Catalogo elemento) throws ErroreGenericoException {
        try {
            em.persist(elemento);
            System.out.println("L'elemento " + elemento.getTitolo() + " è stato salvato correttamente");
        } catch (Exception e) {
            throw new ErroreGenericoException("Errore durante il salvataggio dell'elemento: " + e.getMessage());
        }
    }

    public void removeByIsbn(String isbn) throws ElementoNonTrovatoException, ErroreGenericoException {
        try {
            Catalogo elemento = em.find(Catalogo.class, isbn);
            em.remove(elemento);
            System.out.println("L'elemento " + elemento.getTitolo() + " è stato rimosso correttamente");
        } catch (NoResultException e) {
            throw new ElementoNonTrovatoException("Nessun elemento trovato con ISBN: " + isbn + "!");
        } catch (Exception e) {
            throw new ErroreGenericoException(
                    "L'Isbn selezionato si riferisce ad un elemento in prestito, pertanto non è possibile eliminarlo!");
        }
    }

    public Catalogo findByISBN(String isbn) throws ErroreGenericoException, ElementoNonTrovatoException {
        try {
            if (em.find(Catalogo.class, isbn) == null) {
                throw new ElementoNonTrovatoException("ISBN non esistente o cancellato!");
            }
            return em.find(Catalogo.class, isbn);
        } catch (NoResultException e) {
            throw new ElementoNonTrovatoException("Nessun elemento trovato con ISBN: " + isbn);
        } catch (Exception e) {
            throw new ErroreGenericoException(
                    "Errore durante la ricerca dell'elemento per ISBN: " + e.getMessage());
        }
    }

    public List<Catalogo> findByAnno(int anno)  throws ErroreGenericoException {
        try {
            return em.createNamedQuery("catalogo.find.anno.di.pubblicazione", Catalogo.class)
                    .setParameter("anno", anno)
                    .getResultList();
        } catch (Exception e) {
            throw new ErroreGenericoException("Errore durante la ricerca per anno di pubblicazione: " + e.getMessage());
        }
    }

    public List<Catalogo> findByAutore(String autore) {
            List<Catalogo> risultati = em
                    .createNamedQuery("catalogo.find.autore", Catalogo.class)
                    .setParameter("autore", "%" + autore.toLowerCase() + "%")
                    .getResultList();
            return risultati;
        }


    public List<Catalogo> findByTitolo(String titolo) {
            List<Catalogo> risultati = em
                    .createNamedQuery("catalogo.find.titolo", Catalogo.class)
                    .setParameter("titolo", "%" + titolo.toLowerCase() + "%")
                    .getResultList();
            return risultati;
        }

}