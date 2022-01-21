package no.hvl.dat102.medlemstabell;

public class Hobby {
    private String hobbyNavn;

    public Hobby(String hobby) {
            hobbyNavn = hobby;
    }

    public String toString() {
        return hobbyNavn;
    }

    public boolean equals(Object object) {
        if(!(object instanceof Hobby)){
            return false;
        }
        Hobby hobby2 = (Hobby) object;
        return (hobbyNavn.equalsIgnoreCase(hobby2.getHobbyNavn()));
    }

    public String getHobbyNavn() {
        return hobbyNavn;
    }
}
