//
// Passage des paramètres
//
class TestParam extends Object {
 static public void main(String args[]){
 int x = 2;
 System.out.println("Avant modif, x = " + x);
modifVal(x);
 System.out.println("Apres modif, x = " + x);
 int [] t = {2, 3};
 System.out.println("Avant modif, t[0] = " + t[0]);
 modifObj(t);
 System.out.println("Apres modif, t[0] = " + t[0]);
 }
 public static void modifObj(int p[]) {
p[0] = p[0] + 200; // Objet référencé p est modifié
 }
 public static void modifVal(int x) {
x = x + 200; // paramètre x modifié
 }
}