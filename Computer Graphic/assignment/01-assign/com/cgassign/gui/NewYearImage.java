package com.cgassign.gui;

import com.cgassign.function.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NewYearImage extends JPanel {
    private Line line = new Line();
    private Curve curve = new Curve();
    private Circle circle = new Circle();
    private Triangle triangle = new Triangle();


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for smoother shapes
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color
        g2d.setColor(Color.BLACK);
        line.drawBresenhamLine(g2d, 0, 0, getWidth(), getHeight());

        // Snowball
        Random r = new Random();
        int SnowballsBlurLevel = 5;
        int SnowballsRadius = 3;
        int SnowballsAmount = 100;

        for (int i = 0; i < SnowballsAmount; i++) {
            int x = r.nextInt(getWidth());
            int y = r.nextInt(getHeight());

            // check position it not same position
            if (x == 0 || y == 0) {
                SnowballsAmount++;
                continue;
            }

            Color snowflakeColor = Color.decode("#FFFFFF");
            g2d.setColor(snowflakeColor);

            // Blur effect
            for (int blurLevel = 0; blurLevel < SnowballsBlurLevel; blurLevel++) {
                float transparency = 0.1f + blurLevel * 0.1f;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
                g2d.fillOval(x - blurLevel, y - blurLevel, SnowballsRadius + blurLevel * 2,
                        SnowballsRadius + blurLevel * 2);
            }

            // Glowing effect
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

            // Draw the snowflake
            g2d.setColor(snowflakeColor);
            line.drawBresenhamLine(g2d, x, y, x, y);
            line.drawBresenhamLine(g2d, x, y, x, y);
        }

        // Tree
        int TreeLayers = 3;
        int TreeTriangleHeight = getHeight() / (TreeLayers + 1);

        for (int i = 0; i < TreeLayers; i++) {
            int TreeTriangleWidth = getWidth() / (i + 2);
            int x = (getWidth() - TreeTriangleWidth) / 2;
            int y = getHeight() - (i + 1) * TreeTriangleHeight;

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
