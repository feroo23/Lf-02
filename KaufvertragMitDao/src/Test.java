import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import businessObjects.Ware;
import dao.DaoException;
import dao.VertragspartnerDao;
import dao.WareDao;
import service.IO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, DaoException, SQLException {
        abfrage();

    }

    private static void abfrage() throws IOException, InterruptedException, DaoException, ClassNotFoundException, SQLException {
        Thread.sleep(200);
        System.out.println("------------------------------");
        System.out.println("||[A] Vertragspartner        ||");
        System.out.println("||[B] Ware                   ||");
        System.out.println("||[X] Benden                 ||");
        System.out.println("||                           ||");
        System.err.println("||[:(] um Programm zu benden ||");
        Thread.sleep(400);
        System.out.println("------------------------------");
        String x = IO.readString();

        if (x.equalsIgnoreCase("a")){
            vertagspartner();
        }
        else if (x.equalsIgnoreCase("b")){
            ware();
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

    private static void vertagspartner() throws IOException, InterruptedException, ClassNotFoundException, DaoException, SQLException {
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

    private static void vertraspartnerHinzufügen() throws DaoException, ClassNotFoundException, IOException, InterruptedException, SQLException {
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
    private static void vertragspartnerHinzufügenAbfrage() throws IOException, DaoException, InterruptedException, ClassNotFoundException, SQLException {
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

    private static void vertagspartnerAnzeigen() throws IOException, InterruptedException, ClassNotFoundException, DaoException, SQLException {
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
            einenBestimmtenAnzeigenVertragspartner();
        }
        else if (x.equalsIgnoreCase("b")){
            alleAnzeigenVertagspartner();
        }
        else if(x.equalsIgnoreCase("z")){
            vertagspartner();
        }
        else if(x.equalsIgnoreCase("x")){
            benden();
        }
        else{
            System.err.println("Falsche eingabe erneut versuchen");
            vertagspartnerAnzeigen();
        }
    }

    private static void einenBestimmtenAnzeigenVertragspartner() throws IOException, ClassNotFoundException, InterruptedException, DaoException, SQLException {
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
        einenBestimmtenAnzeigenAbfrageVertragspartner();
    }
    private static void einenBestimmtenAnzeigenAbfrageVertragspartner() throws IOException, DaoException, InterruptedException, ClassNotFoundException, SQLException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                einenBestimmtenAnzeigenVertragspartner();
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
                einenBestimmtenAnzeigenAbfrageVertragspartner();
        }
    }
    private static void alleAnzeigenVertagspartner() throws ClassNotFoundException, InterruptedException, DaoException, IOException, SQLException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nAlle Vertragspartner ausgeben");
        ArrayList<Vertragspartner> vertragspartnerArrayList = vertragspartnerDao.read();
        System.out.println(vertragspartnerArrayList);
        alleAnzeigenAbfrageVertragspartner();
    }
    private static void alleAnzeigenAbfrageVertragspartner() throws InterruptedException, ClassNotFoundException, DaoException, IOException, SQLException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                alleAnzeigenVertagspartner();
                break;
            case "b":
                vertagspartnerAnzeigen();
                break;
            case "c":
                abfrage();
                break;
            case "z":
                vertagspartnerAnzeigen();
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                alleAnzeigenAbfrageVertragspartner();
        }
    }

    private static void vertragspartnerLöschen() throws ClassNotFoundException, IOException, DaoException, InterruptedException, SQLException {
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
    private static void vertragspartnerLöschenAbfrage() throws IOException, InterruptedException, DaoException, ClassNotFoundException, SQLException {
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

    private static void vertragspartnerändern() throws IOException, InterruptedException, ClassNotFoundException, DaoException, SQLException {
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
    private static void vertragspartnerändernAbfrage(String ausweisnummer) throws IOException, InterruptedException, DaoException, ClassNotFoundException, SQLException {
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
    private static void vertragspartnerändernAbfrageWollen(String ausweisnummer) throws IOException, InterruptedException, DaoException, ClassNotFoundException, SQLException {
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

    private static void ware() throws IOException, DaoException, InterruptedException, ClassNotFoundException, SQLException {
        System.out.println("-------------------------");
        System.out.println("||*****   Ware    *****||");
        System.out.println("||                     ||");
        System.out.println("||[A] Ware hinzufügen  ||");
        System.out.println("||[B] Ware anzeigen    ||");
        System.out.println("||[C] Ware Löschen     ||");
        System.out.println("||[D] Ware ändern      ||");
        System.out.println("||[Z] Zurück           ||");
        System.out.println("||[X] Benden           ||");
        System.out.println("-------------------------");
        String x = IO.readString();

        switch (x.toLowerCase()) {
            case "a":
                wareHinzufügen();
                break;
            case "b":
                wareAnzeigen();
                break;
            case "c":
                wareLöschen();
                break;
            case "d":

                break;
            case "z":
                abfrage();
                break;
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                ware();
        }
    }

    private static void wareHinzufügen() throws ClassNotFoundException, IOException, InterruptedException, DaoException, SQLException {
        WareDao wareDao = new WareDao();
        System.out.println("\nEine Ware erstellen Daten bitte ausfüllen");
        System.out.print("\n\tBezeichnung: ");
        String bezeichnung = IO.readString();
        System.out.print("\tPreis: ");
        double preis = IO.readDouble();

        System.out.println("\nWollen sie Besonderheiten, Maengel oder Beschreibung Hinzufügen?");
        Ware ware1 = new Ware(bezeichnung,preis);
        if (IO.readBoolean()){
            System.out.println("\nWenn sie etwas leer lassen wollen Enter drücken");
            System.out.print("\tBesonderheiten: ");
            String besonderheiten = IO.readString();
            System.out.print("\tMaengel: ");
            String maengel = IO.readString();
            System.out.print("\tBeschreibung: ");
            String beschreibung = IO.readString();

            ware1.setBeschreibung(beschreibung);
            ware1.getBesonderheitenListe().add(besonderheiten);
            ware1.getMaengelListe().add(maengel);

        }
        wareDao.crate(ware1);
        wareHinzufügenAbfrage();
    }
    private static void wareHinzufügenAbfrage() throws IOException, ClassNotFoundException, DaoException, InterruptedException, SQLException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                wareHinzufügen();
                break;
            case "b":
                ware();
                break;
            case "c":
                abfrage();
                break;
            case "z":
                ware();
                break;
            case "x":
                benden();
                break;
            default:
                wareHinzufügenAbfrage();
        }
    }

    private static void wareAnzeigen() throws IOException, InterruptedException, DaoException, ClassNotFoundException, SQLException {
        System.out.println("-----------------------------------");
        System.out.println("||******       Ware       ******||");
        System.out.println("||                               ||");
        System.out.println("||[A] Einen Bestimmten anzeigen  ||");
        System.out.println("||[B] Alle Anzeigen              ||");
        System.out.println("||[Z] Zurück                     ||");
        System.out.println("||[X] Benden                     ||");
        System.out.println("-----------------------------------");
        String x = IO.readString();

        if (x.equalsIgnoreCase("a")){
            einenBestimmtenAnzeigenWare();
        }
        else if (x.equalsIgnoreCase("b")){
            alleAnzeigenWare();
        }
        else if(x.equalsIgnoreCase("z")){
            ware();
        }
        else if(x.equalsIgnoreCase("x")){
            benden();
        }
        else{
            System.err.println("Falsche eingabe erneut versuchen");
            wareAnzeigen();
        }
    }
    private static void alleAnzeigenWare() throws ClassNotFoundException, SQLException, InterruptedException, DaoException, IOException {
        WareDao wareDao = new WareDao();
        System.out.println("\nAlle Waren ausgeben");
        ArrayList<Ware> wareListe = wareDao.read();
        System.out.println(wareListe);
        alleAnzeigenAbfrageWare();
    }
    private static void alleAnzeigenAbfrageWare() throws IOException, InterruptedException, DaoException, ClassNotFoundException, SQLException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                alleAnzeigenWare();
                break;
            case "b":
                wareAnzeigen();
                break;
            case "c":
                abfrage();
                break;
            case "z":
                wareAnzeigen();
                break;
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                alleAnzeigenAbfrageVertragspartner();
        }
    }
    private static void einenBestimmtenAnzeigenWare() throws SQLException, ClassNotFoundException, IOException, DaoException, InterruptedException {
        WareDao wareDao = new WareDao();
        System.out.println("Bitte geben sie die Warennummer ein ");
        String warennummer = IO.readString();
        Ware ware = wareDao.read(warennummer);

        try {
            ware = wareDao.read(warennummer);
        }catch (DaoException e ){
            System.err.println("Warennummer nicht vorhanden");
        }
        System.out.println(ware);
        einenBestimmtenAnzeigenAbfrageWare();


    }
    private static void einenBestimmtenAnzeigenAbfrageWare() throws IOException, InterruptedException, DaoException, ClassNotFoundException, SQLException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                einenBestimmtenAnzeigenWare();
                break;
            case "b":
                wareAnzeigen();
                break;
            case "c":
                abfrage();
                break;
            case"z":
                ware();
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                einenBestimmtenAnzeigenAbfrageVertragspartner();
        }
    }

    private static void wareLöschen() throws ClassNotFoundException, IOException, InterruptedException, DaoException, SQLException {
        WareDao wareDao = new WareDao();
        System.out.println("\nEinen Vertragspartner Löschen ");
        System.out.println("\n\tGeben sie die Warennummer ein ");
        String nr = IO.readString();

        try{
            Ware ware = wareDao.read(nr);
            wareDao.delete(nr);
        } catch (DaoException e) {
            System.out.println("Warennumer nicht vorhanden!");
            wareLöschen();
        }
        wareLöschenAbfrage();
    }
    private static void wareLöschenAbfrage() throws IOException, ClassNotFoundException, SQLException, InterruptedException, DaoException {
        wollen();
        String wo = IO.readString();
        switch (wo.toLowerCase()) {
            case "a":
                wareLöschen();
                break;
            case "b":
                ware();
                break;
            case "c":
                abfrage();
                break;
            case"z":
                ware();
                break;
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
                wareLöschenAbfrage();
        }
    }

    private static void wareÄndern() throws ClassNotFoundException, IOException, InterruptedException, DaoException, SQLException {
        Ware ware = null;
        WareDao wareDao = new WareDao();

        System.out.println("Welche Ware wollen sie ändern");
        System.out.print("\n\tWarennumer: ");
        String warennumer = IO.readString();

        try {
            ware = wareDao.read(warennumer);
        } catch (DaoException e) {
            System.err.println("Ausweisnummer nicht gefunden erneut versuchen\n");
            wareÄndern();
        }
        wareÄndernAbfrage(warennumer);

    }
    private static void wareÄndernAbfrage(String warennumer) throws IOException, InterruptedException, DaoException, SQLException, ClassNotFoundException {
        WareDao wareDao = new WareDao();
        Ware ware = wareDao.read(warennumer);
        System.out.println("-----------------------------------");
        System.out.println("||***  Was wollen sie ändern  ***||");
        System.out.println("||                               ||");
        System.out.println("||[A] Bezeichnung                ||");
        System.out.println("||[B] Beschreibung               ||");
        System.out.println("||[C] Preis                      ||");
        System.out.println("||[D] Besonderheiten             ||");
        System.out.println("||[E] Maengel                    ||");
        System.out.println("||[Z] Zurück                     ||");
        System.out.println("||[X] Benden                     ||");
        System.out.println("-----------------------------------");
        String x = IO.readString();
        switch (x.toLowerCase()) {
            case "a":
                System.out.println("geben sie ihrer neue Bezeichnung ein");
                String bezeichnung = IO.readString();
                ware.setBezeichnung(bezeichnung);
                wareDao.update(ware);
                ware = wareDao.read(warennumer);
                wareÄndernAbfrageWollen(warennumer);
                break;
            case "b":
                System.out.println("geben sie ihrer neue Beschreibung ein");
                String beschreibung = IO.readString();
                ware.setBeschreibung(beschreibung);
                wareDao.update(ware);
                ware = wareDao.read(warennumer);
                wareÄndernAbfrageWollen(warennumer);
                break;
            case "c":
                System.out.println("geben neuen Preis ein");
                ware.setPreis(500);
                wareDao.update(ware);
                ware = wareDao.read(warennumer);
                wareÄndernAbfrageWollen(warennumer);
                break;
            case"d":
                System.out.println("Geben sie eine neue Besonderheit ein");
                String besonderheit = IO.readString();
                ware.getBesonderheitenListe().add(besonderheit);
                wareDao.update(ware);
                ware = wareDao.read(warennumer);
                wareÄndernAbfrageWollen(warennumer);
                break;
            case"e":
                System.out.println("Geben sie die Maengel ein");
                String maengel = IO.readString();
                ware.getMaengelListe().add(maengel);
                wareDao.update(ware);
                ware = wareDao.read(warennumer);
                wareÄndernAbfrageWollen(warennumer);
                break;
            case"z":
                vertagspartner();
                break;
            case "x":
                benden();
                break;
            default:
                System.err.println("Falsche eingabe erneut versuchen");
             //   vertragspartnerändernAbfrage(ausweisnummer);
        }
    }

    private static void wareÄndernAbfrageWollen(String warennummer) throws IOException, InterruptedException, ClassNotFoundException, SQLException, DaoException {
        wollen();
        String x = IO.readString();
        if(x.equalsIgnoreCase("a")){
            wareÄndernAbfrage(warennummer);
        }
        else if (x.equalsIgnoreCase("b")){
            wareAnzeigen();
        }
        else if (x.equalsIgnoreCase("c")){
            abfrage();
        }
        else if(x.equalsIgnoreCase("z")){
            ware();
        }
        else if (x.equalsIgnoreCase("x")){
            benden();
        }
        else {
            System.err.println("Falsche eingaaaaaaaaabe erneut versuchen ");
            wareÄndernAbfrageWollen(null);
        }
    }
}


