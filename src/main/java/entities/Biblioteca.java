package entities;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Catalogo> catalogo;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
    }

    public void aggiungi(Catalogo elemento) {
        catalogo.add(elemento);
    }

    public void rimuovi(String codiceIsbn) {
        catalogo.removeIf(elemento -> elemento.getCodiceIsbn().equals(codiceIsbn));
    }

    public Catalogo ricercaCodice(String codiceIsbn) {
        return catalogo.stream()
                .filter(elemento -> elemento.getCodiceIsbn().equals(codiceIsbn))
                .findFirst()
                .orElse(null);
    }

    public List<Catalogo> ricercaAnno(int annoPubblicazione) {
        List<Catalogo> risultati = new ArrayList<>();
        for (Catalogo elemento : catalogo) {
            if (elemento.getAnnoPubblicazione() == annoPubblicazione) {
                risultati.add(elemento);
            }
        }
        return risultati;
    }

    public List<Catalogo> ricercaAutore(String autore) {
        List<Catalogo> risultati = new ArrayList<>();
        for (Catalogo elemento : catalogo) {
            if (elemento instanceof Libro && ((Libro) elemento).getAutore().equals(autore)) {
                risultati.add(elemento);
            }
        }
        return risultati;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "catalogo=" + catalogo +
                '}';
    }
}