public class Programm {

    public static void main(String[] args) {
        Adresse adresseKunde = new Adresse("Amsterdammer str", "16", "28259", "Bremen");
        Adresse adresseMit = new Adresse("Kirchhuchtinger Land str", "165A", "28259", "Bremen");
        Mitarbeiter mitarbeiter = new Mitarbeiter("Frag","Nicht",adresseMit);
        Kunde kunde = new Kunde("Fero", "23", adresseKunde,mitarbeiter);

        System.out.println(Mitarbeiter.to);
        Mitarbeiter.to
    }
}
