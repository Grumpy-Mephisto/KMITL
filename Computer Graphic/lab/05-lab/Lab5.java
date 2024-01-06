import java.awt.*;
import javax.swing.*;

public class Lab5 extends JPanel implements Runnable {
    // Animation variables
    private final int SIZE = 100;
    private double circleMove = 0;
    private double circleSpeed = 100;
    private int circleDirection = 1; // 1 = right, -1 = left
    private double squareRotate = 0;
    private double squareSpeed = 0.5;

    public static void main(String[] args) {
        Lab5 lab5 = new Lab5();
        JFrame frame = new JFrame();
        frame.add(lab5);
        frame.setTitle("Laboratory 5th | 65050437");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        (new Thread(lab5)).start();
    }

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            ///// Animation /////

            // Move circle to the right by 100 pixels per second (100 px/s)
            circleMove += circleDirection * circleSpeed * elapsedTime / 1000.0;

            // If circle is out of bounds, change direction
            if (circleMove >= getWidth() - SIZE) {
                circleMove = getWidth() - SIZE;
                circleDirection = -1; // Change direction to move left
            } else if (circleMove <= 0) {
                circleMove = 0;
                circleDirection = 1; // Change direction to move right
            }

            // Rotate square by 0.5 radians per second (0.5 rad/s)
            squareRotate += squareSpeed * elapsedTime / 1000.0;

            repaint();

            // Delay for smoother animation
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // not work harder for reset background! PLEASE! :(
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        // Animation with circle
        g2d.translate(circleMove, 0); // Move to the right
        g2d.drawOval(0, 0, SIZE, SIZE);
        g2d.translate(-circleMove, 0); // Move back to original position

        // Animation with square
        g2d.rotate(squareRotate, 300, 300);
        g2d.drawRect(0, 200, SIZE, SIZE);
    }
}
