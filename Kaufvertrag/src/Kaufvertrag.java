public class Kaufvertrag {

    private vertragspartner verkäufer;
    private vertragspartner käufer;
    private ware Ware;
    private String zahlungsModalitaeten;

    public Kaufvertrag(vertragspartner verkäufer, vertragspartner käufer, ware ware) {
        this.verkäufer = verkäufer;
        this.käufer = käufer;
        Ware = ware;
    }

    public vertragspartner getVerkäufer() {
        return verkäufer;
    }

    public vertragspartner getKäufer() {
        return käufer;
    }

    public void setKäufer(vertragspartner käufer) {
        this.käufer = käufer;
    }

    public ware getWare() {
        return Ware;
    }

    public void setWare(ware ware) {
        Ware = ware;
    }

    public String getZahlungsModalitaeten() {
        return zahlungsModalitaeten;
    }

    public void setZahlungsModalitaeten(String zahlungsModalitaeten) {
        this.zahlungsModalitaeten = zahlungsModalitaeten;
    }
}
