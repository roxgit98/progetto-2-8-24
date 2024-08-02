package entities;


import enums.Periodicità;

public class Rivista extends Catalogo {
    private Periodicità periodicità;


    public Rivista(String codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                '}' + super.toString();
    }

    
}
