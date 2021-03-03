public class Mitarbeiter extends Person{

    public Mitarbeiter(String vorname, String nachname, Adresse adresse) {
        super(vorname, nachname, adresse);
    }

    @Override
    public String toString() {
        String text = "Mitarbeiter" + super.toString();
        return text;
    }
}
