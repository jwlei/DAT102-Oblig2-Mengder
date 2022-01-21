package no.hvl.dat102.exception;


public class EmptyCollectionException extends RuntimeException {

	public EmptyCollectionException(String samling) {
		super("" + samling + " er tom.");
	}
}
