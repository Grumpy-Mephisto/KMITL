import javax.swing.*;
import java.awt.*;

public class NewYearImage extends JFrame {
    public NewYearImage() {
        setTitle("Mickey Mouse");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().add(new MickeyMousePanel());
        setVisible(true);
    }

    class MickeyMousePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Draw Mickey Mouse
            g2d.setColor(Color.BLACK);

            // Draw head (large circle)
            g2d.fillOval(200, 100, 200, 200);

            // Draw ears (smaller circles)
            g2d.fillOval(150, 100, 100, 100);
            g2d.fillOval(350, 100, 100, 100);

            // Draw eyes (smaller filled circles)
            g2d.setColor(Color.WHITE);
            g2d.fillOval(250, 150, 30, 30);
            g2d.fillOval(320, 150, 30, 30);

            // Draw pupils (even smaller filled circles)
            g2d.setColor(Color.BLACK);
            g2d.fillOval(260, 160, 10, 10);
            g2d.fillOval(330, 160, 10, 10);

            // Draw nose (small filled circle)
            g2d.setColor(Color.RED);
            g2d.fillOval(295, 195, 10, 10);

            // Draw smiling mouth (curved line)
            g2d.setColor(Color.RED);
            g2d.drawArc(250, 200, 100, 60, 180, 180);
        }
    }

    public static void main(String[] args) {
        new NewYearImage();
    }
}
