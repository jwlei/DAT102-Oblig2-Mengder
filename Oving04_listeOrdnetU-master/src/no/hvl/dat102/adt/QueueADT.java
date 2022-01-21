package no.hvl.dat102.adt;

public interface QueueADT<T> {

    void enqueue(T element);

    T dequeue();

    T first();

    boolean isEmpty();

    int size();

    String toString();
}
