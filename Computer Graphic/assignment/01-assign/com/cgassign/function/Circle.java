package com.cgassign.function;

import java.awt.Graphics;

public class Circle {
    public void drawCircle(Graphics g, int x, int y, int radius) {
        int diameter = radius * 2;
        g.drawOval(x - radius, y - radius, diameter, diameter);
    }
}
