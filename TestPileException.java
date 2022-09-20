import java.lang.*; 
// Pile de taille trois 
// on empile 4 fois (overflow) 
// et on dépile 4 fois (underflow)
// 

public class TestPileException {
    static public void main(String args[]) {
        char c;

        PileException p = new PileException();

        try{
           p.empiler ('a') ;
           p.empiler ('b') ;
           p.empiler ('c') ;
          p.empiler ('d') ;
        } catch (PileOverflow e){ 
          System.out.println("débordement par le haut empiler");
        }
        try{ 
          p.depiler();
          p.depiler();
          p.depiler();
          p.depiler();
        } catch (PileUnderflow e) {
          System.out.println("débordement par le bas dépiler");
        }
        try {  
          c = p.sommet();
        } catch (PileUnderflow e){
          System.out.println("débordement par le bas sommet");
       }    
    }
}
/* On obtient :
débordement par le haut empiler
débordement par le bas depiler
débordement par le bas sommet
*/