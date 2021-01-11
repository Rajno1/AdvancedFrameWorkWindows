package com.issi.listeners;

import com.issi.constants.FrameWorkConstants;
import com.issi.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    // this MethodInterceptor class will execute only once for entari suite
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        /* the 'method' argument of 'List<IMethodInstance>' will contain all test that TestNG goint to execute
        in below line we have created a result object to customise to run only perticular
        test case at runtime
        Note: if you want to execute all testcases without any interrupt directly you can return method
         */
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();

        List<Map<String,String>> testList = ExcelUtils.getTestDetails(FrameWorkConstants.getRunManagerSheet());
        // to compare List<IMethodInstance> test with our testList from excel we are writing for loop now
        for (int i=0;i< methods.size();i++){ // method list from List<IMethodInstance>
            for (int j=0;j<testList.size();j++){ // list of testmethods form execl
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(testList.get(j).get("testname")) &&
                    testList.get(j).get("execute").equalsIgnoreCase("yes")){
                        methods.get(i).getMethod().setDescription(testList.get(j).get("testdescription"));
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(testList.get(j).get("count")));
                        methods.get(i).getMethod().setPriority(Integer.parseInt(testList.get(j).get("priority")));
                        result.add(methods.get(i));
                    }
            }
        }
        return result;
    }
}
