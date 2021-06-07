package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;

import javax.print.DocFlavor;
import java.sql.*;

public class VertragspartnerDao {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTINGSTRING = "jdbc:sqlite:KaufvertragMitDao/Kaufvertrag.db3";

    public VertragspartnerDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
    }

    public Vertragspartner read(String ausweisNr) throws SQLException {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        try{
            //Verbindunge zu Datenbank herstellen
            connection = DriverManager.getConnection(CONNECTINGSTRING);
            Vertragspartner vertragspartner = null;

            //SQL.Abfrage
            String sql = "select * From vertragspartner WERE ausweisNR =? ";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1,ausweisNr);

            //SQL abfrage ausführen
            ResultSet resultSet = prepareStatement.executeQuery();

            //Zeiger auf dem Datensatz setzen
            resultSet.next();

            //resultSet Auswerten l
            String nr = resultSet.getString("AusweisNr");
            String vorname = resultSet.getString("Vorname");
            String nachname = resultSet.getString("nachname");
            String Straße = resultSet.getString("Straße");
            String HausNr = resultSet.getString("HausNr");
            String pzl = resultSet.getString("pzl");
            String Ort = resultSet.getString("Ort");

            //Vertragspartner
            vertragspartner = new Vertragspartner(vorname, nachname);
            vertragspartner.setAusweisNr(ausweisNr);
            Adresse adresse = new Adresse(Straße, HausNr, pzl, Ort);
            vertragspartner.getAdresse(adresse);

        }catch(SQLException e ){
            e.printStackTrace();
        }
        try {
            prepareStatement.close();
            connection.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}

