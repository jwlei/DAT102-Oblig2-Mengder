package no.hvl.dat102.medlemstabell;

public class Datakontakt {
    private Medlem[] medlemmer;
    private int antallMedlemmer;
    private static final int default_size = 10;

    public Datakontakt() {
        this(default_size);
    }

    public Datakontakt(int size) {
        antallMedlemmer = 0;
        medlemmer = new Medlem[size];
    }

    public int getAntallMedlemmer() {
        return antallMedlemmer;
    }

    public Medlem[] getMedlemmer() {
        return medlemmer;
    }

    public void leggTilMedlem(Medlem person) {
        if (medlemmer.length == antallMedlemmer) {
            utvidKapasitet(medlemmer);
        }
        medlemmer[antallMedlemmer] = person;
        antallMedlemmer++;
    }

    private void utvidKapasitet(Medlem[] tab) {
        Medlem[] utvidet = new Medlem[2 * tab.length];
        System.arraycopy(tab, 0, utvidet, 0, tab.length);
        medlemmer = utvidet;
    }

    public int finnMedlemIndeks(String medlemsnavn) {
        for (int i = 0; i < antallMedlemmer; i++) {
            if (medlemmer[i].getNavn().equals(medlemsnavn)) {
                return i;
            }
        }
        return -1;
    }

    public void finnPartnerFor(String medlemsnavn) {
        int mIndeks = finnMedlemIndeks(medlemsnavn);
        Medlem medlem = medlemmer[mIndeks];

        for (int i = 0; i < antallMedlemmer; i++) {
            if(!(medlemmer[i].equals(medlem))) {
                if (medlemmer[i].passerTil(medlem) && medlemmer[i].getStatusIndeks() == -1) {
                    medlemmer[i].setStatusIndeks(mIndeks);
                    medlem.setStatusIndeks(i);
                    return;
                }
            }
        }
    }

    public void tilbakestillStatusIndeks(String medlemsnavn) {
        Medlem medlem = medlemmer[finnMedlemIndeks(medlemsnavn)];

        if (medlem.getStatusIndeks() == -1) {
            return;
        }
        Medlem partner = medlemmer[medlem.getStatusIndeks()];
        medlem.setStatusIndeks(-1);
        partner.setStatusIndeks(-1);
    }
}
