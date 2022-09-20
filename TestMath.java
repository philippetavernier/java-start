import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
class TestMath {
    public static int getRandom(int max){ 
        // return (int) (Math.random()*max); 
        //incorrect always return zero
        return (int) (Math.random()*max); 
    }
 static public void main(String args[]) {
 System.out.println("e = " + Math.E);
 System.out.println("pi = " + Math.PI);
 int largeur = 3, longueur = 4;
 double w = Math.pow(largeur,2) + Math.pow(longueur,2);
 double hypotenuse = Math.sqrt(w);
 System.out.println("Hypoténuse = " + hypotenuse);
 //... il vaut mieux écrire largeur * largeur que pow (largeur,2)...  }
double x = Math.random();
System.out.println("Random number 1:" + x);





int y= getRandom(49);
int nombre;
System.out.println("Random number 1:" + y);

List<Integer> DiceList = new ArrayList<Integer>();
for(int i=0; i<6; i++ ){
    nombre=getRandom(49);
    if (DiceList.contains(nombre)){
        i--;
        
    }
    else {
        DiceList.add(nombre);
    }
    System.out.println("i--- "+i );
    
}


System.out.println("LIst:" + DiceList);

}
}