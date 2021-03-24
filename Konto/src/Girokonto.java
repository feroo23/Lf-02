public class Girokonto extends Konto{

    private double zinsKredit;

    public Girokonto(Kunde inhaber, double kontoStand, double kreditLimit, double zinsGuthaben, double zinsKredit) {
        super(inhaber, kontoStand, kreditLimit, zinsGuthaben);
        this.zinsKredit = zinsKredit;
    }

    public double getZinsKredit() {
        return zinsKredit;
    }

    public void setZinsKredit(double zinsKredit) {
        this.zinsKredit = zinsKredit;
    }
    public void ueberweisen(double betrag, Girokonto girokonto)throws KreditlimitUeberschrittenException, BetragNichtKorrektException{
        super.auszahl(betrag);
        girokonto.einzahlen(betrag);
    }

    @Override
    public String toString() {
        String text = "\n\tKonto inhaber: " + getInhaber();
        text += "\n\tKonto stand: " + getKontoStand();
        text += "\n\tkredit limit: " + getKreditLimit();
        text += "\n\tZins Guthaben: " + getZinsGuthaben();
        text += "\n\tZins Kredit: " + getZinsKredit();
        return text;
    }
}
