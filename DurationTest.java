
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DurationTest {

    public static void main(String[] args) {
        new DurationTest();
    }

    public DurationTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Utilities {

        public static Point2D pointOnCircle(double degress, double radius) {
            double rads = Math.toRadians(degress - 90); // 0 becomes the top
            double xPosy = Math.round((Math.cos(rads) * radius));
            double yPosy = Math.round((Math.sin(rads) * radius));
            return new Point2D.Double(radius + xPosy, radius + yPosy);
        }

        public static Point2D pointOnCircle(double xOffset, double yOffset, double degress, double radius) {
            Point2D poc = pointOnCircle(degress, radius);
            return new Point2D.Double(xOffset + poc.getX(), yOffset + poc.getY());
        }
    }

    public class TestPane extends JPanel {

        private List<AnimatedDot> dots = new ArrayList<>(128);

        private Duration duration = Duration.ofSeconds(5);

        private DurationAnimationEngine engine;

        private List<Color> colors = Arrays.asList(new Color[]{
            Color.RED,
            Color.BLUE,
            Color.CYAN,
            Color.GRAY,
            Color.GREEN,
            Color.LIGHT_GRAY,
            Color.MAGENTA,
            Color.PINK,
            Color.WHITE,
            Color.YELLOW
        });

        public TestPane() {
            Random rnd = new Random();
            setBackground(Color.BLACK);

            for (int index = 0; index < 100; index++) {
                double fromAngle = 360.0 * rnd.nextDouble();
                double toAngle = fromAngle + 180.0;
                Collections.shuffle(colors);
                Color color = colors.get(0);
                dots.add(new AnimatedDot(
                        Utilities.pointOnCircle(fromAngle, 150),
                        Utilities.pointOnCircle(toAngle, 150),
                        color, 2));
            }

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (engine != null) {
                        engine.stop();
                        engine = null;

                        // Reset poisitions
                        for (AnimatedDot dot : dots) {
                            dot.move(0);
                        }
                        repaint();
                        return;
                    }

                    engine = new DurationAnimationEngine(duration, new DurationAnimationEngine.Tickable() {
                        @Override
                        public void animationDidTick(double progress) {
                            for (AnimatedDot dot : dots) {
                                dot.move(progress);
                            }
                            repaint();
                        }
                    });
                    engine.start();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
            int xOffset = (getWidth() - 300) / 2;
            int yOffset = (getWidth() - 300) / 2;
            g2d.translate(xOffset, yOffset);
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawOval(0, 0, 300, 300);

            for (AnimatedDot dot : dots) {
                dot.paint(g2d);
            }

            g2d.dispose();
        }

    }

    public class DurationAnimationEngine {

        public interface Tickable {

            public void animationDidTick(double progress);
        }

        private Duration duration;
        private Instant timeStarted;

        private Timer timer;

        private Tickable tickable;

        public DurationAnimationEngine(Duration duration, Tickable tickable) {
            this.duration = duration;
            this.tickable = tickable;
        }

        public void start() {
            // You could create the timer lazierly and restarted it as needed
            if (timer != null) {
                return;
            }

            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (timeStarted == null) {
                        timeStarted = Instant.now();
                    }
                    Duration runtime = Duration.between(timeStarted, Instant.now());
                    double progress = Math.min(1.0, runtime.toMillis() / (double) duration.toMillis());

                    tickable.animationDidTick(progress);

                    if (progress >= 1.0) {
                        stop();
                    }
                }
            });
            timer.start();
        }

        public void stop() {
            if (timer == null) {
                return;
            }
            timer.stop();
            timer = null;
        }

    }

    public class AnimatedDot {

        private Dot dot;

        private Point2D from;
        private Point2D to;

        public AnimatedDot(Point2D from, Point2D to, Color color, int radius) {
            dot = new Dot(from.getX(), from.getY(), color, radius);
            this.from = from;
            this.to = to;
        }

        public void paint(Graphics2D g) {
            dot.paint(g);
        }

        public void move(double progress) {
            Point2D pointAt = pointAt(progress);
            dot.setLocation(pointAt);
        }

        public Point2D getFrom() {
            return from;
        }

        public Point2D getTo() {
            return to;
        }

        protected double getFromX() {
            return getFrom().getX();
        }

        protected double getFromY() {
            return getFrom().getY();
        }

        public Double getXDistance() {
            return getTo().getX() - getFrom().getX();
        }

        public Double getYDistance() {
            return getTo().getY() - getFrom().getY();
        }

        protected Point2D pointAt(double progress) {
            double xDistance = getXDistance();
            double yDistance = getYDistance();

            double xValue = Math.round(xDistance * progress);
            double yValue = Math.round(yDistance * progress);

            xValue += getFromX();
            yValue += getFromY();

            return new Point2D.Double(xValue, yValue);
        }
    }

    public class Dot {

        private Color color;
        private double y;
        private double x;
        private int radius;

        private Ellipse2D dot;

        public Dot(double x, double y, Color color, int radius) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.radius = radius;

            dot = new Ellipse2D.Double(0, 0, radius * 2, radius * 2);
        }

        public void setLocation(Point2D point) {
            setLocation(point.getX(), point.getY());
        }

        public void setLocation(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void paint(Graphics2D g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(color);
            g2d.translate(x - radius, y - radius);
            g2d.fill(dot);
            g2d.dispose();
        }

    }
}