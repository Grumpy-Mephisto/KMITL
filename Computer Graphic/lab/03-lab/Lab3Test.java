import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Lab3Test {

    @Test
    public void testBezierpve() {
        Lab3 lab3 = new Lab3();
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        lab3.Bezierpve(g2d, 0, 0, 25, 25, 75, 75, 100, 100);
        // Check some points on the curve
        assertEquals(new Color(image.getRGB(0, 0)), Color.BLACK);
        assertEquals(new Color(image.getRGB(50, 50)), Color.BLACK);
        assertEquals(new Color(image.getRGB(100, 100)), Color.BLACK);
    }

    @Test
    public void testFloodFill() {
        Lab3 lab3 = new Lab3();
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 100, 100);
        lab3.floodFill(image, 50, 50, Color.BLACK, Color.WHITE);
        // Check that the entire image is now white
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                assertEquals(new Color(image.getRGB(x, y)), Color.WHITE);
            }
        }
    }
}
