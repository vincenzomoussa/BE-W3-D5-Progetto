package it.epicode.main;

import it.epicode.exceptions.ElementoNonTrovatoException;
import it.epicode.exceptions.ErroreGenericoException;
import it.epicode.entities.Prestito;
import it.epicode.dao.PrestitoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainRicercaPrestitiScadutiENonRestituiti {
    public static void main(String[] args) throws ElementoNonTrovatoException, ErroreGenericoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // DAO

        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        //Ricerca

        List <Prestito> prestiti = prestitoDAO.findPrestitiScadutiNonRestituiti();
        for (Prestito p : prestiti) {
            System.out.println(p);
        } if (prestiti.isEmpty()) {
            System.out.println("Non sono presenti prestiti scaduti non restituiti!");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();












    }
}
