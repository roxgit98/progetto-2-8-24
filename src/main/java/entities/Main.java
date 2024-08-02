package entities;

import enums.Periodicità;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Biblioteca catalogo = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("Scegli un'operazione:");
                System.out.println("1. Aggiungi un elemento");
                System.out.println("2. Rimuovi un elemento dato un codice ISBN");
                System.out.println("3. Cerca per anno di pubblicazione");
                System.out.println("4. Cerca per autore");
                System.out.println("5. Esci");

                int scelta = scanner.nextInt();
                scanner.nextLine();

                switch (scelta) {
                    case 1:
                        aggiungiElemento();
                        break;
                    case 2:
                        rimuoviElemento();
                        break;
                    case 3:
                        cercaPerAnno();
                        break;
                    case 4:
                        cercaPerAutore();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Scelta non valida!");
                }
            } catch (Exception e) {
                System.out.println("ERRORE " + e.getMessage());
            }
        }
    }

    private static void aggiungiElemento() {
        try {
            System.out.println("Seleziona il tipo di elemento da aggiungere:");
            System.out.println("1. Libro");
            System.out.println("2. Rivista");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Codice ISBN: ");
            String codiceISBN = scanner.nextLine();

            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();

            System.out.print("Anno di pubblicazione: ");
            int annoPubblicazione = scanner.nextInt();

            System.out.print("Numero di pagine: ");
            int numeroPagine = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Autore: ");
                    String autore = scanner.nextLine();

                    System.out.print("Genere: ");
                    String genere = scanner.nextLine();

                    Libro libro = new Libro(codiceISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
                    catalogo.aggiungi(libro);
                    System.out.println("Libro aggiunto");
                    break;
                case 2:
                    System.out.println("Periodicità (1: SETTIMANALE, 2: MENSILE, 3: SEMESTRALE): ");
                    int periodicitaScelta = scanner.nextInt();
                    scanner.nextLine();

                    Periodicità periodicita;
                    switch (periodicitaScelta) {
                        case 1:
                            periodicita = Periodicità.SETTIMANALE;
                            break;
                        case 2:
                            periodicita = Periodicità.MENSILE;
                            break;
                        case 3:
                            periodicita = Periodicità.SEMESTRALE;
                            break;
                        default:
                            System.out.println("Scelta non valida!");
                            return;
                    }

                    Rivista rivista = new Rivista(codiceISBN, titolo, annoPubblicazione, numeroPagine, periodicita);
                    catalogo.aggiungi(rivista);
                    System.out.println("Rivista aggiunta con successo!");
                    break;
                default:
                    System.out.println("Scelta non valida, elemento non aggiunto.");
            }
        } catch (Exception e) {
            System.out.println("ERRORE " + e.getMessage());
        }
    }

    private static void rimuoviElemento() {
        try {
            System.out.print("Inserisci il codice ISBN dell'elemento da rimuovere: ");
            String codiceISBN = scanner.nextLine();

            catalogo.rimuovi(codiceISBN);
            System.out.println("Elemento rimosso (se esistente).");

        } catch (Exception e) {
            System.out.println("ERRORE " + e.getMessage());
        }
    }

    private static void cercaPerAnno() {
        try {
            System.out.print("Inserisci l'anno di pubblicazione: ");
            int annoPubblicazione = scanner.nextInt();
            scanner.nextLine();

            List<Catalogo> risultati = catalogo.ricercaAnno(annoPubblicazione);
            if (risultati.isEmpty()) {
                System.out.println("Nessun elemento trovato per l'anno di pubblicazione: " + annoPubblicazione);
            } else {
                System.out.println("Elementi trovati:");
                for (Catalogo elemento : risultati) {
                    System.out.println(elemento);
                }
            }
        } catch (Exception e) {
            System.out.println("ERRORE " + e.getMessage());
        }
    }

    private static void cercaPerAutore() {
        try {
            System.out.print("Inserisci il nome dell'autore: ");
            String autore = scanner.nextLine();

            List<Catalogo> risultati = catalogo.ricercaAutore(autore);
            if (risultati.isEmpty()) {
                System.out.println("Nessun elemento trovato per l'autore: " + autore);
            } else {
                System.out.println("Elementi trovati:");
                for (Catalogo elemento : risultati) {
                    System.out.println(elemento);
                }
            }
        } catch (Exception e) {
            System.out.println("ERRORE " + e.getMessage());
        }
    }
}
