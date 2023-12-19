package com.cgassign.gui;

import com.cgassign.function.*;

import javax.swing.*;
import java.awt.*;

public class NewYearImage extends JPanel {
    private Line line = new Line();
    private Curve curve = new Curve();
    private Triangle triangle = new Triangle();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Example usage of drawing functionalities

        // Drawing a line
        line.drawBresenhamLine(g, 50, 50, 200, 100);
        // Drawing a Bezier curve
        curve.drawBezierCurve(g, 50, 150, 150, 250, 250, 150);
        // Drawing a filled triangle
        triangle.drawFillPolygonTriangle(g, 300, 50, 450, 150, 350, 250);
    }
}
