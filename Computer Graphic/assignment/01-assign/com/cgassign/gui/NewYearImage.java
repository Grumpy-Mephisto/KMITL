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
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Drawing "NEW YEAR" text using Curves for each character
        g2d.setFont(new Font("Arial", Font.BOLD, 40));
        g2d.setColor(Color.WHITE);
        drawNewYearText(g2d);

        // Drawing balloons using Circles and Triangles for balloon shapes
        drawBalloons(g2d);

        // Drawing a clock using Circles and Lines
        drawClock(g2d);

        // Drawing confetti using Lines for scattered lines
        drawConfetti(g2d);
    }

    private void drawNewYearText(Graphics2D g2d) {
        // Drawing "NEW YEAR" text using Curves for each character
        String text = "HAPPY NEW YEAR";
        int x = 50;
        for (char ch : text.toCharArray()) {
            g2d.setColor(Color.WHITE);
            switch (ch) {
                case 'H':
                    curve.drawBezierCurve(g2d, x, 50, x + 5, 30, x + 10, 50);
                    curve.drawBezierCurve(g2d, x + 10, 50, x + 15, 30, x + 20, 50);
                    line.drawBresenhamLine(g2d, x + 10, 30, x + 10, 50);
                    x += 30;
                    break;
                case 'A':
                    curve.drawBezierCurve(g2d, x, 50, x + 5, 30, x + 10, 50);
                    curve.drawBezierCurve(g2d, x + 10, 50, x + 15, 30, x + 20, 50);
                    line.drawBresenhamLine(g2d, x + 7, 40, x + 13, 40);
                    x += 30;
                    break;
                case 'P':
                    curve.drawBezierCurve(g2d, x, 50, x + 5, 30, x + 10, 50);
                    line.drawBresenhamLine(g2d, x + 10, 30, x + 10, 50);
                    line.drawBresenhamLine(g2d, x, 40, x + 15, 40);
                    x += 20;
                    break;
                case 'Y':
                    curve.drawBezierCurve(g2d, x, 50, x + 5, 40, x + 10, 50);
                    curve.drawBezierCurve(g2d, x + 10, 50, x + 15, 40, x + 20, 50);
                    curve.drawBezierCurve(g2d, x + 10, 50, x + 10, 30, x + 10, 25);
                    x += 30;
                    break;
                case 'N':
                    curve.drawBezierCurve(g2d, x, 50, x + 5, 30, x + 10, 50);
                    curve.drawBezierCurve(g2d, x + 10, 50, x + 15, 30, x + 20, 50);
                    x += 20;
                    break;
                case 'E':
                    curve.drawBezierCurve(g2d, x, 50, x + 15, 30, x, 50);
                    curve.drawBezierCurve(g2d, x, 50, x + 15, 50, x, 30);
                    x += 20;
                    break;
                case 'W':
                    curve.drawBezierCurve(g2d, x, 50, x + 5, 30, x + 10, 50);
                    curve.drawBezierCurve(g2d, x + 10, 50, x + 15, 30, x + 20, 50);
                    curve.drawBezierCurve(g2d, x + 20, 50, x + 25, 30, x + 30, 50);
                    x += 30;
                    break;
                case 'R':
                    curve.drawBezierCurve(g2d, x, 50, x + 5, 30, x + 10, 50);
                    curve.drawBezierCurve(g2d, x + 10, 50, x + 15, 30, x + 20, 50);
                    line.drawBresenhamLine(g2d, x + 7, 40, x + 13, 40);
                    line.drawBresenhamLine(g2d, x + 10, 30, x + 20, 30);
                    x += 30;
                    break;
            }
        }
    }

    private void drawBalloons(Graphics2D g2d) {
        // Drawing balloons using Circles and Triangles for balloon shapes
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int x = rand.nextInt(getWidth() - 50);
            int y = rand.nextInt(getHeight() - 150) + 100;
            int size = rand.nextInt(40) + 20;

            g2d.setColor(Color.RED);
            circle.drawCircle(g2d, x, y, size);

            g2d.setColor(Color.GREEN);
            triangle.drawFillPolygonTriangle(g2d, x - size / 2, y - size / 2, x + size / 2,
                    y - size / 2, x, y - size);

            g2d.setColor(Color.BLUE);
            triangle.drawFillPolygonTriangle(g2d, x, y - size, x - size / 4, y - size * 3 / 2,
                    x + size / 4, y - size * 3 / 2);
        }
    }

    private void drawClock(Graphics2D g2d) {
        // Drawing a clock using Circles and Lines
        g2d.setColor(Color.WHITE);
        circle.drawCircle(g2d, 400, 300, 100);

        g2d.setStroke(new BasicStroke(3));
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians(i * 30);
            int x1 = (int) (400 + 80 * Math.cos(angle));
            int y1 = (int) (300 + 80 * Math.sin(angle));
            int x2 = (int) (400 + 90 * Math.cos(angle));
            int y2 = (int) (300 + 90 * Math.sin(angle));
            line.drawBresenhamLine(g2d, x1, y1, x2, y2);
        }

        g2d.setStroke(new BasicStroke(5));
        double angle = Math.toRadians(30 * 5);
        int x = (int) (400 + 60 * Math.cos(angle));
        int y = (int) (300 + 60 * Math.sin(angle));
        line.drawBresenhamLine(g2d, 400, 300, x, y);
    }

    private void drawConfetti(Graphics2D g2d) {
        // Drawing confetti using Lines for scattered lines
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int x1 = rand.nextInt(getWidth());
            int y1 = rand.nextInt(getHeight());
            int x2 = rand.nextInt(getWidth());
            int y2 = rand.nextInt(getHeight());
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            g2d.setColor(new Color(r, g, b));
            line.drawBresenhamLine(g2d, x1, y1, x2, y2);
        }
    }
}
