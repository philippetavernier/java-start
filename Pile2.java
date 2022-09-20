import java.io.*;

public class Pile2{
 
    int sommet;
    char[] piles;
 
    public Pile2 (int capacite){
      piles = new char[capacite];   //créer une nouvelle pile vide de taille maximal capacite
      sommet = -1;  //lorsque tu auras empiler un élément tu l'obtiendras à piles[0]
    }
 
    char getSommet(){
        return piles[sommet];
    }
 
    boolean estVide(){
      if(sommet == -1){
        return true;
      }
      return false;
    }
 
    boolean estPleine(){
      if(sommet == piles.length){
        return true;
      }
      return false;
    }
     
    void empile(char element){
      if (estPleine()){
        throw new Error("La pile est pleine impossible d'empiler");
      }
      piles[sommet+1] = element;
      sommet++;
    }
 
    int depile(){
      if (estVide()==true){
       throw new Error("La pile est vide impossible de depiler");
      }
      sommet--;  //inutile de la remplacer par une valeur 0 ou null car c'est avec l'indice sommet que tu y accèdes.
      return piles[sommet+1];      //on retourne la valeur que nous avons depiler
    }
 
    String versChaine(){ //Pour visualiser ta pile
      if(estVide()){
        return "[]";
      }
      if(sommet == 0){
        return "["+getSommet()+"]";
      }
      return "["+piles[0]+" "+getSommet()+"]";
    }
}