package no.hvl.dat102.mengde.tabell;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TabellIterator<T> implements Iterator<T>{

    private int antall;
    private int pos;
    private T[] elementer;

   
   public TabellIterator(T[] tab, int lengde){
        elementer = tab;
        antall = lengde;
        pos = 0;
    }

    @Override
	public boolean hasNext(){

        return (pos < antall);
    }

    @Override
	public T next(){

        if(!hasNext())
        	throw new NoSuchElementException();        
        pos++;        
        return elementer[pos-1];
    }
    
   @Override
	public void remove(){
     System.out.println("Ikke implementert");
 }
}