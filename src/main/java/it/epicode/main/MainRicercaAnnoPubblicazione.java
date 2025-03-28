package it.epicode.main;

import it.epicode.entities.Catalogo;
import it.epicode.dao.CatalogoDAO;
import it.epicode.exceptions.ElementoNonTrovatoException;
import it.epicode.exceptions.ErroreGenericoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainRicercaAnnoPubblicazione {
    public static void main(String[] args) throws  ErroreGenericoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //DAO
        CatalogoDAO catalogoDAO = new CatalogoDAO(em);

        //Ricerca

        List<Catalogo> risultati = catalogoDAO.findByAnno(2001);
        for (Catalogo c : risultati) {
            System.out.println(c);
        } if (risultati.isEmpty()) {
            System.out.println("Non sono stato scritti libri o riviste nell'anno selezionato!");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();












    }
}
