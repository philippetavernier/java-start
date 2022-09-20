import java.util.*;

class Celsius {
 public static void main(String args[]){
        class Celc {
            //static double c2f(int c){ //methode de classe
            double c2f(int c){          //methode d'instance
                double f = 9./5 * c + 32;
                return f;
            }
        };
      
 Scanner clavier = new Scanner(System.in);
 System.out.print("Donner entier: ");
 int c = clavier.nextInt();
 

 //double f = Celc.c2f (c) ; //methode de classe
 Celc obj = new Celc();      //methode d'instance
 double f = obj.c2f (c) ;
  System.out.println("Bonjour ");
   System.out.println("la temperature de "+c+"celsius donne "+f+"fahrenheit" );
 //System.out.format("la temperature de %d celsius donne %d degre farhrenheit", c, f);
 }
};