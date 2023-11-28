package com.assignment.graphics;

import com.assignment.components.BackgroundPanel;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * การสร้าง GraphicPanel ที่สืบทอดมาจาก JPanel โดยจะมีการเติม BackgroundPanel ให้กับ JPanel ด้วย
 * ซึ่งจะทำให้สามารถเปลี่ยนแปลงสีพื้นหลังของ JPanel ได้
 */
public class GraphicPanel extends JPanel {
    private BackgroundPanel backgroundPanel;

    public GraphicPanel() {
        setLayout(new BorderLayout());

        backgroundPanel = new BackgroundPanel();

        add(backgroundPanel, BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        return getParent().getSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
