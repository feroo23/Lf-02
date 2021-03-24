import java.util.ArrayList;

public class Tresor {

    private ArrayList<Gegenstand> gegenstande;

    public Tresor(ArrayList<Gegenstand> gegenstand) {
        this.gegenstande = gegenstand;
    }

    public ArrayList<Gegenstand> getGegenstand(int id) throws GegenstandNichtGefundenException {
        for (Gegenstand gegenstand : gegenstande) {
            if (gegenstand.getId() == id) {

            }
        }return gegenstande;
    }

    public void addGegenstand(Gegenstand gegenstand) {
        gegenstande.add(gegenstand);
    }

    public void removeGegenstand(Gegenstand gegenstand) {
        gegenstande.remove(gegenstand);
    }

    public double brecheneGesamtwert() {
        double summe = 0;
        for (Gegenstand gegenstand : gegenstande) {
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
