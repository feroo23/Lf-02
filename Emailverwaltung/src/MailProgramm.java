import bo.EmailKontakt;
import emailDao.EmailKontaktDao;
import emailDao.MailException;
import service.IO;

import java.io.IOException;

public class MailProgramm {

    public static void main(String[] args) throws IOException, MailException {
        System.out.println("Was wollen sie machen?");
        String x = IO.readString();

        if (x.equalsIgnoreCase("select")){
            select();
        }
    }

    private static void select() throws IOException, MailException {
        System.out.println("Geben sie ihre ID ein");
        int x = IO.readInteger();
        EmailKontaktDao emailKontaktDao = new EmailKontaktDao();
        EmailKontakt emailKontakt = null;

        try {
            emailKontakt = emailKontaktDao.select(x);
        }catch (MailException e){
            e.getMessage();
        }
        if (emailKontakt != null) {
            System.out.println(emailKontakt);
        }
    }
}
