import java.util.ArrayList;

public abstract class Schule {

    private ArrayList<Schüler> Schueler;
    private ArrayList<Lehrer> lehrer;

    public Schule(ArrayList<Schüler> schueler, ArrayList<Lehrer> lehrer) {
        Schueler = schueler;
        this.lehrer = lehrer;
    }

}
