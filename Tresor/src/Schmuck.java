public class Schmuck extends Gegenstand{

    private String bezeichnung;

    public Schmuck(int id, double wert, String beeichnung) {
        super(id, wert);
        this.bezeichnung = beeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Override
    public String toString() {
        String text = "\n\tSchmuck";
        text += "\n\t\tBezeichnung: " + getBezeichnung();
        text += super.toString();
        return text;
    }
}
