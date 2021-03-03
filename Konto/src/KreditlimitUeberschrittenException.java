public class KreditlimitUeberschrittenException extends Exception{

    private double betrag;

    public KreditlimitUeberschrittenException(double betrag){
        this.betrag = betrag;
    }

    @Override
    public String getMessage() {
        return "Das Kreditlimit wurde Überschritten";
    }
}
