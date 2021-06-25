import businessObjects.Vertragspartner;
import dao.DaoException;
import dao.VertragspartnerDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, DaoException, SQLException, IOException {
        abfrage();

    }
    public static String eingabe() throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }





    private static void abfrage() throws IOException {
        System.out.println("-----------------------");
        System.out.println("||[A] Vertragspartner||");
        System.out.println("||[B] Ware           ||");
        System.out.println("||[X] Benden         ||");
        System.out.println("-----------------------");
        String x = eingabe();

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

    private static void vertagspartner() throws IOException {
        System.out.println("-----------------------------------");
        System.out.println("||*****   Vertragspartner   *****||");
        System.out.println("||                               ||");
        System.out.println("||[A] Vertagspartner anzeigen    ||");
        System.out.println("||[B] Vertagspartner Löschen     ||");
        System.out.println("||[C] Vertagspartner ändern      ||");
        System.out.println("||[D] Vertraspartner hinzufügen  ||");
        System.out.println("||[X] Benden                     ||");
        System.out.println("-----------------------------------");
        String x = eingabe();

        if (x.equalsIgnoreCase("a")){
            vertagspartnerAnzeigen();
        }
        else if (x.equalsIgnoreCase("b")){

        }
        else if(x.equalsIgnoreCase("C")){

        }
        else if (x.equalsIgnoreCase("d")){

        }
        else if(x.equalsIgnoreCase("x")){
            System.out.println(":(");
        }
        else{
            System.err.println("Falsche eingabe erneut versuchen");
            vertagspartner();
        }
    }

    private static void vertagspartnerAnzeigen() throws IOException {
        System.out.println("-----------------------------------");
        System.out.println("||*****   Vertragspartner   *****||");
        System.out.println("||                               ||");
        System.out.println("||[A] Einen Bestimmten anzeigen  ||");
        System.out.println("||[B] Alle Anzeigen              ||");
        System.out.println("||[X] Benden                     ||");
        System.out.println("-----------------------------------");
        String x = eingabe();

        if (x.equalsIgnoreCase("a")){

        }
        else if (x.equalsIgnoreCase("b")){

        }
        else if(x.equalsIgnoreCase("x")){
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
}
