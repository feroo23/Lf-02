public class Programm {

    public static void main(String[] args) {

        //Käufer
        Vertragspartner Käufer = new Vertragspartner("Andrej", "Menschtschikow");
        Adresse Käuferadresse = new Adresse("Ehlersdamm","88","28307","Bremen");
        Käufer.setAdresse(Käuferadresse);
        Käufer.setAusweisNr("789650368657");

        //Verkäufer
        Vertragspartner Verkäufer = new Vertragspartner("Sarangan", "Sittampalam");
        Adresse Verkäuferadresse = new Adresse("Zwischen Dorpen", "41","28259", "Bremen");
        Verkäufer.setAdresse(Verkäuferadresse);
        Verkäufer.setAusweisNr("987169854265");

        //Ware
        Ware Ott = new Ware("Ott", "0,7",10);
        Ott.addBesonderheiten("Dierekt aus Holland");
        Ott.addMaengel("Starke Nebenwirkungen");

        //Vertrag
        Kaufvertrag kaufvertrag = new Kaufvertrag(Verkäufer,Käufer,Ott);


        System.out.print("----------Adresse----------");
        System.out.println("\nVerkäufer");
        System.out.println("\n" + Käuferadresse);
        System.out.print("\n----------Vetragspartner----------");
        System.out.println("\n" + Käufer);
        System.out.println("\n----------Ware----------");
        System.out.println(Ott);
        System.out.println("\n----------Kaufvertrag----------");
        System.out.println(kaufvertrag);
        System.out.println("\n----------BesonderheitenNichtGefundenException----------");
        try {
            Ott.removeBesonderheiten("Besonderheiten Fehler");
        } catch (BesonderheitenNichtGefundenException e) {
            System.out.println(e.toString());
        }
        System.out.println("\n----------MangelNichtGefundenException----------");
        try {
            Ott.removeMaengel("Mängel Fehler");
        } catch (MaengelNichtGefundenException e) {
            System.out.println(e.toString());
        }
    }
}
