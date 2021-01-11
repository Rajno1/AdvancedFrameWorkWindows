package com.issi.utils;

import com.issi.constants.FrameWorkConstants;
import com.issi.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private PropertyUtils() {
    }

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    // here we are using static block
    static {
        try {
            // Here we are fetching all the values from property file
            FileInputStream file = new FileInputStream(FrameWorkConstants.getConfigFilePath());
            property.load(file);

            for (Map.Entry<Object,Object> entry: property.entrySet()){  // we are iterating property file
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
                // in above line we are adding property file to the HashMap at line num 18 and for value we are avoiding white spaces using 'trim()'
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            try {
                throw new Exception("Property name '" + key + "' is not found,please check config.property file");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }


//    public static String getVale(String key) {
//
//        if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
//            try {
//                throw new Exception("Property name '" + key + "' is not found,please check config.property file");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return property.getProperty(key);
//
//    }
}
