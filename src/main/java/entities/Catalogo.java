package entities;

import java.util.Random;

public abstract class Catalogo {
    private long codiceIsbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public Catalogo(String titolo, int annoPubblicazione, int numeroPagine) {
        Random random = new Random();
        this.codiceIsbn = random.nextLong(111111111, 999999999);
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getCodiceIsbn() {
        return codiceIsbn;
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
}
