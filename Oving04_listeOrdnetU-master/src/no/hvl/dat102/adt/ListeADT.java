package no.hvl.dat102.adt;

import no.hvl.dat102.exceptions.EmptyCollectionException;


public interface ListeADT<T> {


    T fjern(T element);


    boolean inneholder(T element);


    T fjernFoerste();


    T fjernSiste();


    T foerste();


    T siste();


    boolean erTom();


    int antall();


}
