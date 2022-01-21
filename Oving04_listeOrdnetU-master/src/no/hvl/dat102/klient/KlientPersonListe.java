package no.hvl.dat102.klient;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

import java.util.Scanner;


public class KlientPersonListe {
    public static void main(String[] args) {
        OrdnetListeADT<Person> personListe = new TabellOrdnetListe<>(); // OR new KjedetOrdnetListe<>()

        Scanner tastatur = new Scanner(System.in);

        System.out.println("Legg til et nytt medlem.");
        String input = "JA";
        while ((input.equalsIgnoreCase("JA"))) {
            personListe.leggTil(Person.inputMedlem(tastatur));
            System.out.println("Vil du legge til et nytt medlem? Ja / Nei");
            input = tastatur.nextLine();
        }
        tastatur.close();

        while(!personListe.erTom()) {
            System.out.println(personListe.fjernFoerste().toString());
        }
    }
}
