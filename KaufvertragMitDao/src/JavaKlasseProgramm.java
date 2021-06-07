import businessObjects.Vertragspartner;
import com.sun.jdi.connect.spi.Connection;
import dao.VertragspartnerDao;

import java.sql.DriverManager;

public class JavaKlasseProgramm {

    public static void main(String[] args) throws ClassNotFoundException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nEinen Vertragspartner lesen");
        Vertragspartner vertragspartner = vertragspartnerDao.read("123654918b");

    }
}
