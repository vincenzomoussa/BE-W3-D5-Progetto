package it.epicode.entities;
import it.epicode.enums.Periodicita;
import jakarta.persistence.*;

//Annotations

@Entity

//Inizio della classe

public class Rivista extends Catalogo {

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Periodicita periodicita;

    //Constructors

    public Rivista() {
    }

    public Rivista(Long id, String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(id, codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    // Getters e Setters

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    //To string

    @Override
    public String toString() {
        return "RIVISTA: " + "| Titolo: " + getTitolo() + " | Anno di pubblicazione: " + getAnnoPubblicazione() + " | Isbn: " + getCodiceISBN();
    }
}