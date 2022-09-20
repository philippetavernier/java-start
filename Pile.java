public class Pile {
//
// Déclarations des attributs de la pile
//
static final int MAX = 8;
char t[];
int top;
//
// Programmation des opérations (méthodes) de la pile
//
    public Pile() {
        // Initialise une pile vide
        t = new char[MAX];
        top = -1;
    }
    public void empiler(char c) {
        // Empile le caractère donné en paramètre
        System.out.println("Char c -"+c);
        if (!estPleine()){
            t[++top] = c;
            System.out.println("pile p :"+t[top]);
        }
        else
        System.out.println("Pile pleine");
    }
    public char sommet() {
        // Retourne le caractère au sommet de la pile, sinon '\0'
        // ... a compléter ...
        // if(estPleine()){
            return(t[MAX-1]);
        /*}
        else {
            return(0);
        }*/
        
    }
    public void depiler() {
        // décapite la pile (retire le sommet )
        // ... a compléter ...
        t[MAX-1]=' ';
    }
    public boolean estVide() {
    // Teste si la pile est vide
    return (top < 0);
    }
    public boolean estPleine() {
    // teste si la pile est pleine
    // ... à completer ...
    System.out.println("top - "+top);
        if (top==(t.length-1)){
            return true;
        }
        else{
            return false;
        }
    }
}; // class Pile