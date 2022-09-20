import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationTuto extends JPanel implements ActionListener {

    
    Timer tm= new Timer(5, this);
    int x = 0, velX = 2;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(x, 30, 50, 30);

        tm.start();

    }
    public void actionPerformed (ActionEvent e){
        if (x<0 || x>550) velX=-velX;

        x = x+ velX;
        repaint(); 
    }

    public static void main(String[] args) {
        AnimationTuto t = new AnimationTuto();
        JFrame jf = new JFrame();
        jf.setTitle("tutorial");
        jf.setSize(600,400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);

    }
}