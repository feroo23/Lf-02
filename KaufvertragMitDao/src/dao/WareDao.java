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

        //Verbindung zur Datenbank Herstellen
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            //Sql-Abfrage
            String SQL = "UPDATE Ware set Bezeichnung = ? , Beschreibung = ?, Preis = ?, Besoderheiten = ?, Maengel = ?  WHERE WarenNr = ?";
            preparedStatement.setString(1, ware.getBezeichnung());
            preparedStatement.setString(2, ware.getBeschreibung());
            preparedStatement.setDouble(3, ware.getPreis());


            preparedStatement.setArray(4, (Array) ware.getBesonderheitenListe());
            preparedStatement.setArray(5, (Array) ware.getMaengelListe());
            preparedStatement.setInt(6,2);

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

}