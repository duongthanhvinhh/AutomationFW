package org.foden.constants;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/executables/chromedriver.exe";
    private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
    private static final String JSONFILEPATH = RESOURCEPATH + "/config/config.json";
    private static final int EXPLICITWAIT = 10;
    public static int getExplicitwait(){
        return EXPLICITWAIT;
    }

    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }
    public static String getJsonfilepath(){
        return JSONFILEPATH;
    }

}
