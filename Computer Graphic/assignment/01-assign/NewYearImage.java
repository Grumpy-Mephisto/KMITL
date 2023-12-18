import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class NewYearImage extends JFrame {
    public NewYearImage() {
        setTitle("Cartoon Image");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().add(new CartoonPanel());
        setVisible(true);
    }

    class CartoonPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw cartoon-style elements
            g2d.setColor(Color.BLACK);

            // Draw cartoon character (basic shapes)
            g2d.fillOval(200, 200, 200, 200); // Head
            g2d.fillRect(240, 300, 120, 40); // Body
            g2d.fillOval(230, 180, 40, 60); // Left eye
            g2d.fillOval(330, 180, 40, 60); // Right eye
            g2d.drawArc(250, 260, 100, 80, 180, 180); // Mouth

            // Draw other cartoon elements using Bresenham's lines, Bezier curves, or filled
            // polygons
            // Example:
            g2d.setColor(Color.RED);

            // Example Bresenham's Line
            g2d.drawLine(100, 100, 300, 300);

            // Example Bezier Curve
            g2d.draw(new CubicCurve2D.Double(50, 50, 150, 200, 250, 200, 350, 50));

            // Example Filled Polygon
            int[] xPoly = {400, 450, 500, 450};
            int[] yPoly = {400, 450, 400, 350};
            g2d.fillPolygon(xPoly, yPoly, 4);
        }
    }

    public static void main(String[] args) {
        new NewYearImage();
    }
}
