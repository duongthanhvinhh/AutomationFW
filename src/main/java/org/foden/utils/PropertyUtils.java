package org.foden.utils;

import org.foden.constants.FrameworkConstants;
import org.foden.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){}
    private static Properties property = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap<>();
    static {
        try{
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(file);

            for (Map.Entry<Object, Object> entry : property.entrySet()){
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
            }
//            property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
            throw new Exception("Property name: " + key + " was not found. Please check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

}
