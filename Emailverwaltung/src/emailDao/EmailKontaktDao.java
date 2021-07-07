package emailDao;

import bo.EmailKontakt;

import java.sql.*;


public class EmailKontaktDao {
    private final String CLASSNAME = "org.sqlite.JDBC";
    private final String CONNECTINGSTRING = "jdbc:sqlite:Emailverwaltung/Mail.db";

    public void EmailkontakDAO() throws ClassNotFoundException {
        Class.forName(CLASSNAME);
    }

    public EmailKontakt select(int ID) throws MailException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        EmailKontakt emailKontakt;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            String sql = "SELECT * FROM Email WHERE ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            emailKontakt = creatObject(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MailException("Dattensatz nicht vorhanden");
        } finally {
            if (connection != null) {
                close(connection, preparedStatement);
            }
        }
        return emailKontakt;
    }

    private EmailKontakt creatObject(ResultSet resultSet) throws SQLException {
        EmailKontakt emailKontakt;

        int id  = resultSet.getInt("ID");
        String vorname = resultSet.getString("Vorname");
        String nachname = resultSet.getString("Nachname");
        String emailadresse = resultSet.getString("Emailadresse");
        emailKontakt = new EmailKontakt(vorname, nachname, emailadresse);
        emailKontakt.setId(id);

        return emailKontakt;
    }

    public EmailKontakt previous(EmailKontakt emailKontakt) throws MailException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            String sql = "SELECT * FROM Email WHERE ID = < ? GROUP BY ID DESC LIMIT 1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, emailKontakt.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            emailKontakt = creatObject(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MailException("Datensatz nicht vorhanden");
        } finally {
            if (connection != null) {
                close(connection, preparedStatement);
            }
        }
        return emailKontakt;
    }

    public EmailKontakt next(EmailKontakt emailKontakt) throws MailException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            String sql = "SELECT * FROM Email WHERE ID = >? GROUP BY ID LIMIT 1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, emailKontakt.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            emailKontakt = creatObject(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MailException("Datensatz nicht vorhanden");
        } finally {
            if (connection != null) {
                close(connection, preparedStatement);
            }
        }
        return emailKontakt;
    }

    public EmailKontakt first() throws MailException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        EmailKontakt emailKontakt;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            String sql = "SELECT * FROM email WHERE ID = (select min(ID) from Email)";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            emailKontakt = creatObject(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MailException("Dattensatz nicht vorhanden");
        } finally {
            if (connection != null) {
                close(connection, preparedStatement);
            }
        }
        return emailKontakt;
    }

    public EmailKontakt last() throws MailException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        EmailKontakt emailKontakt;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            String sql = "SELECT * FROM email WHERE ID = (select max(ID) from Email)";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            emailKontakt = creatObject(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MailException("Datensatz nicht vorhanden");
        } finally {
            if (connection != null) {
                close(connection, preparedStatement);
            }
        }
        return emailKontakt;

    }

    public void insert(EmailKontakt emailKontakt) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            String sql = "INSERT INTO Email  (Vorname, Nachname, Emailadresse) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, emailKontakt.getVorname());
            preparedStatement.setString(2, emailKontakt.getNachname());
            preparedStatement.setString(3, emailKontakt.getEmailadresse());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                close(connection, preparedStatement);
            }
        }
    }

    public void update(EmailKontakt emailKontakt) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            String sql = "UPDATE Email SET Vorname = ?, Nachname = ?, Emailadresse = ? WHERE ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, emailKontakt.getVorname());
            preparedStatement.setString(2, emailKontakt.getNachname());
            preparedStatement.setString(3, emailKontakt.getEmailadresse());
            preparedStatement.setInt(4, emailKontakt.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                close(connection, preparedStatement);
            }
        }
    }

    public  void delete(int id) throws MailException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        //Verbindung zur Datenbank Herstellen
        try {
            connection = DriverManager.getConnection(CONNECTINGSTRING);

            //Sql-Abfrage
            String SQL = "DELETE FROM EMail WHERE id = ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);

            //SQl-Abfrage
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           throw new MailException("Datensatz nicht vorhanden ");
        } finally {
            if (connection != null) {
                close(connection, preparedStatement);
            }
        }
    }

    public void close (Connection connection, PreparedStatement preparedStatement){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
