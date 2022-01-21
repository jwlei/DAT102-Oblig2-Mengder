package no.hvl.dat102.adt;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public interface StabelADT<T> {


    public void push (T element);



    public T pop();


    public T peek() ;




    public boolean erTom();



    public int antall();

}

