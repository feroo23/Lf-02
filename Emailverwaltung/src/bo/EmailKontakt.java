package bo;

public class EmailKontakt {

int id;
String vorname;
String nachname;
String emailadresse;

    public EmailKontakt(int id, String vorname, String nachname, String emailadresse) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.emailadresse = emailadresse;
    }

    public EmailKontakt(String vorname, String nachname, String emailadresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.emailadresse = emailadresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmailadresse() {
        return emailadresse;
    }

    public void setEmailadresse(String emailadresse) {
        this.emailadresse = emailadresse;
    }

    @Override
    public String toString() {
        String text = "\n\tID: " + getId();
        text += "\n\t\tVorname: " + getVorname();
        text += "\n\t\tNachname: " + getNachname();
        text += "\n\tEmailadresse: " + getEmailadresse();
        return text;
    }
}
