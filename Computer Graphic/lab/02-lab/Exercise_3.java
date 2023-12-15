import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Exercise_3 extends JPanel {
    private static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        Exercise_3 panel = new Exercise_3();
        /*
         * Task 2
         */
        panel.BresenhamLine(100, 100, 400, 200);
        /*
         * Task 3
         */
        panel.BresenhamLine(400, 300, 100, 200);
        /*
         * Task 4
         */
        panel.BresenhamLine(100, 100, 200, 400);

        JFrame frame = new JFrame("Exercise 3");
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

    /**
     * This method implements the Bresenham's line algorithm.
     * @param x1 the x-coordinate of the first point
     * @param y1 the y-coordinate of the first point
     * @param x2 the x-coordinate of the second point
     * @param y2 the y-coordinate of the second point
     */
    public void BresenhamLine(float x1, float y1, float x2, float y2) {
        float dx = Math.abs(x2 - x1);
        float dy = Math.abs(y2 - y1);

        // Determine the direction of the line
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        boolean isSwap = false;

        if (dy > dx) {
            Swap(dx, dy);
            isSwap = true;
        }

        float D = 2 * dy - dx; // Initial decision parameter

        float x = x1;
        float y = y1;

        for (int i = 1; i <= dx; i++) {
            points.add(new Point(x, y));

            while (D >= 0) {
                if (isSwap) {
                    x += sx;
                } else {
                    y += sy;
                }
                D -= 2 * dx;
            }

            if (isSwap) {
                y += sy;
            } else {
                x += sx;
            }
            D += 2 * dy;
        }
    }

    private void Swap(float a, float b) {
        float temp = a;
        a = b;
        b = temp;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Color Gray = Color.decode("#B6BBC4");
        g2d.setColor(Gray);
        for (Point point : points) {
            int x = Math.round(point.x);
            int y = Math.round(point.y);
            g2d.drawLine(x, y, x, y);
        }
    }
}

/*
 * Why the bresenhamLine method should be drawn as the pseudo code above?
 * 
 * คำตอบ: เพราะว่า Bresenham algorithm
 * เป็นอัลกอริทึมที่ใช้ในการวาดเส้นที่มีความเร็วสูงกว่าการวาดเส้นแบบ naive algorithm
 */