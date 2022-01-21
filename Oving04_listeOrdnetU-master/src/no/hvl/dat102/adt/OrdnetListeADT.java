package no.hvl.dat102.adt;

public interface OrdnetListeADT<T extends Comparable<T>> extends ListeADT<T> {

    void leggTil(T element);


}
