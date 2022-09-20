class C {
    int x; // un champ entier
    public int getX(){return x;} // méthode pour consulter le champ x
    public void setX(int p){x = p;} // méthode pour modifier le champ x
    static public void main(String args[]){
        C x = new C(), y = new C();
        x.setX(5);
        y.setX(6);
        System.out.println(x.getX() + " et " + y.getX()); 
        x=y;
        x.setX(4);
        System.out.println(x.getX() + " et " + y.getX());
    }
}