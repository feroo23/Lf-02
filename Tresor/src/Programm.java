import java.util.ArrayList;

public class Programm {

    public static void main(String[] args) {
        ArrayList<Gegenstand> gegenstand = new ArrayList<>();

        //Aktie 1
        Aktie aktie1 = new Aktie(236547852,602.52,"Benz",500);
        gegenstand.add(aktie1);

        //Aktie2
        Aktie aktie2 = new Aktie(785436845,1548.78,"Tesla",450);
        gegenstand.add(aktie2);

        //schmuck 1
        Schmuck schmuck1 = new Schmuck(458741256,658.78,"Uhr");
        gegenstand.add(schmuck1);

        //schmuck 2
        Schmuck schmuck2 = new Schmuck(145687853,12357.45,"Gold Kette");
        gegenstand.add(schmuck2);

        //tresi
        Tresor tresi = new Tresor(gegenstand);

        //Ausgabe
        System.out.println(tresi.toString());
        System.out.println(schmuck1.toString());
        System.out.println(schmuck2.toString());
        System.out.println(aktie1.toString());
        System.out.println(aktie2.toString());
    }
}
