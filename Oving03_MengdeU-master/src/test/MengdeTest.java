package test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

abstract public class MengdeTest {
    MengdeADT<String> mengde1;
    MengdeADT<String> mengde2;

    void setMengde1(MengdeADT<String> mengde) {
        mengde.leggTil("Ole");
        mengde.leggTil("Ole1");
        mengde.leggTil("Ole2");
    }

    @Test
    void unionTest() {
        mengde2.leggTil("Ole");
        mengde2.leggTil("Ole1");

        MengdeADT<String> answer = mengde1.union(mengde2);

        assertEquals(5, answer.antall());
        assertTrue(answer.inneholder("Ole"));
        assertTrue(answer.inneholder("Ole1"));
        assertTrue(answer.inneholder("Ole2"));
    }

    @Test
    void unionTestIdentiske() {
        mengde2.leggTil("Ole");
        mengde2.leggTil("Ole1");
        mengde2.leggTil("Ole2");

        MengdeADT<String> answer = mengde1.union(mengde2);

        assertEquals(3, answer.antall());
    }


    @Test
    void snittTest() {
        mengde2.leggTil("Ole");
        mengde2.leggTil("Ole1");
        mengde2.leggTil("Ole2");

        MengdeADT<String> answer = mengde1.snitt(mengde2);

        assertEquals(2, answer.antall());
        assertTrue(answer.inneholder("Ole"));
        assertFalse(answer.inneholder("Ole1"));
        assertFalse(answer.inneholder("Ole2"));
    }

    @Test
    void snittTestIngenFelles() {
        mengde2.leggTil("Ole");
        mengde2.leggTil("Ole1");

        MengdeADT<String> answer = mengde1.snitt(mengde2);

        assertEquals(0, answer.antall());
    }

    @Test
     void differensTest() {
        mengde2.leggTil("Ole");
        mengde2.leggTil("Ole1");

        MengdeADT<String> answer = mengde1.differens(mengde2);

        assertEquals(1, answer.antall());
        assertTrue(answer.inneholder("Ole"));
        assertFalse(answer.inneholder("Ole1"));
        assertFalse(answer.inneholder("Ole2"));
    }

    @Test
    void differensTestIdentiske() {
        mengde2.leggTil("Ole");
        mengde2.leggTil("Ole1");
        mengde2.leggTil("Ole2");

        MengdeADT<String> answer = mengde1.differens(mengde2);

        assertEquals(0, answer.antall());
    }

    @Test
    void differensTestIngenFelles() {
        mengde2.leggTil("Ole");
        mengde2.leggTil("Ole1");

        MengdeADT<String> answer = mengde1.differens(mengde2);

        assertEquals(3, answer.antall());
    }

}
