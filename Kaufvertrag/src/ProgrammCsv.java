import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ProgrammCsv {

    public static void main(String[] args) throws FileNotFoundException {
        csv(KaufvertragErstellen());
    }

    public static Kaufvertrag KaufvertragErstellen() {
        //Käufer
        Vertragspartner Käufer = new Vertragspartner("Andrej", "Menschtschikow");
        Adresse Käuferadresse = new Adresse("Ehlersdamm", "88", "28307", "Bremen");
        Käufer.setAdresse(Käuferadresse);
        Käufer.setAusweisNr("789650368657");

        //Verkäufer
        Vertragspartner Verkäufer = new Vertragspartner("Sarangan", "Sittampalam");
        Adresse Verkäuferadresse = new Adresse("Zwischen Dorpen", "41", "28259", "Bremen");
        Verkäufer.setAdresse(Verkäuferadresse);
        Verkäufer.setAusweisNr("987169854265");

        //Ware
        Ware Ott = new Ware("Ott", "0,7", 10);
        Ott.addBesonderheiten("Dierekt aus Holland");
        Ott.addMaengel("Starke Nebenwirkungen");

        //Vertrag
        Kaufvertrag kaufvertrag = new Kaufvertrag(Verkäufer, Käufer, Ott);

        return kaufvertrag;
    }

    public static void csv(Kaufvertrag kaufvertrag) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("Test.csv");
        pw.print("Vertragsparntner;");
        pw.print("Name;");
        pw.print("Straße;");
        pw.print("PLZ;");
        pw.print("Ort;");
        pw.println("AusweissNr");

        pw.print("Verkaeufer;");
        pw.print(kaufvertrag.getVerkäufer().getNachname() + "," + kaufvertrag.getVerkäufer().getVorname() + ";");
        pw.print(kaufvertrag.getVerkäufer().getAdresse().getStrasse() + "," + kaufvertrag.getVerkäufer().getAdresse().getHausNr() + ";");
        pw.print(kaufvertrag.getVerkäufer().getAdresse().getPlz() + ";");
        pw.print(kaufvertrag.getVerkäufer().getAdresse().getOrt() + ";");
        pw.println(kaufvertrag.getVerkäufer().getAusweisNr());

        pw.print("Kaeufer;");
        pw.print(kaufvertrag.getKäufer().getNachname() + "," + kaufvertrag.getKäufer().getVorname() + ";");
        pw.print(kaufvertrag.getKäufer().getAdresse().getStrasse() + "," + kaufvertrag.getKäufer().getAdresse().getHausNr() + ";");
        pw.print(kaufvertrag.getKäufer().getAdresse().getPlz() + ";");
        pw.print(kaufvertrag.getKäufer().getAdresse().getOrt() + ";");
        pw.println(kaufvertrag.getKäufer().getAusweisNr());

        pw.close();
    }

}