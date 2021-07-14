package businessObjects;

import java.util.ArrayList;

public class Ware {
	private int warenNr;
	private String bezeichnung;
	private String beschreibung;
	private double preis;
	private ArrayList<String> besonderheitenListe;
	private ArrayList<String> maengelListe;

	/**
	 * Konstruktor.
	 * @param bezeichnung	Die Bezeichnung der Ware.
	 * @param preis			Der Preis der Ware.
	 */
	public Ware(String bezeichnung, double preis) {
		this.bezeichnung = bezeichnung;
		this.preis = preis;
		besonderheitenListe = new ArrayList<String>();
		maengelListe = new ArrayList<String>();
	}



	/**
	 * Gibt die Bezeichnung der Ware aus.
	 * @return	Die Bezeichnung der Ware.
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	public int getWarenNr() {
		return warenNr;
	}

	public void setWarenNr(int warenNr) {
		this.warenNr = warenNr;
	}

	/**
	 * Aktualisiert die Bezeichnung der Ware.
	 * @param bezeichnung	Die neue Bezeichnung der Ware.
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * Gibt die Beschreibung der Ware aus.
	 * @return	Die Beschreibung der Ware.
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * Aktualisiert die Beschreibung der Ware.
	 * @param beschreibung	Die neue Beschreibung der Ware.
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * Gibt den Preis der Ware aus.
	 * @return	Der Preis der Ware.
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * Aktualisiert den Preis der Ware.
	 * @param preis	Der neue Preis der Ware.
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

	/**
	 * Gibt die Liste der Besonderheiten der Ware aus.
	 * @return	Die Liste der Besonderheiten der Ware.
	 */
	public ArrayList<String> getBesonderheitenListe() {
		return besonderheitenListe;
	}

	/**
	 * Gibt die Liste der Mängel der Ware aus.
	 * @return	Die Liste der Mängel der Ware.
	 */
	public ArrayList<String> getMaengelListe() {
		return maengelListe;
	}

	/**
	 * (non-Javadoc)
	 * @see Object#toString()
	 */
	@Override
	public String toString() {

		String text = "\n\t\t" + warenNr;
		text += "\n\t\tBeschreibung: " + beschreibung;
		text += "\n\t\tPreis: " + preis;
		text += "\n\t\tBesonderheiten: " + besonderheitenListe;
		text += "\n\t\tMängel: " + maengelListe + "\n";
		return text;
	}
	
}
