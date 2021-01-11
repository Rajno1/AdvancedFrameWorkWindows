package com.issi.dataproviderWithJson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.issi.constants.FrameWorkConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderWithJson {
    /**
     * this class is created to show an example, for how to read test data from json file(config.json & config2.json)
     * instead using excel with the help of data provider.
     *
     */
    @Test(dataProvider = "jsontestdata")
    public void testDPWithJson(Map<String,Object> map){

        // iterating map with entery set
        for (Map.Entry<String,Object> m: map.entrySet()){
            System.out.println(m.getKey() + ":" + m.getValue()); // it will print key and value pairs form map
        }
    }

    @DataProvider(name = "jsontestdata")
    public Object[] getData() throws IOException {

        HashMap<String ,Object> map1 = new ObjectMapper() // converting json file to HashMap using jackson dependency
        .readValue(new File(FrameWorkConstants.getConfigJsonFilePath()),
                new TypeReference<HashMap<String,Object>>() {});

        HashMap<String ,Object> map2 = new ObjectMapper() // converting json file to HashMap using jackson dependency
                .readValue(new File(FrameWorkConstants.getCONFIG2JSONFILEPATH()),
                        new TypeReference<HashMap<String,Object>>() {});

        return new Object[]  {map1,map2};
    }
}
