/**
 * Classe Point du plan avec ses cordonnées x et y
 */

 public class Point extends Object{
    public int x, y;

    /**
     * Methode qui affecte la valeur de son paramètre 
     * au Point this.
     */    
    public void setX(int p) {
        //x = p;
        this.x = p;
    }

    public void setY(int p) {
        y = p;
        this.y = p;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /**
    *Moves this point to the specificed location in the (x, y) coordinate plane.
     */
    public void	set(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void	move(int x, int y){
        this.x=this.x+x;
        this.y=this.y+y;
    }
    /**public Point(Point p){
        this(p.x,p.y);
        //this.x = x;
        //this.y = y;
    }
    */
    /**
    *  Initialise un point à l'origine
    */
    public Point(){x = 0; y = 0;} 

    /**
    *  Initialise un point à a et b)
    */
    public Point(int a, int b){x = a; y = b;}


    public Point getLocation() {
        return new Point(this.x,this.y);
    }
          
};