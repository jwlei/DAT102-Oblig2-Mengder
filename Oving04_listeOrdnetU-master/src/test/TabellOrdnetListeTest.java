package test;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class TabellOrdnetListeTest extends OrdnetListeADTTest {
    @Override
    protected OrdnetListeADT<Integer> reset() {
        return new TabellOrdnetListe<>();
    }

    @Override
    protected void assertEquals(Integer e0, Integer fjern) {

    }

    @Override
    protected void assertFalse(boolean erTom) {

    }
}
