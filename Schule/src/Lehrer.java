import java.util.ArrayList;

public class Lehrer extends Fach{

    private ArrayList<Fach> faecher;

    public Lehrer(int wochenstundenzahl, ArrayList<Fach> faecher) {
        super(wochenstundenzahl);
        this.faecher = faecher;
    }

    public ArrayList<Fach> getFaecher() {
        return faecher;
    }

    public void setFaecher(ArrayList<Fach> faecher) {
        this.faecher = faecher;
    }

    public void unterrrichten(){

    }
}
