package it.epicode.main;

import it.epicode.entities.Catalogo;
import it.epicode.dao.CatalogoDAO;
import it.epicode.exceptions.ElementoNonTrovatoException;
import it.epicode.exceptions.ErroreGenericoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainRicercaIsbn {
    public static void main(String[] args) throws ElementoNonTrovatoException, ErroreGenericoException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Ricerca

        CatalogoDAO catalogoDAO = new CatalogoDAO(em);
        Catalogo catalogo = catalogoDAO.findByISBN("1234567890");
        System.out.println("Elemento trovato: ");
        System.out.println(catalogo);

        em.getTransaction().commit();
        em.close();
        emf.close();












    }
}
