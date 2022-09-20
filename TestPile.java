import java.lang.*; // pour la classe System
import java.util.*;   // pour la classe Scanner 
public class TestPile {
    static public void main(String args[]) {
        char c;
        Scanner clavier = new Scanner(System.in);

        //Pile p = new Pile();
        Pile2 p = new Pile2(8);
        while ( (c=clavier.next().charAt(0) ) !='#') {
            p.empiler (c) ;
            
            if(p.estPleine()) break;
        }

        //System.out.println(p.toString());  //to override dans p
        while (!p.estVide()) {
            c = p.sommet();
            System.out.println (c);
            p.depiler();
        }
    }
}