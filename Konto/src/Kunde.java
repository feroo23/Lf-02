public class Kunde extends Person{

    private Mitarbeiter betreur;

    public Kunde(String vorname, String nachname, Adresse adresse, Mitarbeiter betreur) {
        super(vorname, nachname, adresse);
        this.betreur = betreur;
    }

    public Mitarbeiter getBetreur() {
        return betreur;
    }

    public void setBetreur(Mitarbeiter betreur) {
        this.betreur = betreur;
    }

    @Override
    public String toString() {
        String text = "Kunde" + super.toString();
        return text;
    }
}
