package com.pflb.postnikov.stepdefinitions;

import com.pflb.postnikov.helpers.DriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "src/test/resources/features",
        glue = "stepdefinitions"
)
public class AbstractTest extends AbstractTestNGCucumberTests {

    @AfterTest
    public static void tearDown() {
        System.out.println("Closing driver...");
        DriverManager.closeDriver();
    }
}
