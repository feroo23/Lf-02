import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import dao.DaoException;
import dao.VertragspartnerDao;
import service.IO;

import java.io.IOException;
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

    private static void wollen() throws IOException {
        System.out.println("-----------------------------------");
        System.out.println("||****   Was wollen sie tun   ****||");
        System.out.println("||                                ||");
        System.out.println("||[A] Weitere Daten erfassen      ||");
        System.out.println("||[B] Zurück zur auswahl          ||");
        System.out.println("||[C] Waren/Vertragsparter auswahl||");
        System.out.println("||[X] Benden                      ||");
        System.out.println("-----------------------------------");
        String eingabe = IO.readString();
        switch (eingabe.toLowerCase()){

        }



       return;
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

    private static void vertraspartnerHinzufügen() throws DaoException, ClassNotFoundException, IOException, InterruptedException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        Adresse adresse = null;
        System.out.println("\nBitte Geben sie die Daten Für ein Vertragspartner ein.");
        System.out.print("\tAusweisnummer: ");
        String ausnr = IO.readString();
        System.out.print("\tvorname: ");
        String name = IO.readString();
        System.out.print("\tNachname: ");
        String nachname = IO.readString();
        System.out.println("Wollen sie eine Adresse eingeben");

        String str = " ";
        String hnr = " ";
        String plz = " ";
        String ort = " ";
        adresse = new Adresse(str,hnr,plz,ort);

        boolean jein = IO.readBoolean();
        if (jein = false){
            System.out.println("\nAdresse");
            System.out.print("\tStraße: ");
            str = IO.readString();
            System.out.print("\tHausNr: ");
            hnr = IO.readString();
            System.out.print("\tPlz: ");
            plz = IO.readString();
            System.out.print("\tBremen:");
            ort = IO.readString();


            adresse = new Adresse(str,hnr,plz,ort);
        }
        Vertragspartner vertragspartner = new Vertragspartner(name, nachname);
        vertragspartner.setAusweisNr(ausnr);
        vertragspartner.setAdresse(adresse);
        vertragspartnerDao.create(vertragspartner);
        loading();
        System.out.println("Vertragspartner wurder erstellet");
    }

    private static void vertagspartnerAnzeigen() throws IOException, InterruptedException, ClassNotFoundException {
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

    private static void einenBestimmtenAnzeigen() throws IOException, ClassNotFoundException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("Bitte geben sie die ausweisnummer ");
        String lesen = IO.readString();
        Vertragspartner vertragspartner = null;
        try {
            vertragspartner = vertragspartnerDao.read(lesen);
        }catch (DaoException e ){
            System.out.println(e.getMessage());
        }
        System.out.println(vertragspartner);



    }

    private static void alleAnzeigen() throws ClassNotFoundException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nAlle Vertragspartner ausgeben");
        ArrayList<Vertragspartner> vertragspartnerArrayList = vertragspartnerDao.read();
        System.out.println(vertragspartnerArrayList);

    }
}
