public class GegenstandNichtGefundenException extends Exception{

    private int id;

    public GegenstandNichtGefundenException() {
        super();
    }

    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return "Der gegenstand wurde nicht gefunden versuche es nochmal";
    }
}
