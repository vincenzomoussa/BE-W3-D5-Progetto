package it.epicode.main;

import it.epicode.dao.CatalogoDAO;
import it.epicode.exceptions.ElementoNonTrovatoException;
import it.epicode.exceptions.ErroreGenericoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRimozionePerIsbn {
    public static void main(String[] args) throws ElementoNonTrovatoException, ErroreGenericoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Rimozione

        CatalogoDAO catalogoDAO = new CatalogoDAO(em);
        catalogoDAO.removeByIsbn("0987654330");

        em.getTransaction().commit();
        em.close();
        emf.close();


    }

}
