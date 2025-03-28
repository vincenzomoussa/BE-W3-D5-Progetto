package it.epicode.main;

import it.epicode.entities.Catalogo;
import it.epicode.dao.CatalogoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainRicercaTitolo {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //DAO

        CatalogoDAO catalogoDAO = new CatalogoDAO(em);

        //Ricerca

        List<Catalogo> risultati = catalogoDAO.findByTitolo("Il");
        for (Catalogo c : risultati) {
            System.out.println(c); }
        if (risultati.isEmpty()) {
            System.out.println("Non sono presenti libri o riviste con questo titolo!");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();












    }
}
