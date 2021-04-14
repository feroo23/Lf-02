import java.io.*;

public class ProgrammReadCsv {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Test.csv"));
        String s;
        while ((s = br.readLine()) != null) {
            for (String h : s.split(";")){
                System.out.println(h);
            }
        }
    }
}