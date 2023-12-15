import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Computer Graphic.lab.02-lab.Exercise_3;

public class Exercise_3Test {

    @Test
    public void testBresenhamLine_samePoints() {
        Exercise_3 panel = new Exercise_3();
        panel.BresenhamLine(100, 100, 100, 100);
        assertEquals(1, panel.points.size());
        assertEquals(100, panel.points.get(0).x);
        assertEquals(100, panel.points.get(0).y);
    }

    @Test
    public void testBresenhamLine_horizontalLine() {
        Exercise_3 panel = new Exercise_3();
        panel.BresenhamLine(100, 100, 200, 100);
        assertEquals(101, panel.points.size());
        for (Exercise_3.Point point : panel.points) {
            assertEquals(100, point.y);
        }
    }

    @Test
    public void testBresenhamLine_verticalLine() {
        Exercise_3 panel = new Exercise_3();
        panel.BresenhamLine(100, 100, 100, 200);
        assertEquals(101, panel.points.size());
        for (Exercise_3.Point point : panel.points) {
            assertEquals(100, point.x);
        }
    }

    @Test
    public void testBresenhamLine_diagonalLine() {
        Exercise_3 panel = new Exercise_3();
        panel.BresenhamLine(100, 100, 200, 200);
        assertEquals(101, panel.points.size());
        for (int i = 0; i < panel.points.size(); i++) {
            assertEquals(100 + i, panel.points.get(i).x);
            assertEquals(100 + i, panel.points.get(i).y);
        }
    }
}
