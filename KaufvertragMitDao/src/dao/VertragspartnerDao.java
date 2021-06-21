package dao;

import businessObjects.Adresse;
import businessObjects.Vertragspartner;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;

public class VertragspartnerDao {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTINGSTRING = "jdbc:sqlite:KaufvertragMitDao/Kaufvertrag.db3";

    public VertragspartnerDao() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
    }

    public Vertragspartner read(String ausweisnummer) throws SQLException {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        Vertragspartner vertragspartner = null;
        try {
            //Verbindunge zu Datenbank herstellen
            connection = DriverManager.getConnection(CONNECTINGSTRING);
            vertragspartner = null;

            //SQL.Abfrage
            String sql = "select * From vertragspartner WHERE ausweisnummer =? ";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, ausweisnummer);

            //SQL abfrage ausführen
            ResultSet resultSet = prepareStatement.executeQuery();

            //Zeiger auf dem Datensatz setzen
            resultSet.next();

            //resultSet Auswerten l
            String nr = resultSet.getString("Ausweisnummer");
            String vorname = resultSet.getString("Vorname");
            String nachname = resultSet.getString("nachname");
            String Straße = resultSet.getString("Straße");
            String HausNr = resultSet.getString("HausNr");
            String Plz = resultSet.getString("Plz");
            String Ort = resultSet.getString("Ort");

            //Vertragspartner
            vertragspartner = new Vertragspartner(vorname, nachname);
            vertragspartner.setAusweisNr(ausweisnummer);
            Adresse adresse = new Adresse(Straße, HausNr, Plz, Ort);
            vertragspartner.setAdresse(adresse);


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
            return vertragspartner;
        }
    }
    private Vertragspartner createObject(ResultSet resultSet) throws SQLException {
        Vertragspartner vertragspartner = null;
        try {


            //ResultSet auswerten(vgl. Ergebnistablle)
            String nr = resultSet.getString("Ausweisnummer");
            String vorname = resultSet.getString("Vorname");
            String nachname = resultSet.getString("Nachname");
            String Straße = resultSet.getString("Straße");
            String HausNr = resultSet.getString("HausNr");
            String Plz = resultSet.getString("Plz");
            String Ort = resultSet.getString("Ort");


            // Vertragspartner Objekt erstellen
            vertragspartner = new Vertragspartner(vorname, nachname);
            vertragspartner.setAusweisNr(nr);
            Adresse adresse = new Adresse(Straße, HausNr, Plz, Ort);
            vertragspartner.setAdresse(adresse);
        }catch (SQLException e){
            e.printStackTrace();
        }


        return vertragspartner;
    }

    /**
     * Löscht einen Vertragspartner auf Basis seiner Ausweisnummer
     * @param ausweisnummer Die Außweissnummer des Löschenden Vertragspartner.
     */

    public void delete(String ausweisnummer){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //Verbindung zur Datenbank Herstellen
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            //Sql-Abfrage
            String SQL = "DELETE FROM vertragspartner WHERE ausweisnummer = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, ausweisnummer) ;

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

    public ArrayList<Vertragspartner> read() throws SQLException {
        Connection connection = null;
        PreparedStatement prepareStatment = null;
        Vertragspartner vertragspartner = null;
        ArrayList<Vertragspartner> vertragsPartnerliste = null;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);
            String sql = "Select * FROM vertragspartner ";
            prepareStatment = connection.prepareStatement(sql);
            ResultSet resultSet = prepareStatment.executeQuery();
            while (resultSet.next()) {
                String nr = resultSet.getString("AusweisNummer");
                String vorname = resultSet.getString("Vorname");
                String nachname = resultSet.getString("Nachname");
                String starße = resultSet.getString("Straße");
                String hausNr = resultSet.getString("HausNr");
                String plz = resultSet.getString("PLZ");
                String ort = resultSet.getString("Ort");
                vertragspartner = new Vertragspartner(vorname, nachname);

                Adresse adresse = new Adresse(starße, hausNr, plz, ort);
                vertragspartner.setAdresse(adresse);
                vertragsPartnerliste.add(vertragspartner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                prepareStatment.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return vertragsPartnerliste;
        }
    }

    /**
     * Aktualisiert Vertragspartner
     * @param vertragspartner Der zu aktusalierenden Vertragspartner mit neuen werten und zu suchender Ausweisnummer
     */
    public void update(Vertragspartner vertragspartner) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            String sql = "UPDATE Vertragspartner SET Vorname = ?, Nachname = ?, Straße = ?, HausNr = ?, Plz = ?, Ort = ? WHERE Ausweisnummer = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vertragspartner.getVorname());
            preparedStatement.setString(2, vertragspartner.getNachname());
            preparedStatement.setString(3, vertragspartner.getAdresse().getStrasse());
            preparedStatement.setString(4, vertragspartner.getAdresse().getHausNr());
            preparedStatement.setString(5, vertragspartner.getAdresse().getPlz());
            preparedStatement.setString(6, vertragspartner.getAdresse().getOrt());
            preparedStatement.setString(7, vertragspartner.getAusweisNr());

            preparedStatement.executeUpdate();

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

    /**
     * Fügt einen Vertragspartner hinzu
     * @param vertragspartner
     * @return Vertragsparrtner
     */
    public Vertragspartner crate(Vertragspartner vertragspartner) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);
            //SQL-Abfrage erstellen
            String sql = "INSERT INTO vertragspartner (Vorname, Nachname, Straße, HausNr, Plz, Ort, Ausweisnummer) VALUES (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vertragspartner.getVorname());
            preparedStatement.setString(2, vertragspartner.getNachname());
            preparedStatement.setString(3, vertragspartner.getAdresse().getStrasse());
            preparedStatement.setString(4, vertragspartner.getAdresse().getHausNr());
            preparedStatement.setString(5, vertragspartner.getAdresse().getPlz());
            preparedStatement.setString(6, vertragspartner.getAdresse().getOrt());
            preparedStatement.setString(7, vertragspartner.getAusweisNr());
            //SQL-Abfrage ausführen
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return vertragspartner;
    }
    /*
    public void SQLabfrage(PreparedStatement preparedStatement,Connection connection){
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    */

}


