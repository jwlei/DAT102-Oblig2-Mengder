package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;


public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste, siste;


    public KjedetOrdnetListe() {
        antall = 0;
        foerste = null;
        siste = null;
    }

    @Override
    public T fjernFoerste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        T resultat = foerste.getElement();

        if (antall == 1) {

            foerste = null;
            siste = null;
        } else {
            foerste = foerste.getNeste();
        }
        antall--;

        return resultat;
    }

    @Override
    public T fjernSiste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        T resultat = siste.getElement();

        if (antall == 1) {
            foerste = null;
            siste = null;
        } else {
            LinearNode<T> teller = foerste;
            while (teller.getNeste().getNeste() != null) {
                teller = teller.getNeste();
            }
            siste = teller;
            siste.setNeste(null);
        }
        antall--;
        return resultat;
    }

    @Override
    public T foerste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        return foerste.getElement();
    }

    @Override
    public T siste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        return siste.getElement();
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public int antall() {
        return antall;
    }


    @Override
    public void leggTil(T element) {

        LinearNode<T> nyNode = new LinearNode<>(element); // neste = null

        if ( erTom() ) {
            foerste = nyNode;
            siste = nyNode;
        } else if (foerste.getElement().compareTo(element) > 0) {
            nyNode.setNeste(foerste);
            foerste = nyNode;
        } else if (siste.getElement().compareTo(element) < 0) {
            siste.setNeste(nyNode);
            siste = nyNode;
        } else {
            LinearNode<T> aktuell = foerste;
            while (aktuell.getNeste() != null && aktuell.getNeste().getElement().compareTo(element) < 0) {
                aktuell = aktuell.getNeste();
            }
            nyNode.setNeste(aktuell.getNeste());
            aktuell.setNeste(nyNode);
        }
        antall++;
    }

    @Override
    public T fjern(T element) {
        T svar = null;
        LinearNode<T> forrige = null, denne = foerste;
        while (denne != null && element.compareTo(denne.getElement()) > 0) {
            forrige = denne;
            denne = denne.getNeste();
        }
        if (denne != null && element.equals(denne.getElement())) {
            antall--;
            svar = denne.getElement();
            if (forrige == null) {
                foerste = foerste.getNeste();
                if (foerste == null) {
                    siste = null;
                }
            } else {
                forrige.setNeste(denne.getNeste());
                if (denne == siste) {
                    siste = forrige;
                }
            }
        }
        return svar;
    }

    @Override
    public boolean inneholder(T element) {
        LinearNode<T> denne = foerste;
        boolean resultat = false;
        while (denne != null && element.compareTo(denne.getElement()) > 0) {
            denne = denne.getNeste();
        }
        if (denne != null) {
            if (element.equals(denne.getElement())) {
                resultat = true;
            }
        }
        return resultat;
    }

}

