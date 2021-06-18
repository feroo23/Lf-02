package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import businessObjects.Ware;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class WareDao {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTINGSTRING = "jdbc:sqlite:KaufvertragMitDao/Kaufvertrag.db3";

    public WareDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
        System.out.println("Ware Hinzufügen");
    }

    public Ware read(String warenNr) throws SQLException {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        Ware ware = null;
        try {
            //Verbindunge zu Datenbank herstellen
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            //SQL.Abfrage
            String sql = "select * From ware WHERE WarenNr =? ";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, warenNr);

            //SQL abfrage ausführen
            ResultSet resultSet = prepareStatement.executeQuery();

            //Zeiger auf dem Datensatz setzen
            resultSet.next();

            //resultSet Auswerten l
            String nr = resultSet.getString("WarenNr");
            String bezeichnung = resultSet.getString("Bezeichnung");
            String beschreibung = resultSet.getString("Beschreibung");
            int preis = resultSet.getInt("Preis");
            String besonderheiten = resultSet.getString("Besonderheiten");
            String maengel = resultSet.getString("Maengel");

            ware = new Ware(bezeichnung, preis);
            ware.setBeschreibung(beschreibung);
            ware.setWarenNr(warenNr);

            String[] listBesonderheiten = besonderheiten.split(", ");
            String[] listMaengel = maengel.split(", ");
            for (String s : listMaengel){
                ware.getMaengelListe().add(s);
            }
            for (String h : listBesonderheiten){
                ware.getBesonderheitenListe().add(h);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return ware;
        }
    }
    /**
     * Löscht einen Vertragspartner auf Basis seiner Ausweisnummer
     * @param warenNr Die Außweissnummer des Löschenden Vertragspartner.
     */

    public void delete(String warenNr){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //Verbindung zur Datenbank Herstellen
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            //Sql-Abfrage
            String SQL = "DELETE FROM ware WHERE WarenNr = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, warenNr) ;

            //SQl-Abfrage
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public ArrayList<Ware> read() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Ware ware = null;
        ArrayList<Ware> wareListe = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);
            String sql = "SELECT * FROM ware ";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nr = resultSet.getString("WarenNr");
                String bezeichnung = resultSet.getString("Bezeichnung");
                String beschreibung = resultSet.getString("Beschreibung");
                double preis = resultSet.getDouble("Preis");
                String besonderheiten = resultSet.getString("Besonderheiten");
                String maengel = resultSet.getString("Maengel");

                ware = new Ware(bezeichnung, preis);
                ware.setWarenNr(nr);
                ware.setBeschreibung(beschreibung);

                if (besonderheiten != null) {
                    String[] besonderheitenArray = besonderheiten.split(";");
                    for (String b : besonderheitenArray) {
                        ware.getBesonderheitenListe().add(b.trim());
                    }
                }
                if (maengel != null) {
                    String[] maengelArray = maengel.split(";");
                    for (String m : maengelArray) {
                        ware.getMaengelListe().add(m.trim());
                    }
                }
                wareListe.add(ware);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return wareListe;
    }

    public void update(Ware ware) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            String sql = "UPDATE Ware SET Bezeichnung = ?, Beschreibung = ?, Preis = ?, Besonderheiten = ?, Maengel = ? WHERE WarenNr = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, ware.getBezeichnung());
            preparedStatement.setString(2, ware.getBeschreibung());
            preparedStatement.setDouble(3, ware.getPreis());
            convertMaengelAndBesondeheitenToString(ware, preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
    public void convertMaengelAndBesondeheitenToString(Ware ware, PreparedStatement preparedStatement) throws SQLException {
        StringBuilder besonderheiten = null;
        for (int i = 0; i < ware.getBesonderheitenListe().size(); i++) {
            if (ware.getBesonderheitenListe().isEmpty()) {
                besonderheiten.append(ware.getBesonderheitenListe().get(i));
            } else {
                besonderheiten.append(';').append(ware.getBesonderheitenListe().get(i));
            }
        }
        preparedStatement.setString(4, besonderheiten.toString());
        StringBuilder maengel = null;
        for (int i = 0; i < ware.getMaengelListe().size(); i++) {
            if (ware.getMaengelListe().isEmpty()) {
                maengel.append(ware.getMaengelListe().get(i));
            } else {
                maengel.append(';').append(ware.getMaengelListe().get(i));
            }
        }
        preparedStatement.setString(5, maengel.toString());
        preparedStatement.setString(6, ware.getWarenNr());

        preparedStatement.executeUpdate();
    }
}