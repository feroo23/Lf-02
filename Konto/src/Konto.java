public abstract class Konto {

    private Kunde inhaber;
    private double kontoStand;
    private double kreditLimit;
    private double zinsGuthaben;

    public Konto(Kunde inhaber, double kontoStand, double kreditLimit, double zinsGuthaben) {
        this.inhaber = inhaber;
        this.kontoStand = kontoStand;
        this.kreditLimit = kreditLimit;
        this.zinsGuthaben = zinsGuthaben;
    }

    public Kunde getInhaber() {
        return inhaber;
    }


    public double getKontoStand() {
        return kontoStand;
    }

    public double getKreditLimit() {
        return kreditLimit;
    }

    public void setKreditLimit(double kreditLimit) {
        this.kreditLimit = kreditLimit;
    }

    public double getZinsGuthaben() {
        return zinsGuthaben;
    }

    public void setZinsGuthaben(double zinsGuthaben) {
        this.zinsGuthaben = zinsGuthaben;
    }
    public void einzahlen(double betrag)throws BetragNichtKorrektException{
        if(betrag <= 0){
            throw new BetragNichtKorrektException();
        }
        else {
            kontoStand += betrag;
        }
    }

    public void auszahl(double betrag)throws KreditlimitUeberschrittenException{
        if(kontoStand - betrag >= 0 - kreditLimit ){
            kontoStand -= betrag;
        }
        else {
            throw new KreditlimitUeberschrittenException(betrag);
        }

    }
}
