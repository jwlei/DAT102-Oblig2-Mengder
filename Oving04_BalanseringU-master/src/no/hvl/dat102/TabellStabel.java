package no.hvl.dat102;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellStabel<T> implements StabelADT<T> {
    private final static int STDK = 100;
    private int topp;
    private T[] stabel;


    public TabellStabel() {
        this(STDK);
    }


    public TabellStabel(int startKapasitet) {
        topp = 0;
        stabel = (T[]) (new Object[startKapasitet]);
    }

    @Override
    public void push(T element) {
        if (antall() == stabel.length)
            utvid();

        stabel[topp] = element;
        topp++;
    }

    @Override
    public T pop() {
        if (erTom())
            throw new EmptyCollectionException("Stabel");

        topp--;
        T result = stabel[topp];
        stabel[topp] = null;

        return result;
    }

    @Override
    public T peek() {
        if (erTom())
            throw new EmptyCollectionException("Stabel");

        return stabel[topp - 1];
    }

    @Override
    public boolean erTom() {
        return (topp == 0);
    }

    @Override
    public int antall() {
        return topp;
    }

    private void utvid() {
        T[] hjelpeTabell = (T[]) (new Object[stabel.length * 2]);

        for (int indeks = 0; indeks < stabel.length; indeks++) {
            hjelpeTabell[indeks] = stabel[indeks];
        }
        stabel = hjelpeTabell;

    }
}
