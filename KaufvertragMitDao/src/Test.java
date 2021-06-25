import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import dao.DaoException;
import dao.VertragspartnerDao;
import service.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, DaoException {
        abfrage();
    }


    private static void abfrage() throws IOException, InterruptedException, DaoException, ClassNotFoundException {
        System.out.println("-----------------------");
        System.out.println("||[A] Vertragspartner||");
        System.out.println("||[B] Ware           ||");
        System.out.println("||[X] Benden         ||");
        System.out.println("-----------------------");
        String x = IO.readString();

        if (x.equalsIgnoreCase("a")){
            vertagspartner();
        }
        else if (x.equalsIgnoreCase("b")){

        }
        else if(x.equalsIgnoreCase("x")){
            System.out.println(":(");
        }
        else{
            System.err.println("Falsche eingabe erneut versuchen");
            abfrage();
        }
    }
    private static void loading() throws InterruptedException {
        System.out.print("loading");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1200);
        System.out.print(".");
        Thread.sleep(1500);;
        System.out.println(".");
        Thread.sleep(500);
    }

    private static void stop(){
        System.out.println("                                                        ");
        System.out.println("                                                        ");
        System.out.println("                                                        ");
    }

    private static void vertagspartner() throws IOException, InterruptedException, ClassNotFoundException, DaoException {
        System.out.println("-----------------------------------");
        System.out.println("||*****   Vertragspartner   *****||");
        System.out.println("||                               ||");
        System.out.println("||[A] Vertraspartner hinzufügen  ||");
        System.out.println("||[B] Vertagspartner anzeigen    ||");
        System.out.println("||[C] Vertagspartner Löschen     ||");
        System.out.println("||[D] Vertagspartner ändern      ||");
        System.out.println("||[X] Benden                     ||");
        System.out.println("-----------------------------------");
        String x = IO.readString();

        switch (x.toLowerCase()) {
            case "a":
                vertraspartnerHinzufügen();
                break;
            case "b":
                vertagspartnerAnzeigen();
                break;
            case "c":

                break;
            case "d":

                break;
            case "x":
                loading();
                System.out.println(":(");
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                vertagspartner();
        }
    }

    private static void vertraspartnerHinzufügen() throws DaoException, ClassNotFoundException, IOException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nBitte Geben sie die Daten Für ein Vertragspartner ein.");
        System.out.print("\tvorname: ");
        String name = IO.readString();
        System.out.print("\tNachname: ");
        String nachname = IO.readString();
        System.out.println("Wollen sie eine Adresse eingeben");

        boolean jein = IO.readBoolean();
        if (jein = true){
            System.out.println("\nAdresse");
            System.out.print("\tStraße: ");
            String str = IO.readString();
            System.out.print("\tHausNr: ");
            String hnr = IO.readString();
            System.out.print("\tPlz: ");
            String plz = IO.readString();
            System.out.print("\tBremen:");
            String ort = IO.readString();

            Adresse adresse = new Adresse(str,hnr,plz,ort);
        }else {
            Vertragspartner vertragspartner = new Vertragspartner(name, nachname);
        }








    }

    private static void vertagspartnerAnzeigen() throws IOException, InterruptedException {
        System.out.println("-----------------------------------");
        System.out.println("||*****   Vertragspartner   *****||");
        System.out.println("||                               ||");
        System.out.println("||[A] Einen Bestimmten anzeigen  ||");
        System.out.println("||[B] Alle Anzeigen              ||");
        System.out.println("||[X] Benden                     ||");
        System.out.println("-----------------------------------");
        String x = IO.readString();

        if (x.equalsIgnoreCase("a")){
            einenBestimmtenAnzeigen();
        }
        else if (x.equalsIgnoreCase("b")){

        }
        else if(x.equalsIgnoreCase("x")){
            loading();
            System.out.println(":(");
        }
        else{
            System.err.println("Falsche eingabe erneut versuchen");
            vertagspartnerAnzeigen();
        }
    }

    private static void einenBestimmtenAnzeigen(){
        System.out.println("Bitte geben sie die ausweisnummer ");

    }

    private static void alleAnzeigen() throws ClassNotFoundException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nAlle Vertragspartner ausgeben");
        ArrayList<Vertragspartner> vertragspartnerArrayList = vertragspartnerDao.read();
        System.out.println(vertragspartnerArrayList);

    }
}
