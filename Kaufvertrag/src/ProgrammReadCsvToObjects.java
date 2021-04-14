import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProgrammReadCsvToObjects {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Test.csv"));

        ArrayList<String> zellen = new ArrayList<>();
        String zelle;
        while ((zelle = br.readLine()) != null) {
            zellen.add(zelle);
        }
        for (String z : zellen) {
            String[] daten= z.split(";");
            if (daten[0].equalsIgnoreCase("Kaeufer")) {
                amk(daten);
            } else if (daten[0].equalsIgnoreCase("Verkaeufer")){
             amk(daten);
            }
        }
    }public static void amk(String[] daten){
        String[] test= daten[1].split(",");
        String nach = test[0];
        String name = test[1];
        String[] adr = daten[2].split(",");
        String str = adr[0];
        String hausnr = adr[1];
        String pzl = daten[3];
        String ort = daten[4];
        String ausweis = daten[5];

        Vertragspartner vertragspartner = new Vertragspartner(name,nach);
        Adresse adressever = new Adresse(str,hausnr,pzl,ort);
        vertragspartner.setAusweisNr(ausweis);

        vertragspartner.setAdresse(adressever);
        System.out.println(vertragspartner + "\n");
    }
}

