package no.hvl.dat102.klient;

import no.hvl.dat102.Balansering;

import java.util.Scanner;

public class KlientBalansering{
    public static void main(String[] args){
        Scanner tastatur = new Scanner(System.in);
        System.out.print("Filnavn: ");
        final String filnavn = tastatur.nextLine() + ".txt";
        tastatur.close();


        Balansering balansering = new Balansering();
        balansering.lesFraFil(filnavn);

    }

}
