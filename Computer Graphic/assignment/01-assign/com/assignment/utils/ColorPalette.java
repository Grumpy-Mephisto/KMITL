package com.assignment.utils;

import java.awt.Color;
import java.awt.GradientPaint;

/**
 * คลาส ColorPalette จะเป็นคลาสที่ใช้เก็บสีพื้นหลังที่ใช้ในโปรแกรม
 */
public class ColorPalette {
    public static final Color BG_COLOR_1 = ColorTool.hexToColor("#0a1960");
    public static final Color BG_COLOR_2 = ColorTool.hexToColor("#192073");
    public static final Color BG_COLOR_3 = ColorTool.hexToColor("#3433a0");
    public static final Color BG_COLOR_4 = ColorTool.hexToColor("#483dbd");
    public static final Color BG_COLOR_5 = ColorTool.hexToColor("#604ede");

    private static final Color[] COLORS =
            {BG_COLOR_1, BG_COLOR_2, BG_COLOR_3, BG_COLOR_4, BG_COLOR_5};

    public static final GradientPaint BACKGROUND_GRADIENT = ColorTool.createGradient(COLORS, false);
}
