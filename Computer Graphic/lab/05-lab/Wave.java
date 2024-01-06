import javax.swing.*;
import java.awt.*;
// import java.awt.geom.*; // Not used
import java.awt.image.BufferedImage;
import java.util.*;

/*** PDE Wave Simulation */
/*** Pseudo coded by Keenan Crane CMU, USA */
/*** Java coded by Witchaya T. KMITL, THAILAND */

class Wave extends JPanel implements Runnable {
    final int N = 600;
    double u[][] = new double[N][N]; // height
    double v[][] = new double[N][N]; // velocity
    final double tau = 0.5; // time step size
    final double alpha = 0.985; // damping factor

    int frame = 0;
    Random rnd = new Random();
    BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);

    public static void main(String[] args) {
        Wave m = new Wave();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Wave Simulation");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();
    }

    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;

        double startTime = System.currentTimeMillis();

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;

            // drop random "STONE"
            if (frame % 100 == 0) {
                u[rnd.nextInt(N)][rnd.nextInt(N)] = -1;
            }

            // update velocity
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int i0 = (i + N - 1) % N; // left
                    int i1 = (i + N + 1) % N; // right
                    int j0 = (j + N - 1) % N; // down
                    int j1 = (j + N + 1) % N; // up

                    v[i][j] += tau * (u[i0][j] + u[i1][j] + u[i][j0] + u[i][j1] - 4 * u[i][j]);
                    v[i][j] *= alpha; // damping
                }
            }

            // update height
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    u[i][j] += tau * v[i][j];
                }
            }

            repaint();

            lastTime = currentTime;

            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                System.err.println(e);
            }

            frame++;
        }
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int colour = (int) ((u[i][j] + 0.01) / 0.02 * 255);

                colour = (colour < 0) ? 0 : colour;
                colour = (colour > 255) ? 255 : colour;
                buffer.setRGB(i, j, new Color(colour, colour, colour).getRGB());
            }
        }

        g.drawImage(buffer, 0, 0, null);
    }
}
