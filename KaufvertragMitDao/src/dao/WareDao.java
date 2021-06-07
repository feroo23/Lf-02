package dao;

public class WareDao {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTINGSTRING = "jdbc:sqlite:KaufvertragMitDao/Kaufvertrag.db3";

    public WareDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
        System.out.println("Ware Hinzufügen");
    }
}