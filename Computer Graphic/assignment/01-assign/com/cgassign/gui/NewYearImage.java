package com.cgassign.gui;

import com.cgassign.function.*;
import com.cgassign.components.*;

import java.awt.*;
import javax.swing.*;

public class NewYearImage extends JPanel {
    // private Line line = new Line();
    // private Curve curve = new Curve();
    // private Circle circle = new Circle();
    // private Triangle triangle = new Triangle();

    private Snow Snow = new Snow();
    private Tree ChristmasTree = new Tree();


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for smoother shapes
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background color
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Snow
        Snow.draw(g2d, getWidth(), getHeight());

        // Tree
        ChristmasTree.draw(g2d, getWidth(), getHeight());
    }
}
