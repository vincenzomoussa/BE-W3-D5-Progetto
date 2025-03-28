package it.epicode.main;
import it.epicode.entities.Catalogo;
import it.epicode.dao.CatalogoDAO;
import it.epicode.enums.Genere;
import it.epicode.exceptions.ElementoNonTrovatoException;
import it.epicode.exceptions.ErroreGenericoException;
import it.epicode.entities.Libro;
import it.epicode.entities.Prestito;
import it.epicode.dao.PrestitoDAO;
import it.epicode.enums.Periodicita;
import it.epicode.entities.Rivista;
import it.epicode.entities.Utente;
import it.epicode.dao.UtenteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class MainAggiunta {
    public static void main(String[] args) throws ErroreGenericoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        //DAO

        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
        CatalogoDAO catalogoDAO = new CatalogoDAO(em);

        //Utenti

          Utente utente1 = new Utente(null, "Vincenzo", "Moussa", LocalDate.of(1994,4,25));
          Utente utente2 = new Utente(null, "Mario", "Rossi", LocalDate.of(1990, 1, 1));
          Utente utente3 = new Utente(null, "Luigi", "Verdi", LocalDate.of(1980, 1, 1));
          Utente utente4 = new Utente(null, "Giovanni", "Bianchi", LocalDate.of(1970, 1, 1));
          Utente utente5 = new Utente(null, "Francesco", "Neri", LocalDate.of(1960, 1, 1));
          Utente utente6 = new Utente(null, "Giuseppe", "Gialli", LocalDate.of(1950, 1, 1));
          Utente utente7 = new Utente(null, "Alessandro", "Arancioni", LocalDate.of(1940, 1, 1));
          Utente utente8 = new Utente(null, "Andrea", "Bianchi", LocalDate.of(1930, 1, 1));
          Utente utente9 = new Utente(null, "Giovanna", "Verdi", LocalDate.of(1920, 1, 1));
          Utente utente10 = new Utente(null, "Sara", "Neri", LocalDate.of(1910, 1, 1));

        //Libri

          Catalogo libro1 = new Libro(null, "1234567890", "Il Signore degli Anelli", 2001, 1200, "JRR Tolkien", Genere.HORROR);
          Catalogo libro2 = new Libro(null, "1234567891", "Harry Potter", 1994, 1000, "JK Rowling", Genere.FANTASY);
          Catalogo libro3 = new Libro(null, "1234567892", "Il Nome della Rosa", 1980, 500, "Umberto Eco", Genere.AZIONE);
          Catalogo libro4 = new Libro(null, "1234567893", "Il Codice da Vinci", 2003, 800, "Dan Brown", Genere.COMMEDIA);
          Catalogo libro5 = new Libro(null, "1234567894", "1984", 1949, 350, "George Orwell", Genere.ROMANTICO);
          Catalogo libro6 = new Libro(null, "1234567895", "Il Grande Gatsby", 1925, 200, "F. Scott Fitzgerald", Genere.DRAMMATICO);
          Catalogo libro7 = new Libro(null, "1234567896", "Cronache del Ghiaccio e del Fuoco", 1991, 700, "George R. R. Martin", Genere.THRILLER);
          Catalogo libro8 = new Libro(null, "1234567897", "Il Piccolo Principe", 1943, 80, "Antoine de Saint-Exupéry", Genere.GIALLO);
          Catalogo libro9 = new Libro(null, "1234567898", "Orgoglio e Pregiudizio", 1813, 400, "Jane Austen", Genere.COMMEDIA);
          Catalogo libro10 = new Libro (null, "1234567899", "Cime Tempestose", 1844, 600, "Emily Brontë", Genere.AZIONE);

        //Riviste

          Catalogo rivista1 = new Rivista(null, "0987654321", "National Geographic", 2001, 100, Periodicita.MENSILE);
          Catalogo rivista2 = new Rivista(null, "0987654322", "Time", 2002, 80, Periodicita.SETTIMANALE);
          Catalogo rivista3 = new Rivista(null, "0987654323", "Forbes", 2003, 90, Periodicita.SEMESTRALE);
          Catalogo rivista4 = new Rivista(null, "0987654324", "Vanity Fair", 2004, 70, Periodicita.SETTIMANALE);
          Catalogo rivista5 = new Rivista(null, "0987654325", "Vogue", 2005, 60, Periodicita.MENSILE);
          Catalogo rivista6 = new Rivista(null, "0987654326", "Wired", 2006, 50, Periodicita.ANNUALE);
          Catalogo rivista7 = new Rivista(null, "0987654327", "The Economist", 2007, 40, Periodicita.MENSILE);
          Catalogo rivista8 = new Rivista(null, "0987654328", "National Geographic", 2008, 30, Periodicita.SEMESTRALE);
          Catalogo rivista9 = new Rivista(null, "0987654329", "Time", 2009, 20, Periodicita.MENSILE);
          Catalogo rivista10 = new Rivista(null, "0987654330", "Forbes", 2010, 10, Periodicita.ANNUALE);

        //Prestiti

          Prestito prestito1 = new Prestito(null, utente1, rivista1, LocalDate.of(2025,2,28), LocalDate.of(2025,3,30), LocalDate.of(2025, 3, 25));
          Prestito prestito2 = new Prestito(null, utente2, libro1, LocalDate.of(2020, 11, 10), LocalDate.of(2020, 12, 10), LocalDate.of(2020, 12, 15));
          Prestito prestito3 = new Prestito(null, utente3, libro2, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 31), LocalDate.of(2021, 2, 1));
          Prestito prestito4 = new Prestito(null, utente4, libro3, LocalDate.of(2021, 2, 1), LocalDate.of(2021, 2, 28), null);
          Prestito prestito5 = new Prestito (null, utente5, rivista2, LocalDate.of(2025,2,1), LocalDate.of(2025,2,28), LocalDate.of(2025,2,15));
          Prestito prestito6 = new Prestito (null, utente6, rivista3, LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 31), null);
          Prestito prestito7 = new Prestito (null, utente7, libro4, LocalDate.of(2025, 3, 15), LocalDate.of(2025, 4, 15), null);
          Prestito prestito8 = new Prestito (null, utente8, libro5, LocalDate.now(), LocalDate.of(2025, 4, 30), null);
          Prestito prestito9 = new Prestito (null, utente9, rivista4, LocalDate.now(), LocalDate.of(2025, 5, 15), null);
          Prestito prestito10 = new Prestito (null, utente10, rivista6, LocalDate.now(), LocalDate.of(2025, 5, 30), null);

        //Racchiudo qui tutte le transazioni e chiudo gli Entity Managers

        em.getTransaction().begin();

          //Utenti
        for (Utente utente : new Utente[]{utente1, utente2, utente3, utente4, utente5, utente6, utente7, utente8, utente9, utente10}) {
            utenteDAO.save(utente);
        }

          //Libri
        for (Catalogo libro : new Catalogo[]{libro1, libro2, libro3, libro4, libro5, libro6, libro7, libro8, libro9, libro10}) {
            catalogoDAO.insert(libro);
        }

          //Riviste
        for (Catalogo rivista : new Catalogo[]{rivista1, rivista2, rivista3, rivista4, rivista5, rivista6, rivista7, rivista8, rivista9, rivista10}) {
            catalogoDAO.insert(rivista);
        }

          //Prestiti
        for (Prestito prestito : new Prestito[]{prestito1, prestito2, prestito3, prestito4, prestito5, prestito6, prestito7, prestito8, prestito9, prestito10}) {
            prestitoDAO.save(prestito);
        }

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
