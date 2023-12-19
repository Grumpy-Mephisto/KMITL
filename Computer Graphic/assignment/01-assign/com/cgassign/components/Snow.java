package com.cgassign.components;

import com.cgassign.function.Line;

import java.awt.*;
import java.util.Random;

public class Snow {
    private Line line = new Line();

    public void draw(Graphics2D g2d, int width, int height) {
        Random r = new Random();
        int SnowballsBlurLevel = 5;
        int SnowballsRadius = 3;
        int SnowballsAmount = 100;

        for (int i = 0; i < SnowballsAmount; i++) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);

            // Check if position is not at the edge
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
    }
}
