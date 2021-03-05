public class Adresse {

    private String str;
    private String hausNr;
    private String pzl;
    private String ort;

    public Adresse(String str, String hausNr, String pzl, String ort) {
        this.str = str;
        this.hausNr = hausNr;
        this.pzl = pzl;
        this.ort = ort;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getHausNr() {
        return hausNr;
    }

    public void setHausNr(String hausNr) {
        this.hausNr = hausNr;
    }

    public String getPzl() {
        return pzl;
    }

    public void setPzl(String pzl) {
        this.pzl = pzl;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        String text = "\n\t" + getStr() + " " + getHausNr();
        text += "\n\t" + getPzl() + " " + getOrt();
        return text;
    }
}
