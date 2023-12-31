import javax.swing.*;
import java.awt.*;

public class Lab4 extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 4 - Bresenham's Circle and Ellipse Algorithm");
        frame.setSize(600, 600);
        frame.add(new Lab4());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void Exercise1(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;

        while (x <= y) {
            // Color
            g.setColor(Color.decode("#d62828"));

            // plot(g, xc, yc); // Middle point
            plotSymmetricPointsCircle(g, xc, yc, x, y);

            x++;
            Dx += 2;
            D = D + Dx + 1;

            if (D >= 0) {
                y--;
                Dy -= 2;
                D = D - Dy;
            }
        }
    }

    private void plotSymmetricPointsCircle(Graphics g, int xc, int yc, int x, int y) {
        plot(g, xc + x, yc + y); // Octant 1
        plot(g, xc + y, yc + x); // Octant 2
        plot(g, xc - x, yc + y); // Octant 3
        plot(g, xc - y, yc + x); // Octant 4
        plot(g, xc - x, yc - y); // Octant 5
        plot(g, xc - y, yc - x); // Octant 6
        plot(g, xc + x, yc - y); // Octant 7
        plot(g, xc + y, yc - x); // Octant 8
    }

    public void Exercise2(Graphics g, int xc, int yc, int a, int b) {
        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;

        // REGION 1
        int x = 0;
        int y = b;
        int D = Math.round(b2 - a2 * b + 0.25f * a2);
        int Dx = 0;
        int Dy = twoA2 * y;

        while (Dx <= Dy) {
            // Color
            g.setColor(Color.decode("#606c38"));

            // plot(g, xc, yc); // Middle point
            plotSymmetricPointsEllipse(g, xc, yc, x, y);

            x++;
            Dx += twoB2;
            D = D + Dx + b2;

            if (D >= 0) {
                y--;
                Dy -= twoA2;
                D = D - Dy;
            }
        }

        // REGION 2
        x = a;
        y = 0;
        D = Math.round(a2 - b2 * a + 0.25f * b2);
        Dx = twoB2 * x;
        Dy = 0;

        while (Dx >= Dy) {
            // Color
            g.setColor(Color.decode("#bc6c25"));

            // plot(g, xc, yc); // Middle point
            plotSymmetricPointsEllipse(g, xc, yc, x, y);

            y++;
            Dy += twoA2;
            D = D + Dy + a2;

            if (D >= 0) {
                x--;
                Dx -= twoB2;
                D = D - Dx;
            }
        }
    }

    private void plotSymmetricPointsEllipse(Graphics g, int xc, int yc, int x, int y) {
        plot(g, xc + x, yc + y); // Quadrant 1
        plot(g, xc - x, yc + y); // Quadrant 2
        plot(g, xc - x, yc - y); // Quadrant 3
        plot(g, xc + x, yc - y); // Quadrant 4
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Exercise1(g, getWidth() / 2, getHeight() / 2, 200);
        Exercise2(g, getWidth() / 2, getHeight() / 2, 200, 100);
    }

    protected void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 3, 3);
    }
}
