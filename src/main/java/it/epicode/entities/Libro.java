package it.epicode.entities;
import it.epicode.enums.Genere;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

//Annotations

@Entity

//Inizio della classe

public class Libro extends Catalogo {

    @Column(nullable = true)
    private String autore;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Genere genere;

    //Constructors

    public Libro(Long id, String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, Genere genere) {
        super(id, codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro() {
    }

// Getter e Setter

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    //To string

    @Override
    public String toString() {
        return "LIBRO: " + "| Titolo: " + getTitolo() + " | Autore: " + getAutore() + " | Anno di pubblicazione: " + getAnnoPubblicazione() + " | Isbn: " + getCodiceISBN();
    }
}