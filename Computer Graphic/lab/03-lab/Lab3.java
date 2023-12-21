import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Lab3 extends JPanel {
    private BufferedImage image;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Lab 3 by 65050437");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Lab3 panel = new Lab3();
            frame.add(panel);

            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setFocusable(true);
            frame.requestFocusInWindow();
            frame.toFront();
        });
    }

    public void Bezierpve(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int x4,
            int y4) {
        int n = 1000;

        for (int i = 0; i < n; i++) {
            float t = i / (float) n;
            float u = 1 - t;
            float coef1 = u * u * u;
            float coef2 = 3 * u * u * t;
            float coef3 = 3 * u * t * t;
            float coef4 = t * t * t;
            int x = Math.round(coef1 * x1 + coef2 * x2 + coef3 * x3 + coef4 * x4);
            int y = Math.round(coef1 * y1 + coef2 * y2 + coef3 * y3 + coef4 * y4);
            plot(g2d, x, y);
        }
    }

    private void drawBezierPve(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        Bezierpve(g2d, x1, y1, x2, y2, x3, y3, x4, y4);
    }

    private void drawPolygon(Graphics2D g2d, int[] xPoints, int[] yPoints, int nPoints) {
        Polygon polygon = new Polygon(xPoints, yPoints, nPoints);
        g2d.drawPolygon(polygon);
    }

    public void floodFill(BufferedImage img, int x, int y, Color targetColor,
            Color replacementColor) {
        Queue<Point> q = new LinkedList<>();
        int targetRGB = targetColor.getRGB();
        int replacementRGB = replacementColor.getRGB();

        if (img.getRGB(x, y) == replacementRGB)
            return;

        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x < 0 || p.y < 0 || p.x >= img.getWidth() || p.y >= img.getHeight())
                continue;
            if (img.getRGB(p.x, p.y) == targetRGB) {
                img.setRGB(p.x, p.y, replacementRGB);
                q.add(new Point(p.x - 1, p.y));
                q.add(new Point(p.x + 1, p.y));
                q.add(new Point(p.x, p.y - 1));
                q.add(new Point(p.x, p.y + 1));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            // getWidth() and getHeight() are inherited from JPanel
            // and plus 1 to avoid the right and bottom borders
            image = new BufferedImage(getWidth() + 1, getHeight() + 1, BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = image.createGraphics();

            // Anti-aliasing
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            int xPoly[] = {150, 250, 325, 375, 400, 275, 100};
            int yPoly[] = {150, 100, 125, 225, 325, 375, 300};

            // Background
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Exercise 1 (Bezier pve)
            drawBezierPve(g2d, xPoly[0] - 50, yPoly[0], xPoly[1] - 50, yPoly[1] - 150, xPoly[2],
                    yPoly[2] - 150, xPoly[3] + 150, yPoly[3] + 150);

            // Exercise 2 (Drawing the polygon)
            drawPolygon(g2d, xPoly, yPoly, xPoly.length);

            // Exercise 3 (Flood fill)
            floodFill(image, 200, 150, Color.WHITE, Color.BLACK);

            g2d.dispose(); // Release resources
        }

        g.drawImage(image, 0, 0, this);
    }

    private void plot(Graphics2D g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}
