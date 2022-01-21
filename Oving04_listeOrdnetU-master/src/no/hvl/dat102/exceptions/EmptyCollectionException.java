package no.hvl.dat102.exceptions;

public class EmptyCollectionException extends RuntimeException{


    public EmptyCollectionException (String collection){
        super (" Samlingen: " + collection + " er tom.");
    }
}
