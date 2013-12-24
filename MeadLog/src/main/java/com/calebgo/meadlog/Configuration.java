package com.calebgo.meadlog;


/**
 * Application configureation goes here.
 */
public class Configuration {
    private static Configuration ourInstance = new Configuration();

    public static Configuration getInstance() {
        return ourInstance;
    }

    private Configuration() {
    }

    public String globalSharedPrefsName() {
        return "MeadLogPrefs";
    }
}
