import java.util.*; // Package Java qui contient la classe scanner
class Saisie {
 /**
 * Lecture d'un entier, version scanner
 */
 static public void main(String args[]) {
 Scanner clavier = new Scanner(System.in);
 System.out.print("Donner entier: ");
 int n = clavier.nextInt();
 System.out.println (n*2);
 }
}