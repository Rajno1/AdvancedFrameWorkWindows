package com.issi.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.issi.constants.FrameWorkConstants;
import com.issi.enums.ConfigProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonUtils {
    /**
     * This class is created as an example to show that
     * we can use json instead of property file in framework
     */

    private JsonUtils() {
    }

    private static Map<String, String> CONFIGMAP = new HashMap<>();

    // here we are using static block
    static {
        try {
            // Here we are reading property file , enter the path of your json file
           CONFIGMAP  = new ObjectMapper().readValue(new File(FrameWorkConstants.getConfigJsonFilePath()),
                   new TypeReference<HashMap<String, String>>() {});

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
}
