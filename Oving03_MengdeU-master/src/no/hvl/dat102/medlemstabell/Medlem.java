package no.hvl.dat102.medlemstabell;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Medlem {
    private String navn;
    private MengdeADT<Hobby> hobbyer;
    private int statusIndeks;

    public Medlem(String navn) {
        this.navn = navn;
        hobbyer = new TabellMengde<>();
        statusIndeks = -1;
    }

    public MengdeADT<Hobby> getHobbyer(){
            return hobbyer;
    }

    public String getNavn() {
        return navn;
    }

    public int getStatusIndeks() {
        return statusIndeks;
    }

    public void setStatusIndeks(int i) {
        statusIndeks = i;
    }

    public boolean passerTil (Medlem medlem2) {
        return hobbyer.equals(medlem2.getHobbyer());
    }

    public String toString() {
        return navn + ", hobbyer: " + hobbyer + " Status: " + statusIndeks;
    }
}
