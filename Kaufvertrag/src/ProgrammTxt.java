import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ProgrammTxt {

    public static void main(String[] args) throws FileNotFoundException {
        kaufVertragtext(KaufvertragErstellen());
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

    public static void kaufVertragtext(Kaufvertrag kaufvertrag) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("test.txt");
        String stringAddtest = "test";
        kaufvertrag.getWare().addBesonderheiten(stringAddtest);
        kaufvertrag.getWare().addMaengel(stringAddtest);
        pw.println("----------Adresse----------");
        pw.println(kaufvertrag.getKäufer().getAdresse());
        pw.print("\n----------Vetragspartner----------");
        pw.println("\n" + kaufvertrag.getKäufer());
        pw.println("\n----------Ware----------");
        pw.println(kaufvertrag.getWare());
        pw.println("\n----------Kaufvertrag----------");
        pw.println(kaufvertrag);
        pw.println("\n----------BesonderheitenNichtGefundenException----------");
        try {
            kaufvertrag.getWare().removeBesonderheiten("Test");
        } catch (BesonderheitenNichtGefundenException e) {
            pw.println(e);
        }
        pw.println("\n----------MangelNichtGefundenException----------");
        try {
            kaufvertrag.getWare().removeMaengel("Test");
        } catch (MaengelNichtGefundenException e) {
            pw.println(e);
        }

        pw.close();
    }
}