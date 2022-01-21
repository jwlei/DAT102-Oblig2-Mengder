package no.hvl.dat102.klient;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Person implements Comparable<Person> {

    private String fornavn;
    private String etternavn;
    private int fodselsaar;


    public Person() {
        this("", "", 0);

    }

    public Person(String fornavn, String etternavn, int fodselsaar) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsaar = fodselsaar;

    }

    int getFodselsaar() {
        return fodselsaar;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String toString() {
        return (fodselsaar + "\t" + etternavn + ", " + fornavn);
    }


    public int compareTo(Person andre) {
        if( fodselsaar != andre.getFodselsaar()) {
            return andre.getFodselsaar() - fodselsaar;
        }
        if ((andre.getEtternavn().compareToIgnoreCase(etternavn)) != 0) {
            return etternavn.compareToIgnoreCase(andre.getEtternavn());
        }
        return fornavn.compareToIgnoreCase(andre.getFornavn());
    }


    public static Person inputMedlem(Scanner tastatur) {
        System.out.print("Fornavn: ");
        String fNamn = tastatur.nextLine();
        System.out.print("Etternavn: ");
        String eNamn = tastatur.nextLine();
        System.out.print("Fødselsår: ");
        int year = parseInt(tastatur.nextLine());
        return new Person(fNamn,eNamn,year);
    }
}