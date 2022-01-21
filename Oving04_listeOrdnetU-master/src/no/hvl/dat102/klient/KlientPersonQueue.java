package no.hvl.dat102.klient;

import no.hvl.dat102.adt.QueueADT;
import no.hvl.dat102.queue.CircularArrayQueue;
import no.hvl.dat102.queue.LinkedQueue;

import java.util.Scanner;


public class KlientPersonQueue {
    public static void main (String[] args) {
        QueueADT<Person> personQueue = new LinkedQueue<>();
        Scanner tastatur = new Scanner(System.in);

        System.out.println("Legg til et nytt medlem.");
        String input = "JA";
        while ((input.equalsIgnoreCase("JA"))) {
            personQueue.enqueue(Person.inputMedlem(tastatur));
            System.out.println("Vil du legge til et nytt medlem? Ja / Nei");
            input = tastatur.nextLine();
        }

        tastatur.close();

        while (!personQueue.isEmpty()) {
            System.out.println(personQueue.dequeue().toString());
        }

    }
}
