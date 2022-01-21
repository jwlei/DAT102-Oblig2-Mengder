package no.hvl.dat102;

public class Parentesinfo{

    private int linjenr;
    private int posisjon;
    private char vparentes;

    public Parentesinfo(char parentes, int linjenr, int posisjon) {
        this.linjenr = linjenr;
        this.posisjon = posisjon;
        vparentes = parentes;
    }

    public char getVenstreparentes(){ return vparentes;}

    public String toStringIkkeBalansert() {
        return String.format("Åpnesymbol %c på linje nr %d, tegn # %d har feil lukkeparentes", vparentes, linjenr, posisjon);
    }

    public String toStringRest() {
        return String.format("Åpnesymbol %c på linje nr %d, tegn # %d mangler tilsvarande parentes", vparentes, linjenr, posisjon);
    }
    public String toStringTomStabel() {
        return String.format("Lukkesymbol %c på linjenr %d, tegn # %d mangler tilsvarende åpnesymbol.",vparentes,linjenr,posisjon);
    }


}//class