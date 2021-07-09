import bo.EmailKontakt;
import dao.DaoException;
import emailDao.EmailKontaktDao;
import emailDao.MailException;
import service.IO;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class MailProgramm {

    public static void main(String[] args) throws IOException, MailException, SQLException {

    }

    public MailProgramm() throws IOException {

    }



    private static void main() throws IOException, MailException, SQLException {
        System.out.println("Was wollen sie machen?");
        String x = IO.readString();

        if (x.equalsIgnoreCase("select")){
            select();
        }
        else if(x.equalsIgnoreCase("update")){
            update();
        }
        else if (x.equalsIgnoreCase("delete")){
            delete();
        }
        else if (x.equalsIgnoreCase("insert")){
            insert();
        }
        else if (x.equalsIgnoreCase("last")){
            last();
        }
        else if (x.equalsIgnoreCase("first")){
            first();
        }
        else {
            System.out.println("erneut versuchen");
            main();
        }

    }

    private static void previous(EmailKontakt emailKontakt) throws MailException {
        EmailKontaktDao emailKontaktDao = new EmailKontaktDao();
        emailKontaktDao.previous(emailKontakt);
    }

    private static void next(EmailKontakt emailKontakt) throws MailException {
        EmailKontaktDao emailKontaktDao = new EmailKontaktDao();
        emailKontaktDao.next(emailKontakt);
    }

    private static void first() throws MailException {
        EmailKontaktDao emailKontaktDao = new EmailKontaktDao();
        EmailKontakt emailKontakt;

        emailKontakt = emailKontaktDao.first();
        System.out.println(emailKontakt);
    }

    private static void last() throws MailException {
        EmailKontaktDao emailKontaktDao = new EmailKontaktDao();
        EmailKontakt emailKontakt;

        emailKontakt = emailKontaktDao.last();
        System.out.println(emailKontakt);
    }

    private static void insert() throws IOException, MailException, SQLException {
        EmailKontaktDao emailKontaktDao = new EmailKontaktDao();
        EmailKontakt emailKontakt;

        System.out.println("füllen sie Daten die aus");
        System.out.print("\n\tVorname: ");
        String vorname = IO.readString();
        System.out.print("\tNachname: ");
        String nachname = IO.readString();
        System.out.print("\tEmailadresse: ");
        String email = IO.readString();

        emailKontakt = new EmailKontakt(vorname, nachname, email);

        emailKontaktDao.insert(emailKontakt);
        emailKontakt = emailKontaktDao.last();

        System.out.println(emailKontakt);
        main();
    }

    private static void delete() throws SQLException, IOException, MailException {
        System.out.println("Geben sie Die Id ein um zu Löschen ");
        int x = IO.readInteger();
        EmailKontaktDao emailKontaktDao = new EmailKontaktDao();
        try {
            emailKontaktDao.delete(x);
            System.out.println("Kontakt mit der ID " + x + "wurde gelöscht");
        }catch (MailException e){
            e.getMessage();
        }
        main();
    }

    private static void update() throws IOException {
        System.out.println("Geben sie Die Id ein um zu änderen ");
        int x = IO.readInteger();
        EmailKontaktDao emailKontaktDao = new EmailKontaktDao();
        EmailKontakt emailKontakt = null;

        try {
            emailKontakt = emailKontaktDao.select(x);
        }catch (MailException e){
            e.getMessage();
        }

        System.out.println("Was wollen sie ändern ");
        System.out.println("Vorname, Nachname oder Emailadresse");
        String frag = IO.readString();


        if (frag.equalsIgnoreCase("Vorname")){
            System.out.print("vorname: ");
            String vorname = IO.readString();
            emailKontakt.setVorname(vorname);
            emailKontaktDao.update(emailKontakt);
            System.out.println(emailKontakt);
        }
        else if (frag.equalsIgnoreCase("Nachname")){
            System.out.print("Nachname: ");
            String nachname = IO.readString();
            emailKontakt.setNachname(nachname);
            emailKontaktDao.update(emailKontakt);
        }
        else if (frag.equalsIgnoreCase("Emailadresse")){
            System.out.print("Emailadresse: ");
            String emailadresse = IO.readString();
            emailKontakt.setEmailadresse(emailadresse);
            emailKontaktDao.update(emailKontakt);
        }
        else {
            System.out.println("Faslche eingabe");

        }
    }

    private static void select() throws IOException, MailException, SQLException {
        System.out.println("Geben sie ihre ID ein");
        int x = IO.readInteger();
        EmailKontaktDao emailKontaktDao = new EmailKontaktDao();
        EmailKontakt emailKontakt = null;

        try {
            emailKontakt = emailKontaktDao.select(x);
        }catch (MailException e){
            e.getMessage();
        }
        if (emailKontakt != null) {
            System.out.println(emailKontakt);
        }
        System.out.println("[+] für next [-] für previous");
        String y = IO.readString();

        if (y.equalsIgnoreCase("+")){
            next(emailKontakt);
        }
        else if (y.equalsIgnoreCase("-")){
            previous(emailKontakt);
        }
        else {
            System.out.println("Erneut versuchen");

        }
    }
}
