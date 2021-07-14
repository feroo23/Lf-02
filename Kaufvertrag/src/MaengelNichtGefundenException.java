public class MaengelNichtGefundenException extends Exception{

    private final String maengel;

    public MaengelNichtGefundenException(String maengel) {
        this.maengel = maengel;
    }

    public String getMaengel() {
        return maengel;
    }

    @Override
    public String toString() {
        return "Der Mängel [" + getMaengel() + "] Wurde nicht gefunden.";
    }

}
