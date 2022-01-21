package test;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import org.junit.jupiter.api.BeforeEach;

public class KjedetTest<T> extends MengdeTest {

    @BeforeEach
    void setUp() {
        mengde1 = new KjedetMengde<>();
        mengde2 = new KjedetMengde<>();
        setMengde1(mengde1);
    }


}
