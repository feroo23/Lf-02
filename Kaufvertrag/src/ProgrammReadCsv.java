import java.io.*;

public class ProgrammReadCsv {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("Test.csv"));

        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());



    }

}