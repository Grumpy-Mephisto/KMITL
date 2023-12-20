package com.cgassign.functions;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.RenderingHints;

public class Curve {
    public void drawBezierCurve(Graphics g, Point p0, Point p1, Point p2, Point p3) {
        if (p0 != null && p1 != null && p2 != null && p3 != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            Path2D.Double path = new Path2D.Double();
            path.moveTo(p0.getX(), p0.getY());

            for (double t = 0.0; t <= 1.0; t += 0.001) {
                double oneMinusT = 1 - t;
                double oneMinusTSquared = oneMinusT * oneMinusT;
                double tSquared = t * t;

                double x = oneMinusT * oneMinusT * oneMinusT * p0.getX()
                        + 3 * oneMinusT * oneMinusTSquared * p1.getX()
                        + 3 * oneMinusTSquared * t * p2.getX() + tSquared * t * p3.getX();

                double y = oneMinusT * oneMinusT * oneMinusT * p0.getY()
                        + 3 * oneMinusT * oneMinusTSquared * p1.getY()
                        + 3 * oneMinusTSquared * t * p2.getY() + tSquared * t * p3.getY();

                path.lineTo(x, y);
            }

            g2d.draw(path);
        }
    }
}
