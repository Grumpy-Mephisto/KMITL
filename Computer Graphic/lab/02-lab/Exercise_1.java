import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Exercise_1 extends JPanel {
    private static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        Exercise_1 panel = new Exercise_1();
        /*
         * Task 2
         */
        panel.NaiveLine(100, 100, 400, 200);
        /*
         * Task 3
         */
        panel.NaiveLine(400, 300, 100, 200);
        /*
         * Task 4
         */
        panel.NaiveLine(100, 100, 200, 400);

        JFrame frame = new JFrame("Exercise 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class Point {
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
    public void NaiveLine(float x1, float y1, float x2, float y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float m = dy / dx;
        float b = y1 - m * x1;

        for (float x = x1; x <= x2; x++) {
            float y = Math.round(x * m) + b;
            points.add(new Point(x, y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color DarkGunmetal = Color.decode("#161A30");
        g.setColor(DarkGunmetal);
        for (Point point : points) {
            plot(g, (int) point.x, (int) point.y);
        }
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}

/*
 * How can you improve the implementation in naiveLine method to draw lines in task 2 – 4
 * beautifully?
 * 
 * คำตอบ: โดยใช้ Bresenham's line algorithm
 */

