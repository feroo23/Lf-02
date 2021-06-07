import businessObjects.Vertragspartner;
import dao.VertragspartnerDao;

public class JavaKlasseProgramm {

    public static void main(String[] args) throws ClassNotFoundException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nEinen Vertragspartner lesen");
        Vertragspartner vertragspartner = vertragspartnerDao.read("ABC123");
    }
}
