package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.medlemstabell.Hobby;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.exception.EmptyCollectionException;


public class TabellMengde<T> implements MengdeADT<T> {
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab =  (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		@SuppressWarnings("unchecked")
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		System.arraycopy(tab, 0, hjelpetabell, 0, tab.length);
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		int indeks = tilf.nextInt(antall);
		T svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;

		int i = 0;
		while (!funnet && i < this.antall) {
			if(tab[i].equals(element)) {
				svar = tab[i];
				antall--;
				tab[i] = tab[antall];
				tab[antall] = null;
				funnet = true;
			}
			i++;
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		for (int i = 0; i < antall; i++) {
			if (tab[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object m2) {
		if (m2 == this) {
			return true;
		}
		if (!(m2 instanceof MengdeADT)) {
			return false;
		}

		boolean likeMengder = true;
		T element;

		@SuppressWarnings("unchecked")
		var mengde2 = (MengdeADT<T>) m2;
		if(mengde2.antall() != this.antall) {
			return false;
		}

		Iterator<T> iterator = mengde2.oppramser();

		while (iterator.hasNext()) {
			element = iterator.next();
			if (!(this.inneholder(element))) {
				likeMengder = false;
				break;
			}
		}
		return likeMengder;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	private void settInnAlle(MengdeADT<T> mengde) {
		Iterator<T> iterator = mengde.oppramser();
		while(iterator.hasNext()) {
			settInn(iterator.next());
		}
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		var begge = new TabellMengde<T>();
		begge.settInnAlle(this);
		begge.leggTilAlle(m2);
		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		var snittM = new TabellMengde<T>();
		Iterator<T> iterator = m2.oppramser();
		while(iterator.hasNext()) {
			T element = iterator.next();
			if(this.inneholder(element)) {
				snittM.settInn(element);
			}
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<>();
		T element;
		Iterator<T> iterator = this.oppramser();
		while (iterator.hasNext()) {
			element = iterator.next();
			if( !(m2.inneholder(element))) {
				differensM.leggTil(element);
			}
		}

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<>(tab, antall);
	}

	@Override
	public String toString() {
		Iterator<T> iterator = oppramser();
		StringBuilder str = new StringBuilder("<");
		while(iterator.hasNext()) {
			str.append(iterator.next().toString());
			if (iterator.hasNext()) {
				str.append(", ");
			}
		}
		return str + ">";
	}

}
