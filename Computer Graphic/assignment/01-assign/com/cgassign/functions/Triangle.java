package com.cgassign.functions;

import java.awt.Graphics;

public class Triangle {
    public void drawFillPolygonTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3,
            int y3) {
        int[] xPoints = {x1, x2, x3};
        int[] yPoints = {y1, y2, y3};
        int nPoints = 3;
        g.fillPolygon(xPoints, yPoints, nPoints); // Draw the filled triangle
    }
}
