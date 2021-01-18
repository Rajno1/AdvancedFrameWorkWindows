package com.issi.utils;

import com.issi.constants.FrameWorkConstants;
import com.issi.enums.ConfigProperties;
import com.issi.exceptions.ReadPropertyFileException;

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

    /* Here we are using static block, to initialize static variables,
       this block will get execute when the class is loaded in the memory */
    static {
        try ( FileInputStream file = new FileInputStream(FrameWorkConstants.getConfigFilePath())){
            // Here we are fetching all the values from property file
            property.load(file);
            for (Map.Entry<Object,Object> entry: property.entrySet()){  // we are iterating property file
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
                // in above line we are adding property file to the HashMap at line num 18 and for value we are avoiding white spaces using 'trim()'
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0); // it will terminate the program gracefully in satic block if exception raised
        }
    }

    public static String getValue(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            try {
                throw new ReadPropertyFileException("Property name '" + key + "' is not found,please check config.property file");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
