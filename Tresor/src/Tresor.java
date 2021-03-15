import java.util.ArrayList;

public class Tresor {

    private ArrayList<Gegenstand> gegenstand;

    public Tresor(ArrayList<Gegenstand> gegenstand) {
        this.gegenstand = gegenstand;
    }

    public ArrayList<Gegenstand> getGegenstand(int id) {
        return gegenstand;
    }

    public void addGegenstand(Gegenstand gegenstand){

    }

    public void removeGegenstand(Gegenstand gegenstand){

    }

    public double brecheneGesamtwert(){
        double summe = 0;
        for (Gegenstand gegenstand: gegenstand){
            summe += gegenstand.getWert();
        }
        return summe;
    }

    @Override
    public String toString() {
        String amk = "\nTresor: ";
        amk += "\nGesamtwert: " + brecheneGesamtwert() + "€";
        amk += "\nInhalt: ";
        return amk;
    }
}
