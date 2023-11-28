package com.assignment.components;

import com.assignment.utils.ColorPalette;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.GradientPaint;

/**
 * การสร้าง BackgroundPanel ที่สืบทอดมาจาก JPanel โดยจะมีการเติมสีพื้นหลังให้กับ JPanel ด้วย
 * GradientPaint ซึ่งจะทำให้สีพื้นหลังของ JPanel มีการเปลี่ยนแปลงสีไปตามที่กำหนด
 */
public class BackgroundPanel extends JPanel {
    @Override
    public Dimension getPreferredSize() {
        return getParent().getSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Dimension size = getParent().getSize();

        GradientPaint gradient = ColorPalette.BACKGROUND_GRADIENT;
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, size.width, size.height);
    }
}
