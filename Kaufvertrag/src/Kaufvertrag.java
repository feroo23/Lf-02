public class Kaufvertrag {

    private Vertragspartner verkäufer;
    private Vertragspartner käufer;
    private Ware Ware;
    private String zahlungsModalitaeten;

    public Kaufvertrag(Vertragspartner verkäufer, Vertragspartner käufer, Ware ware) {
        this.verkäufer = verkäufer;
        this.käufer = käufer;
        this.zahlungsModalitaeten = ZahlungsModalitaeten();

        Ware = ware;
    }

    public Vertragspartner getVerkäufer() {
        return verkäufer;
    }

    public Vertragspartner getKäufer() {
        return käufer;
    }

    public void setKäufer(Vertragspartner käufer) {
        this.käufer = käufer;
    }

    public Ware getWare() {
        return Ware;
    }

    public void setWare(Ware ware) {
        Ware = ware;
    }

    public String getZahlungsModalitaeten() {
        return zahlungsModalitaeten;
    }

    public void setZahlungsModalitaeten(String zahlungsModalitaeten) {
        this.zahlungsModalitaeten = zahlungsModalitaeten;
    }

    @Override
    public String toString() {
        return  "Der Käufer ist [" + getKäufer().getVorname() + "] [" + getKäufer().getNachname() + "]\nDer Verkäufer ist [" + getVerkäufer().getVorname() + "] [" + getVerkäufer().getNachname() + "]\nDie Ware ist [" + getWare().getBezeichnung() + "]\nDer Preis ist [" + getWare().getPreis() + "]\nDie Zahlungsmodalitäten sind [" + getZahlungsModalitaeten() + "]";;
    }
}
