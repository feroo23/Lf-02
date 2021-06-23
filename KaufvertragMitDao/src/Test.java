import businessObjects.Vertragspartner;
import businessObjects.Ware;
import dao.VertragspartnerDao;
import dao.WareDao;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        VertragspartnerDao vertragspartnerDao = new VertragspartnerDao();
        System.out.println("\nEinen Vertragspartner lesen");
        Vertragspartner vertragspartner = vertragspartnerDao.read("1236545918b");
        System.out.println(vertragspartner);

        //Ware Ausgeben (Einen)
        WareDao wareDao = new WareDao();
        Ware ware = wareDao.read("654");
        System.out.println(ware);

        System.out.println("");

    }
}
