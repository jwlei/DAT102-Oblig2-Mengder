package no.hvl.dat102.mengde.adt;

import no.hvl.dat102.exception.EmptyCollectionException;
import java.util.Iterator;

public interface MengdeADT<T> {


	void leggTil(T element);

	void leggTilAlle(MengdeADT<T> m2);

	T fjernTilfeldig();

	T fjern(T element);

	boolean inneholder(T element);

	boolean equals(Object m2);

	boolean erTom();

	int antall();

	MengdeADT<T> union(MengdeADT<T> m2);

	MengdeADT<T> snitt(MengdeADT<T> m2);

	MengdeADT<T> differens(MengdeADT<T> m2);

	boolean undermengde(MengdeADT<T> m2);

	Iterator<T> oppramser();

}
