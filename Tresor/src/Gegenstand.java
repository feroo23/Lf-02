public abstract class Gegenstand {

    private int id;
    private double wert;

    public Gegenstand(int id, double wert) {
        this.id = id;
        this.wert = wert;
    }

    public int getId() {
        return id;
    }

    public double getWert() {
        return wert;
    }

    public void setWert(double wert) {
        this.wert = wert;
    }

    @Override
    public String toString() {
        String text = "\n\t\tWert: " + getWert();
        text += "\n\t\tID: " + getId();
        return text;
    }
}
