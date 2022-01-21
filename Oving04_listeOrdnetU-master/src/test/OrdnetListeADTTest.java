package test;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public abstract class OrdnetListeADTTest {


    private OrdnetListeADT<Integer> liste;


    private Integer e0 = 1;
    private Integer e1 = 2;
    private Integer e2 = 3;
    private Integer e3 = 4;
    private Integer e4 = 5;
    private Integer e5 = 6;



    protected abstract OrdnetListeADT<Integer> reset();

    @BeforeEach
    public final void setup() {
        liste = reset();
    }

    @Test
    public final void nyListeErTom() {
        assertTrue(liste.erTom());
    }


    private void leggTilElement(Integer e0, Integer e1, Integer e2, Integer e3, Integer e4, Integer e5) {
        liste.leggTil(e0);
        liste.leggTil(e1);
        liste.leggTil(e2);
        liste.leggTil(e3);
        liste.leggTil(e4);
        liste.leggTil(e5);
    }


    @Test
    public final void leggTilOgFjern() {
        leggTilElement(e0, e1, e2, e4, e5, e3);
        assertEquals(e0, liste.fjern(e0));
        assertEquals(e1, liste.fjern(e1));
        assertEquals(e2, liste.fjern(e2));
        assertEquals(e3, liste.fjern(e3));
        assertEquals(e4, liste.fjern(e4));
        assertEquals(e5, liste.fjern(e5));
    }

    protected abstract void assertEquals(Integer e0, Integer fjern);


    @Test
    public final void viseOrdnetIkkeAvtagende() {
        leggTilElement(e0, e2, e4, e1, e3,e5);
        assertEquals(e0, liste.fjernFoerste());
        assertEquals(e1, liste.fjernFoerste());
        assertEquals(e2, liste.fjernFoerste());
        assertEquals(e3, liste.fjernFoerste());
        assertEquals(e4, liste.fjernFoerste());
        assertEquals(e5, liste.fjernFoerste());
    }

    @Test
    public final void viseOrdnetIkkeStigende() {
        leggTilElement(e0, e2, e4, e1, e3,e5);
        assertEquals(e5, liste.fjernSiste());
        assertEquals(e4, liste.fjernSiste());
        assertEquals(e3, liste.fjernSiste());
        assertEquals(e2, liste.fjernSiste());
        assertEquals(e1, liste.fjernSiste());
        assertEquals(e0, liste.fjernSiste());
    }


    @Test
    public final void leggTilOgfjernMedDuplikater() {
        leggTilElement(e1, e0, e4, e1, e2, e3);
        assertEquals(e0, liste.fjern(e0));
        assertEquals(e1, liste.fjern(e1));
        assertEquals(e2, liste.fjern(e2));
        assertEquals(e1, liste.fjern(e1));
    }


    @Test
    public final void leggTilOgInnholder() {
        leggTilElement(e0,e1,e2,e1,e3,e4);

        assertTrue(liste.inneholder(e0));
        assertTrue(liste.inneholder(e1));
        assertTrue(liste.inneholder(e2));
        assertTrue(liste.inneholder(e3));
        assertTrue(liste.inneholder(e4));
        assertFalse(liste.inneholder(e5));

    }


    @Test
    public final void erIkkeTom() {
        liste.leggTil(e1);
        liste.leggTil(e3);
        liste.leggTil(e2);
        liste.leggTil(e4);
        liste.leggTil(e5);
        assertFalse(liste.erTom());
    }

    protected abstract void assertFalse(boolean erTom);


    @Test
    public final void leggTilFjernErTom() {
        liste.leggTil(e0);
        assertEquals(e0, liste.fjern(e0));
        assertTrue(liste.erTom());
    }


    @Test
    public final void fjernFraTomListe() {
        Assertions.assertThrows(EmptyCollectionException.class, () -> liste.fjernFoerste());
    }
}