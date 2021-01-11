package com.issi.utils;

import com.issi.constants.FrameWorkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {
    // we are making Dataprovider is common for all test in this frame work by reading all values from excel in the form of List<Map>

   private static List<Map<String,String>> list = new ArrayList<>();
    @DataProvider(parallel = false)
    public static Object[] getData(Method method){
        String testname = method.getName(); // this will give me the method name , which is calling this dataprovider
        if (list.isEmpty()){
            list= ExcelUtils.getTestDetails(FrameWorkConstants.getIterationDataSheet());
        }

        List<Map<String,String>> smallList = new ArrayList<>(); // this will have only details about test method that is calling this dataprovider

        for (int i=0;i<list.size();i++){
            if (list.get(i).get("testname").equalsIgnoreCase(testname) &&
                list.get(i).get("execute").equalsIgnoreCase("yes")){
                    smallList.add(list.get(i)); //if it satisfy above two condition then we are adding Map here.
                }
            }
        return smallList.toArray(); // converting list to object array
    }
}
