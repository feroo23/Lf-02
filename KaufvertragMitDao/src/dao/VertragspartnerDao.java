package dao;

import businessObjects.Vertragspartner;

public class VertragspartnerDao {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTINGSTRING = "jdbc:sqlite:KaufvertragMitDao/Kaufvertrag.db3";

    public VertragspartnerDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
        Vertragspartner vertragspartner =
    }
}

