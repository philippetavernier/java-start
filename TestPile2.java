import java.lang.*; // pour la classe System
import java.util.*;   // pour la classe Scanner 
public class TestPile2 {
    static public void main(String args[]) {
        char c;
        Scanner clavier = new Scanner(System.in);

        //Pile p = new Pile();
        Pile2 p = new Pile2(8);
        while ( (c=clavier.next().charAt(0) ) !='#') {
            p.empile (c) ;
            
            if(p.estPleine()) break;
        }

        //System.out.println(p.toString());  //to override dans p
        while (!p.estVide()) {
            c = p.getSommet();
            System.out.println (c);
            p.depile();
            System.out.println ("depile + "+c);
        }
    }
}