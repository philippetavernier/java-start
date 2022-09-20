//
// Objets vs Valeurs
//
class Test {
 static public void main(String[] args) {
 int x = 1, y;
 //////// affectation de valeurs /////////
y = x; // deux valeurs égales mais objets differents.
 System.out.println("Avant (x = 100): x = " + x + " , y = " + y);
 x = 100;
 System.out.println("Après (x = 100): x = " + x + " mais y = " + y);
 // constater que y n'as pas changé
 int[] u = {4, 5}; // tableau à 2 entiers.
 int[] v;
 ////// même chose avec objets (ici tableaux) ///////
v = u;
 System.out.println("Avant (u[0] = 100): u[0] = " + u[0] + "  ET v[0] = "+v[0] );
  u[0] = 100;
 System.out.println("Après (u[0] = 100): u[0] = " + u[0] + " ET v[0] = "+v[0] ); // constater que v[0] a changé aussi
  v[0]=2;
 System.out.println("Après (u[0] = 100): u[0] = " + u[0] + " ET v[0] = "+v[0] );
 
 }
}