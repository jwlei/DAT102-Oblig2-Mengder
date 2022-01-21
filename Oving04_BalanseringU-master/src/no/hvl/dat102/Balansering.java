package no.hvl.dat102;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

import java.io.*;

public class Balansering {
    StabelADT<Parentesinfo> stabel = new TabellStabel<>();
    int feil = 0;

    private boolean passer(char open, char lukket) {
        switch (open) {
            case '(':
                return (lukket == ')');
            case '[':
                return (lukket == ']');
            case '{':
                return (lukket == '}');
            default:
                return false;
        }
    }//

    public void foretaBalansering(String linje, int linjenr) {

        int lengde = linje.length();

        for (int pos = 0; pos < lengde; pos++) {
            char current = linje.charAt(pos);

            if(current == '(' || current == '{'|| current == '[') {
                stabel.push(new Parentesinfo(current, linjenr, pos));
            } else if (current == ')' || current == '}'|| current == ']') {
                if (stabel.erTom()) {

                    feil++;
                    System.out.println(new Parentesinfo(current, linjenr,pos).toStringTomStabel());
                } else {
                    Parentesinfo poppet = stabel.pop();
                    if ( !passer(poppet.getVenstreparentes(),current ) ) {

                        feil++;
                        System.out.println(poppet.toStringIkkeBalansert());
                    }
                }
            }
        }
    }


    public void lesFraFil(String filnavn) {
        FileReader tekstFilLeser = null;
        try {
            tekstFilLeser = new FileReader(filnavn);
        } catch (FileNotFoundException unntak) {
            System.out.println("Fil ikke funnet.");
            System.exit(-1);
        }

        BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
        String linje;
        int linjenr = 1;
        try {
            linje = tekstLeser.readLine();
            while (linje != null) {
                foretaBalansering(linje,linjenr);
                linjenr++;
                linje = tekstLeser.readLine();
            }


            if (!stabel.erTom()) {
                System.out.println("Stabelen er ikke tom etter innlesing.");
                while (!stabel.erTom()) {
                    feil++;
                    Parentesinfo rest = stabel.pop();
                    System.out.println(rest.toStringRest());
                }
            }
            if (feil == 0) {
                System.out.println("Filen er balansert.");
            } else {
                System.out.println("Filen trenger at du balanserer tegnene.");
            }
        }

        catch (IOException unntak) {
            System.out.println("Feil ved innlesing!");
            System.exit(-1);
        }

        catch (EmptyCollectionException unntak) {
            System.out.println("Stabelen er tom.");
            System.exit(-1);
        }

        try {
            tekstFilLeser.close();
        } catch (IOException unntak) {
            System.out.println("Feil ved lukking av fil!");
        }

    }

}
