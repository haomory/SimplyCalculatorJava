package com.haomory.simplyCalculator.logic;

import com.haomory.simplyCalculator.view.AppFonts;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;

public class ButtonsLogic {
    private int buttonsPanelSize = 4;
    private int buttonsSize = 100;
    private int btnNum = 1, btnYCount = 210;
    private int countOfSpecialSym = 0;
    StringBuilder stringOperations;
    ScriptEngine engine = new Utils().getEngine();
    AppFonts appFonts;

    final Color grey = Color.GRAY, lightGrey = Color.LIGHT_GRAY;

    public ButtonsLogic() {
        stringOperations = new StringBuilder();
        appFonts = new AppFonts();
    }

    public void createButtons(JTextArea jTextArea, JFrame jFrame) {
        for (int i = 0; i < buttonsPanelSize; i++) {
            int btnXCount = 25;

            for (int j = 0; j < buttonsPanelSize; j++) {
                JButton jButton;

                switch (btnNum) {
                    case 4:
                        jButton = new JButton("+");
                        createOneButton(jButton, "+", jTextArea, grey);
                        break;

                    case 8:
                        jButton = new JButton("-");
                        createOneButton(jButton, "-", jTextArea, grey);
                        break;

                    case 12:
                        jButton = new JButton("*");
                        createOneButton(jButton, "*", jTextArea, grey);
                        break;

                    case 16:
                        jButton = new JButton("/");
                        createOneButton(jButton, "/", jTextArea, grey);
                        break;

                    case 14:
                        jButton = new JButton("=");
                        createButton(jButton, grey);

                        jButton.addActionListener(e -> {
                            if (stringOperations.length() != 0) {
                                try {
                                    int answer = ((Number) engine.eval(stringOperations.toString())).intValue();
                                    jTextArea.setText(String.valueOf(answer));
                                    stringOperations.delete(0, stringOperations.length());
                                    stringOperations.append(answer);
                                } catch (ScriptException ex) {
                                    jTextArea.setText("");
                                    stringOperations.delete(0, stringOperations.length());
                                }
                            }
                        });

                        break;

                    case 13:
                        jButton = new JButton("C");
                        createButton(jButton, grey);

                        jButton.addActionListener(e -> {
                            stringOperations.delete(0, stringOperations.length());
                            jTextArea.setText("");
                        });

                        break;

                    case 15:
                        jButton = new JButton("0");
                        jButton.setFont(appFonts.getNumberFont());
                        jButton.setBackground(lightGrey);

                        actionOnClick(jButton, "0", jTextArea);
                        break;

                    default:
                        int number = btnNum - countOfSpecialSym;
                        jButton = new JButton(String.valueOf(number));
                        jButton.setFont(appFonts.getNumberFont());
                        jButton.setBackground(lightGrey);

                        actionOnClick(jButton, String.valueOf(number), jTextArea);
                        break;
                }

                jButton.setBounds(btnXCount, btnYCount, buttonsSize, buttonsSize);
                jFrame.add(jButton);

                btnXCount += buttonsSize + 5;
                btnNum++;
            }

            btnYCount += buttonsSize + 5;
        }
    }

    public void createButton(JButton jButton, Color backgroundColor) {
        jButton.setFont(appFonts.getOperationsFont());
        jButton.setBackground(backgroundColor);
        countOfSpecialSym++;
    }

    public void createOneButton(JButton jButton, String character, JTextArea jTextArea, Color backgroundColor) {
        createButton(jButton, backgroundColor);
        actionOnClick(jButton, character, jTextArea);
    }

    public void actionOnClick(JButton jButton, String character, JTextArea jTextArea) {
        jButton.addActionListener(e -> {
            stringOperations.append(character);
            jTextArea.insert(String.valueOf(character), jTextArea.getCaretPosition());
        });
    }

    public int getButtonsPanelSize() {
        return buttonsPanelSize;
    }

    public void setButtonsPanelSize(int buttonsPanelSize) {
        this.buttonsPanelSize = buttonsPanelSize;
    }

    public int getButtonsSize() {
        return buttonsSize;
    }

    public void setButtonsSize(int buttonsSize) {
        this.buttonsSize = buttonsSize;
    }
}
