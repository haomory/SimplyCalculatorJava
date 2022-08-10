package com.haomory.simplyCalculator.view;

import com.haomory.simplyCalculator.logic.Utils;
import jdk.jshell.execution.Util;

import java.util.Objects;

public class WindowSettings {
    private final int width;
    private final int height;
    private final String title;

    public WindowSettings() {
        width = Integer.parseInt(Objects.requireNonNull(Utils.getProperty("windowWidth")));
        height = Integer.parseInt(Objects.requireNonNull(Utils.getProperty("windowHeight")));
        title = Utils.getProperty("windowTitle");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }
}
