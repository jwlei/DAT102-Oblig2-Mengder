package no.hvl.dat102.mengde.kjedet;

import java.util.*;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall;
	private LinearNode<T> start;


	public KjedetMengde() {
		antall = 0;
		start = null;
	}

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	private void settInnAlle(KjedetMengde<T> mengde) {
		Iterator<T> iterator = mengde.oppramser();
		while (iterator.hasNext()) {
			settInn(iterator.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}

	@Override
	public T fjern(T element) {

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		if (start.getElement().equals(element)) {
			resultat = start.getElement();
			start = start.getNeste();
			return resultat;
		}

		forgjenger = start;
		aktuell = start.getNeste();
		while (!funnet && aktuell!=null) {
			if(aktuell.getElement().equals(element)) {
				forgjenger.setNeste(aktuell.getNeste());
				resultat = aktuell.getElement();
				antall--;
				funnet = true;
			} else {
				forgjenger = aktuell;
				aktuell = aktuell.getNeste();
			}
		}
		return resultat;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(Object m2) {
		if (m2 == this) {
			return true;
		}
		if (!(m2 instanceof MengdeADT)) {
			return false;
		}

		@SuppressWarnings("unchecked")
		var ny = (MengdeADT<T>) m2;

		if (ny.antall() != this.antall) {
			return false;
		}

		Iterator<T> iterator = ny.oppramser();
		while (iterator.hasNext()) {
			if (!this.inneholder(iterator.next())) {
				return false;
			}
		}
		return true;
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
	public MengdeADT<T> union(MengdeADT<T> m2) {
		var begge = new KjedetMengde<T>();
		begge.settInnAlle(this);
		begge.leggTilAlle(m2);
		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		var snittM = new KjedetMengde<T>();
		T element;
		Iterator<T> iterator = m2.oppramser();
		while (iterator.hasNext()) {
			element = iterator.next();
			if (this.inneholder(element)) {
				snittM.settInn(element);
			}
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<>();
		Iterator<T> iterator = this.oppramser();
		while (iterator.hasNext()) {
			T element = iterator.next();
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
		return new KjedetIterator<>(start);
	}

}
