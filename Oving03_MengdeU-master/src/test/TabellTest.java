package test;

import no.hvl.dat102.mengde.tabell.TabellMengde;
import org.junit.jupiter.api.BeforeEach;

public class TabellTest extends MengdeTest{

    @BeforeEach
    void setUp() {
        mengde1 = new TabellMengde<>();
        mengde2 = new TabellMengde<>();
        setMengde1(mengde1);
    }

}
