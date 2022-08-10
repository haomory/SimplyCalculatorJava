package com.haomory.simplyCalculator.logic;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public ScriptEngine getEngine() {
        ScriptEngineManager mgr = new ScriptEngineManager();
        return mgr.getEngineByName("JavaScript");
    }

    public static String getProperty(String config) {
        String pathToConfig = "src/com/haomory/simplyCalculator/config.properties";

        try(InputStream inputStream = new FileInputStream(pathToConfig)) {
            Properties property = new Properties();
            property.load(inputStream);

            return property.getProperty(config);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
