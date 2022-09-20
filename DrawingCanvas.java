import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics;
import javax.swing.*;

public class DrawingCanvas extends JComponent{
    private int width;
    private int height;
    private Cloud c1;      //CALL THE CLOUD METHOD
    private Cloud c2;
    private Cloud c3;    
    public DrawingCanvas(int w, int h){  //CONSTRUCTEUR
        width=w;
        height=h;
        c1= new Cloud(10,50,75,Color.LIGHT_GRAY);
        c2= new Cloud(200,80,90,Color.BLUE);
        c3= new Cloud(420,60,85,Color.DARK_GRAY);
        
    }
    protected void paintComponent(Graphics g){
        //Graphics2D g2D = (Graphics2D) baseImage.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints( 
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        /*Rectangle2D.Double r = new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(new Color(100,149,237));
        g2d.fill(r);

        Ellipse2D.Double e = new Ellipse2D.Double(200,75,100,100);
        g2d.setColor(Color.BLUE);
        g2d.fill(e);

        Line2D.Double line = new Line2D.Double(100,250,300,77);
        g2d.setColor(Color.BLACK);
        g2d.draw(line);
        */
        /*
        c1.drawCloud(g2d);
        c2.drawCloud(g2d);
        c3.drawCloud(g2d);
        */

        Path2D.Double p = new Path2D.Double();
        /*
        p.moveTo(100,300);
        p.lineTo(150,200);
        p.lineTo(200,300);
        p.closePath();
        g2d.draw(p);
        */
        Path2D.Double curve = new Path2D.Double();
        curve.moveTo(250,400);
        curve.curveTo(350,300,500,300,600,400);
        g2d.draw(curve);

        Path2D.Double curve2 = new Path2D.Double();
        curve2.moveTo(150,400);
        curve2.curveTo(350,300,500,300,600,400);
        g2d.draw(curve2);

        Path2D.Double curve3 = new Path2D.Double();
        curve3.moveTo(450,40);
        curve3.curveTo(350,300,500,300,600,400);
        g2d.draw(curve3);

        Path2D.Double curve4 = new Path2D.Double();
        curve4.moveTo(450,40);
        curve4.curveTo(350,300,500,300,300,400);
        g2d.draw(curve4);

        Path2D.Double heart = new Path2D.Double();
        heart.moveTo(328,256);
        heart.curveTo(329,204,397,199,401,252);
        heart.curveTo(413,201,468,198,466,250);
        heart.curveTo(465,304,415,345,402,350);
        heart.curveTo(388,346,328,308,328,256);
        g2d.fill(heart);

        Rectangle2D.Double r1 = new Rectangle2D.Double(0,0,100,100);
        Rectangle2D.Double r2 = new Rectangle2D.Double(100,150,50,100);
        Rectangle2D.Double r3 = new Rectangle2D.Double(0,0,100,100);

        AffineTransform reset = g2d.getTransform();
        
        g2d.setColor(Color.BLUE);
        g2d.translate(150,100);
        g2d.fill(r1);
        g2d.fill(r2);

        g2d.translate(300,300);
        g2d.fill(r3);
        


        //g2d.translate(-400,-400);
        g2d.setTransform(reset);
        g2d.fill(r3);

        g2d.setColor(Color.GREEN);
        g2d.rotate(Math.toRadians(15),100,150);
        g2d.fill(r2);




    }
} 