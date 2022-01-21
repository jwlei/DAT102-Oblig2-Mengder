package no.hvl.dat102.mengde.kjedet;

//****************************************************************

//    Representerer en iterator for en kjedet struktur av noder 
//    kjedet linjært.
//****************************************************************
import java.util.Iterator;
import java.util.NoSuchElementException;



public class KjedetIterator<T> implements Iterator<T> {
	private LinearNode<T> aktuell; // den aktuelle posisjonen.


	public KjedetIterator(LinearNode<T> samling) {
		aktuell = samling;
	}


	@Override
	public boolean hasNext() {
		return (aktuell != null);
	}


	@Override
	public T next() {
		T resultat = null;
		if (!hasNext())
			throw new NoSuchElementException();
		resultat = aktuell.getElement();
		aktuell = aktuell.getNeste();
		
		return resultat;
	}


	@Override
	public void remove() {
		System.out.println("Ikke implementert.");
	}

}
