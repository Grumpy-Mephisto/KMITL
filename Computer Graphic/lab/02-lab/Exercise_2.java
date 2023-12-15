import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Exercise_2 extends JPanel {
    private static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        Exercise_2 panel = new Exercise_2();
        /*
         * Task 2
         */
        panel.DDALine(100, 100, 400, 200);
        /*
         * Task 3
         */
        panel.DDALine(400, 300, 100, 200);
        /*
         * Task 4
         */
        panel.DDALine(100, 100, 200, 400);

        JFrame frame = new JFrame("Exercise 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static class Point {
        float x;
        float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    /*
     * Task 1
     */
    public void DDALine(float x1, float y1, float x2, float y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;

        float y = y1;
        float x = x1;
        float m = dy / dx;

        if (m <= 1 && m >= -1) {
            if (dx >= 0) {
                for (x = x1; x <= x2; x++) {
                    points.add(new Point(x, y));
                    y += m;
                }
            } else {
                for (x = x1; x >= x2; x--) {
                    points.add(new Point(x, y));
                    y -= m;
                }
            }
        } else if (m > 1 || m < -1) {
            if (dy >= 0) {
                for (y = y1; y <= y2; y++) {
                    points.add(new Point(x, y));
                    x += 1 / m;
                }
            } else {
                for (y = y1; y >= y2; y--) {
                    points.add(new Point(x, y));
                    x -= 1 / m;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Color Jacarta = Color.decode("#31304D");
        g2d.setColor(Jacarta);
        for (Point point : points) {
            int x = Math.round(point.x);
            int y = Math.round(point.y);
            g2d.drawLine(x, y, x, y);
        }
    }
}

/*
 * How can we improve DDALine method to be more readable?
 * 
 * คำตอบ: ใช้ switch case แทน if else และใช้ Math.abs() แทนการเขียนเงื่อนไข
 */
