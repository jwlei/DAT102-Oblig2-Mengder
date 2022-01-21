package no.hvl.dat102.medlemstabell;

import no.hvl.dat102.medlemstabell.Medlem;

public class Klient {
    public static void main(String[] args) {
        Datakontakt arkiv = new Datakontakt();

        Medlem m = Tekstgrensesnitt.lesMedlem();
        arkiv.leggTilMedlem(m);

        Medlem o = new Medlem("Ole");
        o.getHobbyer().leggTil(new Hobby("data"));
        o.getHobbyer().leggTil(new Hobby("data1"));
        arkiv.leggTilMedlem(o);

        Medlem p = new Medlem("Ole1");
        p.getHobbyer().leggTil(new Hobby("data1"));
        p.getHobbyer().leggTil(new Hobby("data2"));
        arkiv.leggTilMedlem(p);

        arkiv.finnPartnerFor("Ole");
        arkiv.finnPartnerFor("Ole1");

        Tekstgrensesnitt.skrivParliste(arkiv);
    }
}
