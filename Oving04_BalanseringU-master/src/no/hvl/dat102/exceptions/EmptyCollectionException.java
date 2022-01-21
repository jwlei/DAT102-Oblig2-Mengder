package no.hvl.dat102.exceptions;


public class EmptyCollectionException extends RuntimeException{

    public EmptyCollectionException (String samling) {
        super ("" + samling + " er tom.");
    }
}
