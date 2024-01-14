import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.geom.*;
import java.awt.image.*;

public class Lab6 extends JPanel implements Runnable {
    private final int SCREEN = 600;
    private final int WIDTH = 200;
    private final int HEIGHT = 200;

    public static void main(String[] args) {
        Lab6 lab6 = new Lab6();
        JFrame frame = new JFrame("Laboratory 6th | 65050437");
        frame.add(lab6);
        frame.setSize(new Dimension(lab6.SCREEN, lab6.SCREEN));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        (new Thread(lab6)).start();
        lab6.saveImage("65050437_lab6");
    }

    @Override
    public void run() {
        System.out.println("Drawing...");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Transformation matrix (Translation 100px to right and 100px down)
        g2d.setTransform(new AffineTransform(1, 0, 0, 1, 100, 100));
        g2d.setColor(Color.RED);
        g2d.drawRect(0, 0, WIDTH, HEIGHT);
        System.out.println("Coordinate: (" + g2d.getTransform().getTranslateX() + ", "
                + g2d.getTransform().getTranslateY() + ")");

        // Rotate the square 30 degrees counterclockwise around its center
        int angleDegree = 30;
        double centerX = WIDTH / 2.0;
        double centerY = HEIGHT / 2.0;
        boolean isCounterClockwise = true;
        double angle = Math.toRadians(angleDegree * (isCounterClockwise ? -1 : 1));

        double x = centerX + (Math.cos(angle) * (0 - centerX) - Math.sin(angle) * (0 - centerY));
        double y = centerY + (Math.sin(angle) * (0 - centerX) + Math.cos(angle) * (0 - centerY));

        g2d.setTransform(new AffineTransform(Math.cos(angle), Math.sin(angle), -Math.sin(angle),
                Math.cos(angle), x, y));

        g2d.setColor(Color.GREEN);
        g2d.drawRect(0, 0, WIDTH, HEIGHT);
        System.out.println("Coordinate: (" + g2d.getTransform().getTranslateX() + ", "
                + g2d.getTransform().getTranslateY() + ")");

        // Scale the square by 2 around its top-left corner and then translate -50px on X axis and
        // 50px on Y axis
        double scaleX = 2.0;
        double scaleY = 2.0;
        double translateX = -50;
        double translateY = 50;

        g2d.setTransform(new AffineTransform(scaleX, 0, 0, scaleY, translateX, translateY));

        g2d.setColor(Color.BLUE);
        g2d.drawRect(0, 0, WIDTH, HEIGHT);
        System.out.println("Coordinate: (" + g2d.getTransform().getTranslateX() + ", "
                + g2d.getTransform().getTranslateY() + ")");
    }

    private void saveImage(String fileName) {
        BufferedImage imageBuffer =
                new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imageBuffer.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        paintComponent(g2d);

        g2d.dispose();

        try {
            ImageIO.write(imageBuffer, "png", new File(fileName + ".png"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
