/**
 Classe Java correspondant au TAD pile
 (voir plus tard, la version avec interface Java
  et implementation)
 */ 

class PileOverflow extends Throwable {};
    // Débordement par le haut de la pile
class PileUnderflow extends Throwable {};
    // Débordement par le bas de la pile

public class PileException {

//  Méthodes:
//
//  Pile()
//  void empiler(char) throws PileOverflow
//          // Empile le caractère donné
//  char sommet() throws PileUnderflow
//          // Retourne le caractère au sommet de la pile
//  void depiler() throws PileUnderflow
//          // Décapite la pile (retire le sommet )
//  boolean estVide()
//          // Teste si la pile est vide
//  boolean estPleine()
//        // Teste si la pile est pleine


//
//  Déclarations des attributs de la pile
//
    static final int MAX = 3;
    char t[];
    int top;

//
//  Programmation des opérations (méthodes) de la pile
//


    /**
     * Initialise une pile vide
     */
    public PileException() {
        // Initialise une pile vide
        t = new char[MAX];
        top = -1;
    }

    /**
     * Empile le caractère donné
     */
    public void empiler(char c) throws PileOverflow {
        // Empile le caractère donné
        if (!estPleine())
            t[++top] = c;
        else
            throw new PileOverflow();
    }

    /**
     * Consulte et retourne le caractère
     * au sommet de la pile
     */
    public char sommet() throws PileUnderflow {
        // Retourne le caractère au sommet de la pile
        if (!estVide())
            return t[top];
        else
            throw new PileUnderflow();
    }

    /**
     * Décapite la pile (retire le sommet )
     */
    public void depiler() throws PileUnderflow {
        //    décapite la pile (retire le sommet )
        if (!estVide())
            top--;
        else
             throw new PileUnderflow();
    }

    /**
     * Teste si la pile est vide
     */
    public boolean estVide() {
        //    Teste si la pile est vide
        return (top < 0);
    }

    /**
     * Teste si la pile est vide
     */
    public boolean estPleine() {
        // teste si la pile est pleine
        return (top >= (MAX - 1));
    }

}; // class Pile