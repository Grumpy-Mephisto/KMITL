package com.cgassign.components;

import java.awt.*;
import com.cgassign.functions.Triangle;

public class Tree {
    private Triangle triangle = new Triangle();

    public void draw(Graphics2D g2d, int width, int height) {
        int TreeLayers = 3;
        int TreeTriangleHeight = height / (TreeLayers + 1);

        for (int i = 0; i < TreeLayers; i++) {
            int TreeTriangleWidth = width / (i + 2);
            int x = (width - TreeTriangleWidth) / 2;
            int y = height - (i + 1) * TreeTriangleHeight;

            // Gradient color
            GradientPaint TreeGradientColor = new GradientPaint(x, y, Color.decode("#004d00"),
                    x + TreeTriangleWidth / 2, y + TreeTriangleHeight, Color.decode("#00b300"));
            g2d.setPaint(TreeGradientColor);

            // Draw the tree
            int[] xArr = {x, x + TreeTriangleWidth / 2, x + TreeTriangleWidth};
            int[] yArr = {y + TreeTriangleHeight, y / 2, y + TreeTriangleHeight};
            triangle.drawFillPolygonTriangle(g2d, xArr[0], yArr[0], xArr[1], yArr[1], xArr[2],
                    yArr[2]);
        }
    }
}
