public class TestPoint{
    static public void main(String args[]){
        Point p = new Point();           
        p.setX (3);
        p.setY (4);
        System.out.println( p.getX() );
        System.out.println( p.getY() );
        p.set(7,8);     
        System.out.println( p.getX() );
        System.out.println( p.getY() );
        p.move(1,1);     
        System.out.println( p.getX() );
        System.out.println( p.getY() );
        System.out.println( p.getLocation() );
    }
};