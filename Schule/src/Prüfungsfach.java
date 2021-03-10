public class Prüfungsfach extends Fach{

    private int prüfungsmin;

    public Prüfungsfach(int wochenstundenzahl, int prüfungsmin) {
        super(wochenstundenzahl);
        this.prüfungsmin = prüfungsmin;
    }

    public int getPrüfungsmin() {
        return prüfungsmin;
    }

    public void setPrüfungsmin(int prüfungsmin) {
        this.prüfungsmin = prüfungsmin;
    }
}
