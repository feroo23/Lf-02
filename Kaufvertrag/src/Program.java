import businessObjects.Adresse;
import businessObjects.Kaufvertrag;
import businessObjects.Vertragspartner;
import businessObjects.Ware;

public class Program {

	public static void main(String[] args) {
		// businessobjects.Ware anlegen.
		Ware ware = new Ware("Laptop", 250.0);
		ware.setBeschreibung("Super krasses Gaming-Laptop");
		ware.getBesonderheitenListe().add("Tasche");
		ware.getBesonderheitenListe().add("Gaming-Maus");
		ware.getMaengelListe().add("Ladekabel fehlt");
		ware.getMaengelListe().add("Touchpad defekt");
		// Käufer anlegen.
		Vertragspartner kaeufer = new Vertragspartner("Klaus", "Brandt");
		kaeufer.setAusweisNr("0123456789");
		kaeufer.setAdresse(new Adresse("Zu Hause", "3a", "28199", "Bremen"));
		// Verkäufer anlegen.
		Vertragspartner verkaeufer = new Vertragspartner("Joachim", "Bredull");
		verkaeufer.setAusweisNr("9876543210");
		verkaeufer.setAdresse(new Adresse("Auch zu Hause", "7", "28195", "Bremen"));
		// businessobjects.Kaufvertrag anlegen.
		Kaufvertrag kaufvertrag = new Kaufvertrag(verkaeufer, kaeufer, ware);
		kaufvertrag.setZahlungsModalitaeten("Privater Barverkauf");
		// businessobjects.Kaufvertrag ausgeben.
		System.out.println(kaufvertrag);
	}

}
