package it.epicode.main;

import it.epicode.entities.Catalogo;
import it.epicode.dao.CatalogoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainRicercaAutore {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //DAO

        CatalogoDAO catalogoDAO = new CatalogoDAO(em);

        //Ricerca

        List<Catalogo> risultati = catalogoDAO.findByAutore("JRR Tolkien");
        for (Catalogo c : risultati) {
            System.out.println(c);
        } if (risultati.isEmpty()) {
            System.out.println("Non sono presenti libri o riviste scritti dall'autore selezionato!");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
