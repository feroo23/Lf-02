import java.util.ArrayList;

public abstract class Schule {

    private ArrayList<Schüler> Schueler;
    private ArrayList<Lehrer> lehrer;

    public Schule(ArrayList<Schüler> schueler, ArrayList<Lehrer> lehrer) {
        Schueler = schueler;
        this.lehrer = lehrer;
    }

    public ArrayList<Schüler> getSchueler() {
        return Schueler;
    }

    public void setSchueler(ArrayList<Schüler> schueler) {
        Schueler = schueler;
    }

    public ArrayList<Lehrer> getLehrer() {
        return lehrer;
    }

    public void setLehrer(ArrayList<Lehrer> lehrer) {
        this.lehrer = lehrer;
    }
}
