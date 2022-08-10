package com.haomory.simplyCalculator.view;

import java.awt.*;

public class AppFonts {
    private Font operationsFont;
    private Font numberFont;

    public AppFonts() {
        operationsFont = new Font("impact", Font.BOLD,35);
        numberFont = new Font("impact", Font.BOLD, 30);
    }

    public Font getNumberFont() {
        return numberFont;
    }

    public void setNumberFont(Font numberFont) {
        this.numberFont = numberFont;
    }

    public Font getOperationsFont() {
        return operationsFont;
    }

    public void setOperationsFont(Font operationsFont) {
        this.operationsFont = operationsFont;
    }
}
