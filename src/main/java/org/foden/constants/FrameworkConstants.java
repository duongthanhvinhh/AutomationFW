package org.foden.constants;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/executables/chromedriver.exe";
    private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";

    private static final String URL = "https://google.com";
    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }

}
