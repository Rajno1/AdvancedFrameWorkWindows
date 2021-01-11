package com.issi.listeners;

import com.issi.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationTransformer implements IAnnotationTransformer {
     // This Annotation Transformer will be called each time when your test method is called
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataProviderUtils.class);
      //  annotation.setRetryAnalyzer(RetryFailedTests.class);  // to retry failed tests
        //if we dont want to execute perticular test
//        if (testMethod.getName().equalsIgnoreCase("loginLogoutTest")){
//            annotation.setEnabled(false);
//        }

//        Map<String,Object> testOne= new HashMap<>(); // using this object we can read data from excel
//        testOne.put("name","loginLogoutTest");
//        testOne.put("count","2"); // invocation count
//        testOne.put("enabled",true);
//
//        List<Map<String, Object>> testList = new ArrayList<>();
//        testList.add(testOne);
//
//        for (int i=0;i<testList.size();i++){
//            if (testMethod.getName().equalsIgnoreCase(String.valueOf(testList.get(i).get("name")))){
//                if (testList.get(i).get("enabled").equals(false)){
//                    annotation.setEnabled(false);
//                }else {
//                    annotation.setInvocationCount(Integer.parseInt((String) testList.get(i).get("count")));
//                }
//            }
//        }

    }
}
