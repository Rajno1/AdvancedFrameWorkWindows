package com.issi.tests;

import com.issi.pages.OrangeHRMLoginPage;
import com.issi.reports.ExtentReport;
import com.issi.utils.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public final class LoginPageTest extends BaseTest {
    /**
     * We have made LoginPageTest class as final and created
     * private constructor to avoid extending & creating object
     * to this class.
     */
    private LoginPageTest() {
    }

    @Test
    public void loginLogoutTest(Map<String,String> data) {

        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username"))
                .enterPassword(data.get("password"))
                .clickLogin()
                .clickWelcome()
                .clickLogOut()
                .get_Title();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }


//    @Test
//    public void newTest(Map<String,String> data) {
//
//        String title = new OrangeHRMLoginPage()
//                .enterUserName(data.get("username"))
//                .enterPassword(data.get("password"))
//                .clickLogin()
//                .clickWelcome()
//                .clickLogOut()
//                .get_Title();
//
//        Assertions.assertThat(title)
//                .isEqualTo("OrangeHRM");
//    }
        // lets make this Data provider is common for all tests
//    @DataProvider(name = "loginData")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"Admin","admin123"},
//              //  {"Admin1","admin123"}
//        };
//    }
}
