package it.epicode.entities;
import jakarta.persistence.*;

//Annotations

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "cataloghi")
@NamedQuery(name = "catalogo.find.anno.di.pubblicazione", query = "SELECT e FROM Catalogo e WHERE e.annoPubblicazione = :anno ORDER BY e.annoPubblicazione")
@NamedQuery(name = "catalogo.find.autore", query = "SELECT e FROM Catalogo e WHERE LOWER(e.autore) LIKE :autore ORDER BY e.autore")
@NamedQuery(name = "catalogo.find.titolo", query = "SELECT e FROM Catalogo e WHERE LOWER(e.titolo) LIKE :titolo ORDER BY e.titolo")


//Inizio della classe

public abstract class Catalogo {

    @Id
    @Column(name = "codice_isbn", unique = true, nullable = false)
    private String codiceISBN;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titolo;

    @Column(name = "anno_pubblicazione", nullable = false)
    private int annoPubblicazione;

    @Column(name = "numero_pagine", nullable = false)
    private int numeroPagine;

    //Constructors

    public Catalogo(Long id, String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.id = id;
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public Catalogo() {
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    //To string

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", codiceISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}