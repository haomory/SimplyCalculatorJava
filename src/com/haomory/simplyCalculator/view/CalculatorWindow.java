package com.haomory.simplyCalculator.view;

import com.haomory.simplyCalculator.logic.Utils;

import javax.swing.*;
import java.awt.*;

public class CalculatorWindow extends JFrame {
    private WindowSettings windowSettings;
    private WindowComponents windowComponents;

    public CalculatorWindow() {
        windowSettings = new WindowSettings();
        windowComponents = new WindowComponents();
    }

    public void launchWindow() {
        setTitle(windowSettings.getTitle());
        Image icon = Toolkit.getDefaultToolkit().getImage(Utils.getProperty("pathToIcon"));
        setIconImage(icon);
        setLayout(null);
        setSize(windowSettings.getWidth(), windowSettings.getHeight());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addComponents(this);

        setVisible(true);
    }

    private void addComponents(JFrame jFrame) {
        windowComponents.createTextArea(jFrame);
        windowComponents.createButtonsPanel(jFrame);
    }

    public WindowSettings getWindowSettings() {
        return windowSettings;
    }

    public void setWindowSettings(WindowSettings windowSettings) {
        this.windowSettings = windowSettings;
    }
}
