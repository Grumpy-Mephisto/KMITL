/**
 * Exercise 2: Digital Differential Analyzer (DDA) Line Drawing Algorithm Implementation.
 * This exercise demonstrates line drawing using the DDA algorithm in a Java Swing application.
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Exercise_2 extends JPanel {
    private static ArrayList<Point> points = new ArrayList<>();

    /**
     * The entry point of the application. Initializes the drawing panel and frame.
     * Lines are drawn on the panel using the DDA algorithm, and the frame is displayed.
     */
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
    /**
     * Draws a line between two points using the DDA line drawing algorithm.
     *
     * @param x1 The x-coordinate of the starting point.
     * @param y1 The y-coordinate of the starting point.
     * @param x2 The x-coordinate of the ending point.
     * @param y2 The y-coordinate of the ending point.
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

    /**
     * Overridden method from JPanel to handle custom painting on the panel.
     * It draws all points calculated by the DDA algorithm.
     *
     * @param g The Graphics context to use for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // hsl(242, 23%, 25%)
        Color Jacarta = Color.getHSBColor(242 / 360f, 23 / 100f, 25 / 100f);
        g.setColor(Jacarta);
        for (Point point : points) {
            plot(g, (int) point.x, (int) point.y);
        }

    }

    /**
     * Plots a single pixel at the specified coordinates using the Graphics context.
     *
     * @param g The Graphics context to use for painting.
     * @param x The x-coordinate of the pixel.
     * @param y The y-coordinate of the pixel.
     */
    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

}

/*
 * How can we improve DDALine method to be more readable?
 * 
 * คำตอบ: ใช้ switch case แทน if else และใช้ Math.abs() แทนการเขียนเงื่อนไข
 */
