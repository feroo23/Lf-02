public class BetragNichtKorrektException extends Exception{

    @Override
    public String getMessage() {
        return "Betrag nicht Korrekt";
    }
}
