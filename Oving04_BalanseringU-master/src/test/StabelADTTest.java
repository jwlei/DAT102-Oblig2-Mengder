package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.TabellStabel;
import no.hvl.dat102.adt.StabelADT;


public class StabelADTTest {


    protected static final int SIZE = 10;

    private StabelADT<Integer> stabel;

    private Integer e0 = 1;
    private Integer e1 = 2;
    private Integer e2 = 3;
    private Integer e3 = 4;


    @BeforeEach
    public void setup() {
        stabel = new TabellStabel<>(SIZE);
    }

    @Test
    public void newStackIsEmpty() {
        assertTrue(stabel.erTom());
    }


    @Test
    public void pushAndPop() {
        stabel.push(e0);
        stabel.push(e1);
        stabel.push(e2);
        stabel.push(e3);

        try {
            assertEquals(e3, stabel.pop());
            assertEquals(e2, stabel.pop());
            assertEquals(e1, stabel.pop());
            assertEquals(e0, stabel.pop());
        } catch (EmptyCollectionException e) {
            fail("pop failed unexpectedly " + e.getMessage());
        }
    }


    @Test
    public void pushAndPopWithDuplicates() {

        stabel.push(e0);
        stabel.push(e1);
        stabel.push(e1);
        stabel.push(e2);

        try {
            assertEquals(e2, stabel.pop());
            assertEquals(e1, stabel.pop());
            assertEquals(e1, stabel.pop());
            assertEquals(e0, stabel.pop());
        } catch (EmptyCollectionException e) {
            fail("pop failed unexpectedly " + e.getMessage());
        }
    }


    @Test
    public void pushPopPushPushPopPeek() {
        try {
            stabel.push(e2);
            stabel.pop();
            stabel.push(e3);
            stabel.push(e1);
            stabel.pop();
            assertEquals(e3, stabel.peek());

        } catch (EmptyCollectionException e) {
            fail("pop or top failed unexpectedly " + e.getMessage());
        }
    }

    @Test
    public void isNotEmpty() {
        stabel.push(e0);
        assertFalse(stabel.erTom());
    }


    @Test
    public void pushPopIsEmpty() {
        try {
            stabel.push(e0);
            stabel.pop();
            assertTrue(stabel.erTom());
        } catch (EmptyCollectionException e) {
            fail("pop failed unexpectedly " + e.getMessage());
        }
    }


    /**
     * Trying to pop an element from an empty stabel, should give an underflow
     * exception.
     *
     */
    @Test
    public void popFromEmptyIsUnderflowed() {
		 Assertions.assertThrows(EmptyCollectionException.class, () -> stabel.pop());
    }



    @Test
    public void utviderKoeSeg() {
        stabel.push(e1);
        for (int i = 0; i < SIZE; i++) {
            stabel.push(e0);
        }
        stabel.push(e2);
        assertEquals(SIZE + 2, stabel.antall());
        assertEquals(e2, stabel.pop());
        for (int i = 0; i < SIZE; i++) {
            stabel.pop();
        }
        assertEquals(e1, stabel.pop());
        assertTrue(stabel.erTom());
    }

}

