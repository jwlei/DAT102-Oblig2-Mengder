package test;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;


public class KjedetOrdnetListeTest extends  OrdnetListeADTTest{
    @Override
    protected OrdnetListeADT<Integer> reset() {
        return new KjedetOrdnetListe<>();
    }

    @Override
    protected void assertEquals(Integer e0, Integer fjern) {

    }

    @Override
    protected void assertFalse(boolean erTom) {

    }
}
