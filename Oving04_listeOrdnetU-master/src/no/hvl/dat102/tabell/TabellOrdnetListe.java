package no.hvl.dat102.tabell;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

    private final static int STDK = 100;
    private final static int IKKE_FUNNET = -1;
    private int bak;
    private T[] liste;

    public TabellOrdnetListe() {
        this(STDK);
    }

    public TabellOrdnetListe(int startKapasitet) {
        bak = 0;
        liste = (T[]) (new Comparable[startKapasitet]);
    }

    @Override
    public T fjernSiste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        bak--;
        T resultat = liste[bak];
        liste[bak] = null;

        return resultat;
    }

    @Override
    public T fjernFoerste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        T resultat = liste[0];
        bak--;
        if (bak >= 0) System.arraycopy(liste, 1, liste, 0, bak);
        liste[bak] = null;

        return resultat;
    }

    @Override
    public T foerste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        return liste[0];
    }

    @Override
    public T siste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        return liste[bak-1];
    }

    @Override
    public boolean erTom() {
        return (bak == 0);
    }

    @Override
    public int antall() {
        return bak;
    }

    @Override
    public void leggTil(T element) {
        if (liste.length == antall()) {
            utvid();
        }

        int scan = 0;
        while (scan < bak && liste[scan].compareTo(element) < 0) {
            scan++;
        }

        if (bak - scan >= 0) System.arraycopy(liste, scan, liste, scan + 1, bak - scan);

        liste[scan] = element;
        bak++;
    }

    @Override
    public boolean inneholder(T element) {
        return (finn(element) != IKKE_FUNNET);
    }

    @Override
    public T fjern(T element) {
        int indeks = finn(element);
        if (indeks == -1) {
            return element;
        } else if (indeks == 0) {
            fjernFoerste();
        } else if (indeks == bak-1) {
            fjernSiste();
        } else {
            bak--;
            for (int i = indeks; i < bak-1; i++) {
                liste[i] = liste[i+1];
            }
            liste[bak] = null;
        }
        return element;
    }

    private int finn(T element) {
        for (int i = 0; i < bak; i++) {
            if (liste[i].compareTo(element) == 0) {
                return i;
            }
        }
        return IKKE_FUNNET;
    }

    public String toString() {
        StringBuilder resultat = new StringBuilder();

        for (int i = 0; i < bak; i++) {
            resultat.append(liste[i].toString()).append("\n");
        }
        return resultat.toString();
    }

    private void utvid() {
        T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

        System.arraycopy(liste, 0, hjelpeTabell, 0, liste.length);
        liste = hjelpeTabell;
    }

}
