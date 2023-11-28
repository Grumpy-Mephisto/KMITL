import java.awt.*;
import javax.swing.*;

class GraphicsSwing extends JPanel {
    public static void main(String[] args) {
        GraphicsSwing gs = new GraphicsSwing();

        JFrame frame = new JFrame();
        frame.add(gs);
        frame.setTitle("First Swing");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        gs.paintComponent(frame.getGraphics());
    }

    public void paintComponent(Graphics g) {
        g.drawString("Hello", 40, 40);
        g.setColor(Color.BLUE);
        g.fillRect(130, 30, 100, 80);
        g.drawOval(30, 130, 50, 60);
        g.setColor(Color.RED);
        g.drawLine(0, 0, 200, 30);
        g.fillOval(130, 130, 50, 60);
        g.drawArc(30, 200, 40, 50, 90, 60);
        g.fillArc(30, 130, 40, 50, 180, 40);

        for (int i = 0; i < 10; i++) {
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            g.setColor(new Color(red, green, blue));
            plot(g, (i * 10) + 200, (i * 10) + 200);
        }
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}
