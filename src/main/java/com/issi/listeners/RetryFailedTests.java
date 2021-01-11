package com.issi.listeners;

import com.issi.enums.ConfigProperties;
import com.issi.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count =0;
    private int maxretries =1;

    @Override
    public boolean retry(ITestResult result) {
        boolean value=false;
        if(PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("Yes")) {
             value = count < maxretries;
            count++;
        }
        return value;
    }
}
