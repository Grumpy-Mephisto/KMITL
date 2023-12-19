package com.cgassign.function;

import java.awt.Graphics;

public class Curve {
    public void drawBezierCurve(Graphics g, int x0, int y0, int x1, int y1, int x2, int y2) {
        double t;
        int x, y;

        for (t = 0.0; t <= 1.0; t += 0.001) {
            x = (int) (Math.pow(1 - t, 2) * x0 + 2 * t * (1 - t) * x1 + Math.pow(t, 2) * x2);
            y = (int) (Math.pow(1 - t, 2) * y0 + 2 * t * (1 - t) * y1 + Math.pow(t, 2) * y2);
            g.drawLine(x, y, x, y);
        }
    }
}
