import javax.swing.*;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DrawingTester {
    public static void main(String[] args) {
    int w = 640;
    int h = 480;
    JFrame f = new JFrame("testing");
    DrawingCanvas dc = new DrawingCanvas(w,h);
    f.setSize(w,h);
    f.setTitle("Drawing in canvas");
    f.add(dc);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    }
}