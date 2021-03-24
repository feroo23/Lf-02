public class Programm {

    public static void main(String[] args) {
        Adresse adresseKunde = new Adresse("Amsterdammer str", "16", "28259", "Bremen");
        Adresse adresseMit = new Adresse("Kirchhuchtinger Land str", "165A", "28259", "Bremen");
        Mitarbeiter mitarbeiter = new Mitarbeiter("Frag","Nicht",adresseMit);
        Kunde kunde = new Kunde("Fero", "23", adresseKunde,mitarbeiter);
        Girokonto gr = new Girokonto(kunde,500,0 ,100,50);


System.out.println(kunde);
        //System.out.println(adresseKunde);
         System.out.println(gr.toString());
        System.out.println(" ");

        System.out.println(mitarbeiter);
      //  System.out.println(adresseMit);



    }
}
