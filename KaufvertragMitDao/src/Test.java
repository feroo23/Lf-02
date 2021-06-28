import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import businessObjects.Ware;
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

    private static void benden() throws InterruptedException {
        loading();
        System.out.println("\t:(");
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
        System.out.println("--------------------------------------");
        System.out.println("||*****   Was wollen sie tun   *****||");
        System.out.println("||                                  ||");
        System.out.println("||[A] Weitere Daten erfassen        ||");
        System.out.println("||[B] Zurück zur auswahl            ||");
        System.out.println("||[C] Waren/Vertragspartner auswahl ||");
        System.out.println("||[Z] Zurück                        ||");
        System.out.println("||[X] Benden                        ||");
        System.out.println("--------------------------------------");
    }

    private static void vertagspartner() throws IOException, InterruptedException, ClassNotFoundException, DaoException {
        System.out.println("-----------------------------------");
        System.out.println("||*****   Vertragspartner   *****||");
        System.out.println("||                               ||");
        System.out.println("||[A] Vertraspartner hinzufügen  ||");
        System.out.println("||[B] Vertagspartner anzeigen    ||");
        System.out.println("||[C] Vertagspartner Löschen     ||");
        System.out.println("||[D] Vertagspartner ändern      ||");
        System.out.println("||[Z] Zurück                     ||");
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
                vertragspartnerLöschen();
                break;
            case "d":
                vertragspartnerändern();
                break;
            case "z":
                abfrage();
                break;
            case "x":
                benden();
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
        adresse = new Adresse(str, hnr, plz, ort);

        if (IO.readBoolean()) {
            System.out.println("\nAdresse");
            System.out.print("\tStraße: ");
            str = IO.readString();
            System.out.print("\tHausNr: ");
            hnr = IO.readString();
            System.out.print("\tPlz: ");
            plz = IO.readString();
            System.out.print("\tOrt:");
            ort = IO.readString();


            adresse = new Adresse(str, hnr, plz, ort);
        }
        Vertragspartner vertragspartner = new Vertragspartner(name, nachname);
        vertragspartner.setAusweisNr(ausnr);
        vertragspartner.setAdresse(adresse);
        vertragspartnerDao.create(vertragspartner);
        loading();
        System.out.println("Vertragspartner wurder erstellet");
        vertragspartnerHinzufügenAbfrage();
    }
    private static void vertragspartnerHinzufügenAbfrage() throws IOException, DaoException, InterruptedException, ClassNotFoundException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                vertraspartnerHinzufügen();
                break;
            case "b":
                vertagspartner();
                break;
            case "c":
                abfrage();
                break;
            case "z":
                vertagspartner();
                break;
            case "x":
                benden();
                break;
            default:
                vertragspartnerHinzufügenAbfrage();
        }
    }

    private static void vertagspartnerAnzeigen() throws IOException, InterruptedException, ClassNotFoundException, DaoException {
        System.out.println("-----------------------------------");
        System.out.println("||*****   Vertragspartner   *****||");
        System.out.println("||                               ||");
        System.out.println("||[A] Einen Bestimmten anzeigen  ||");
        System.out.println("||[B] Alle Anzeigen              ||");
        System.out.println("||[Z] Zurück                     ||");
        System.out.println("||[X] Benden                     ||");
        System.out.println("-----------------------------------");
        String x = IO.readString();

        if (x.equalsIgnoreCase("a")){
            einenBestimmtenAnzeigen();
        }
        else if (x.equalsIgnoreCase("b")){
            alleAnzeigen();
        }
        else if(x.equalsIgnoreCase("z")){
            vertagspartner();
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

    private static void einenBestimmtenAnzeigen() throws IOException, ClassNotFoundException, InterruptedException, DaoException {
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
        einenBestimmtenAnzeigenAbfrage();
    }
    private static void einenBestimmtenAnzeigenAbfrage() throws IOException, DaoException, InterruptedException, ClassNotFoundException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                einenBestimmtenAnzeigen();
                break;
            case "b":
                vertagspartnerAnzeigen();
                break;
            case "c":
                abfrage();
                break;
            case"z":
                vertagspartner();
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                einenBestimmtenAnzeigenAbfrage();
        }
    }
    private static void alleAnzeigen() throws ClassNotFoundException, InterruptedException, DaoException, IOException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nAlle Vertragspartner ausgeben");
        ArrayList<Vertragspartner> vertragspartnerArrayList = vertragspartnerDao.read();
        System.out.println(vertragspartnerArrayList);
        alleAnzeigenAbfrage();
    }
    private static void alleAnzeigenAbfrage() throws InterruptedException, ClassNotFoundException, DaoException, IOException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                alleAnzeigen();
                break;
            case "b":
                vertagspartnerAnzeigen();
                break;
            case "c":
                abfrage();
                break;
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                alleAnzeigenAbfrage();
        }
    }

    private static void vertragspartnerLöschen() throws ClassNotFoundException, IOException, DaoException, InterruptedException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nGeben sie die ausweisnummer vom vertragspartner ein um ihn zu löschen");
        String löschen = IO.readString();
        try{
            Vertragspartner vertragspartner = vertragspartnerDao.read(löschen);
            vertragspartnerDao.delete(löschen);
        }catch (DaoException e ){
            System.err.println("Vertragspartner nicht vorhanden erneut versuchen");
            vertragspartnerLöschen();
        }
        System.out.println("Vertragspartner gelöscht");
        vertragspartnerLöschenAbfrage();
    }
    private static void vertragspartnerLöschenAbfrage() throws IOException, InterruptedException, DaoException, ClassNotFoundException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                vertragspartnerLöschen();
                break;
            case "b":
                vertagspartner();
                break;
            case "c":
                abfrage();
                break;
            case"z":
                vertagspartner();
                break;
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                vertragspartnerLöschenAbfrage();
        }
    }

    private static void vertragspartnerändern() throws IOException, InterruptedException, ClassNotFoundException, DaoException {
        Vertragspartner vertragspartner = null;
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();

        System.out.println("Welchen vertragspartner wollen sie ändern");
        System.out.print("\n\tAusweisnummer: ");
        String ausweisnummer = IO.readString();

        try {
            vertragspartner = vertragspartnerDao.read(ausweisnummer);
        } catch (DaoException e) {
            System.err.println("Ausweisnummer nicht gefunden erneut versuchen\n");
            vertragspartnerändern();
        }
        vertragspartnerändernAbfrage(ausweisnummer);
    }
    private static void vertragspartnerändernAbfrage(String ausweisnummer) throws IOException, InterruptedException, DaoException, ClassNotFoundException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("-----------------------------------");
        System.out.println("||***  Was wollen sie ändern  ***||");
        System.out.println("||                               ||");
        System.out.println("||[A] Vorname/Nachname           ||");
        System.out.println("||[B] Adresse                    ||");
        System.out.println("||[C] Allllleesss                ||");
        System.out.println("||[Z] Zurück                     ||");
        System.out.println("||[X] Benden                     ||");
        System.out.println("-----------------------------------");
        String x = IO.readString();
        switch (x.toLowerCase()) {
            case "a":
                System.out.println("Geben sie die Daten ein ");
                System.out.print("\tVorname: ");
                String vorname = IO.readString();
                System.out.print("\tNachname: ");
                String nachname = IO.readString();
                Vertragspartner vertragspartner = vertragspartnerDao.read(ausweisnummer);
                vertragspartner.setVorname(vorname);
                vertragspartner.setNachname(nachname);
                vertragspartnerDao.update(vertragspartner);
                vertragspartnerändernAbfrageWollen(ausweisnummer);
                break;
            case "b":
                System.out.println("Geben sie die Daten ein ");
                System.out.print("\tStraße: ");
                String str = IO.readString();
                System.out.print("\tHausNr: ");
                String hNr = IO.readString();
                System.out.print("\tplz: ");
                String plz = IO.readString();
                System.out.print("\tOrt: ");
                String ort = IO.readString();
                Vertragspartner vertragspartner9 = vertragspartnerDao.read(ausweisnummer);
                Adresse adresseee = new Adresse(str, hNr, plz, ort);
                vertragspartner9.setAdresse(adresseee);
                vertragspartnerDao.update(vertragspartner9);
                vertragspartnerändernAbfrageWollen(ausweisnummer);
                break;
            case "c":
                System.out.println("Geben sie die Daten ein ");
                System.out.print("\n\tVorname: ");
                String vorname1 = IO.readString();
                System.out.print("\n\tNachname: ");
                String nachname1 = IO.readString();
                Vertragspartner vertragspartner1 = vertragspartnerDao.read(ausweisnummer);
                vertragspartner1.setVorname(vorname1);
                vertragspartner1.setNachname(nachname1);
                vertragspartnerDao.update(vertragspartner1);

                System.out.println("Geben sie die Daten ein ");
                System.out.print("\n\tStraße: ");
                String str1 = IO.readString();
                System.out.print("\n\tHausNr: ");
                String hNr1 = IO.readString();
                System.out.print("\n\tplz: ");
                String plz1 = IO.readString();
                System.out.print("\n\tOrt: ");
                String ort1 = IO.readString();
                Vertragspartner vertragspartner91 = vertragspartnerDao.read(ausweisnummer);
                Adresse adressee = new Adresse(str1, hNr1, plz1, ort1);
                vertragspartner91.setAdresse(adressee);
                vertragspartnerDao.update(vertragspartner91);
                vertragspartnerändernAbfrageWollen(ausweisnummer);
                break;
            case"z":
                vertagspartner();
                break;
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                vertragspartnerändernAbfrage(ausweisnummer);
        }
    }
    private static void vertragspartnerändernAbfrageWollen(String ausweisnummer) throws IOException, InterruptedException, DaoException, ClassNotFoundException {
        wollen();
        String x = IO.readString();
        if(x.equalsIgnoreCase("a")){
            vertragspartnerändernAbfrage(ausweisnummer);
        }
        else if (x.equalsIgnoreCase("b")){
            vertagspartnerAnzeigen();
        }
        else if (x.equalsIgnoreCase("c")){
            abfrage();
        }
        else if(x.equalsIgnoreCase("z")){
            vertagspartner();
        }
        else if (x.equalsIgnoreCase("x")){
            benden();
        }
        else {
            System.err.println("Falsche eingaaaaaaaaabe erneut versuchen ");
            vertragspartnerändernAbfrageWollen(ausweisnummer);
        }
    }

    private static void ware() throws IOException, DaoException, InterruptedException, ClassNotFoundException {
        System.out.println("-------------------------");
        System.out.println("||*****   Ware    *****||");
        System.out.println("||                     ||");
        System.out.println("||[A] Ware hinzufügen  ||");
        System.out.println("||[B] Ware anzeigen    ||");
        System.out.println("||[C] Ware Löschen     ||");
        System.out.println("||[D] Ware ändern      ||");
        System.out.println("||[X] Benden           ||");
        System.out.println("-------------------------");
        String x = IO.readString();

        switch (x.toLowerCase()) {
            case "a":

                break;
            case "b":

                break;
            case "c":
                ;
                break;
            case "d":

                break;
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                vertagspartner();
        }
    }

    private static void wareHinzufügen(){
    /*    Ware ware = new Ware();
        System.out.println("\nEine Ware erstellen");
        Ware ware1 = new Ware("Etwas",10);
        // ware1.setWarenNr("1");
        ware1.setBeschreibung("Grün");
        ware1.getBesonderheitenListe().add("Sieht schön aus");
        ware1.getMaengelListe().add(null);
        wareDao.crate(ware1);

     */
    }
}

