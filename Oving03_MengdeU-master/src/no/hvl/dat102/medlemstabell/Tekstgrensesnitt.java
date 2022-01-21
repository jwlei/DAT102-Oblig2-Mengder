package no.hvl.dat102.medlemstabell;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

import java.util.Scanner;

public class Tekstgrensesnitt {

    public static Medlem lesMedlem() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Medlemsnavn: ");
        Medlem medlem = new Medlem(scan.nextLine());

        System.out.println("Legg til hobby, eller avslutt med esc");
        String check = scan.nextLine();

        while (!(check.equalsIgnoreCase("esc"))) {
            medlem.getHobbyer().leggTil(new Hobby(check));
            System.out.println("Legg til hobby, eller avslutt med esc");
            check = scan.nextLine();
        }

        // scan.close();
        return medlem;
    }

    public static void skrivHobbyliste (Medlem medlem) {
         System.out.println(medlem.getHobbyer().toString());
    }

    public static void skrivParliste (Datakontakt arkiv) {
        int antallPar = 0;
        Medlem[] medlemmer = arkiv.getMedlemmer();

        MengdeADT<Medlem> brukteMedlemmer = new TabellMengde<>();

        for(int i = 0; i < arkiv.getAntallMedlemmer(); i++) {
            int partnerIndeks = medlemmer[i].getStatusIndeks();
            if (partnerIndeks != -1) {
                Medlem partner = medlemmer[partnerIndeks];
                Medlem aktueltMedlem = medlemmer[i];

                if(!(brukteMedlemmer.inneholder(partner))) {
                    brukteMedlemmer.leggTil(aktueltMedlem);
                    System.out.print(aktueltMedlem.getNavn() + " og " + medlemmer[partnerIndeks].getNavn() + "\t");
                    skrivHobbyliste(aktueltMedlem);
                    antallPar++;
                }
            }
        }
        System.out.println("Antall par: " + antallPar);
    }
}
