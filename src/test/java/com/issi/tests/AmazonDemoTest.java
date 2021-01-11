package com.issi.tests;

import com.issi.annotations.FrameWorkAnnotation;
import com.issi.enums.CategoryType;
import com.issi.enums.ConfigProperties;
import com.issi.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class AmazonDemoTest extends BaseTest {
    private AmazonDemoTest() {
    }

    @FrameWorkAnnotation(author = {"Rajasekhar", "Vinuthna"}, category = {CategoryType.SMOKE, CategoryType.REGRESSION}, device = {"chrome"})
    @Test
    public void amazonTest(Map<String, String> data) {
        String title = new AmazonHomePage()
                .clickHamburger()
                .clickMobileAndComputers()
                .clickOnSubMenuItem(data.get("menutext"))
                .pageTitle();
        Assertions.assertThat(title).isNotNull().isNotBlank();
    }
}
