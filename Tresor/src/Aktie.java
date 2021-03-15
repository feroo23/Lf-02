public class Aktie extends Gegenstand{

    private String unternehmen;
    private double nennwert;

    public Aktie(int id, double wert, String unternehmen, double nennwert) {
        super(id, wert);
        this.unternehmen = unternehmen;
        this.nennwert = nennwert;
    }

    public String getUnternehmen() {
        return unternehmen;
    }

    public void setUnternehmen(String unternehmen) {
        this.unternehmen = unternehmen;
    }

    public double getNennwert() {
        return nennwert;
    }

    public void setNennwert(double nennwert) {
        this.nennwert = nennwert;
    }

    @Override
    public String toString() {
        String text = "\n\tAktie";
        text += "\n\t\tAktienname: " + getUnternehmen();
        text += "\n\t\tNennwert: " + getNennwert();
        text += super.toString();
        return text;
    }
}
