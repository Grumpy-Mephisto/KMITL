package com.assignment.utils;

import java.awt.Color;
import java.awt.GradientPaint;

/**
 * คลาส ColorTool จะเป็นคลาสที่ใช้สำหรับสร้าง GradientPaint และแปลงสีจาก Hexadecimal ให้เป็น Color
 */
public class ColorTool {
    private ColorTool() {
        throw new IllegalStateException("Utility class");
    }

    public static GradientPaint createGradient(Color[] colors, boolean cyclic) {
        return new GradientPaint(0, 0, colors[0], 0, 600, colors[colors.length - 1], cyclic);
    }

    public static Color hexToColor(String hex) {
        return Color.decode(hex);
    }
}
