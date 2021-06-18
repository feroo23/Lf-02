import businessObjects.Adresse;
import businessObjects.Vertragspartner;
import businessObjects.Ware;
import com.sun.jdi.connect.spi.Connection;
import dao.VertragspartnerDao;
import dao.WareDao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class JavaKlasseProgramm {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nEinen Vertragspartner lesen");
        Vertragspartner vertragspartner = vertragspartnerDao.read("123654918b");
        System.out.println(vertragspartner);

/*
        //Alle Vertragspartner Ausgeben
        //   VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nAlle Vertragspartner ausgeben");
        ArrayList<Vertragspartner> vertragspartnerArrayList = vertragspartnerDao.read();
        System.out.println(vertragspartnerArrayList);


*/

        //Ware Ausgeben (Einen)
        WareDao wareDao = new WareDao();
        Ware ware = wareDao.read("1");
        System.out.println(ware);


 /*
        //Alle Waren Ausgeben
      //  WareDao wareDao = new WareDao();
        System.out.println("\nAlle Waren ausgeben");
        ArrayList<Ware> wareListe = wareDao.read();
        System.out.println(wareListe);

        //Vertragspartner Löschen
        System.out.println("\nEinen Vertragspartner Löschen ");
        vertragspartnerDao.delete("1685bs461bs");


        //Vertrags Ware Löschen
        System.out.println("\nEinen Vertragspartner Löschen ");
        wareDao.delete("4");

  */

        //Vertragspartner ändern
        System.out.println("\nEinene vertragspartner ändern");
        vertragspartner = vertragspartnerDao.read("123654918b");
        vertragspartner.setVorname("Ferhat");
        vertragspartner.setNachname("Gümüs");
        Adresse Hb = new Adresse("Kirchhuchtinger Landstraße ", "165A", "28259","Bremen");
        vertragspartner.setAdresse(Hb);
        vertragspartnerDao.update(vertragspartner);

        //Ware ändern
        System.out.println("\nEinene Ware ändern");
        ware = wareDao.read("2");
        ware.setBezeichnung("Hayat");
        ware.setBeschreibung("KA");
        ware.setPreis(500);
        ware.getMaengelListe().add("Tolle neue Maske");
        ware.getBesonderheitenListe().add("sdfz");
        wareDao.update(ware);
        /*
        //Vertragspartner Erstellen
        System.out.println("\nVertragspartner erstellen");
        vertragspartner = vertragspartnerDao.read("123654918b");
        vertragspartner.setAusweisNr("756984123D");
        vertragspartner.setVorname("Anderj");
        vertragspartner.setNachname("Menschtschikow");
        Adresse adresseerstellen = new Adresse("Elaster","8","28307","Bremen");
        vertragspartner.setAdresse(adresseerstellen);
        vertragspartnerDao.crate(vertragspartner);

         */
    }
}
