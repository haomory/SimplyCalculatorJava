package com.haomory.simplyCalculator.view;

import com.haomory.simplyCalculator.logic.ButtonsLogic;

import javax.swing.*;
import java.awt.*;

public class WindowComponents {
    private JTextArea TextArea;

    public WindowComponents() {
        TextArea = new JTextArea();
    }

    public void createTextArea(JFrame jFrame) {
        TextArea.setBounds(35, 20, jFrame.getWidth() - 82, 100);
        TextArea.setFont(new Font("IMPACT", Font.BOLD, 60));
        TextArea.setEditable(false);
        jFrame.add(TextArea);
    }

    public void createButtonsPanel(JFrame jFrame) {
        new ButtonsLogic().createButtons(TextArea, jFrame);
    }

    public JTextArea getTextArea() {
        return TextArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.TextArea = textArea;
    }
}
