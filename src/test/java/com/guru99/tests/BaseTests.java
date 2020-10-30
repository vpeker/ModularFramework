package com.guru99.tests;

import com.guru99.pages.LoginPage;
import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class BaseTests {

    CommonDriver commonDriver;
    String url;
    WebDriver driver;
    LoginPage loginPage;
    String currentWorkingDirectory;
    Properties configProperty;
    String configFileName;


    @BeforeSuite
    public void preSetup() throws Exception {
        currentWorkingDirectory=System.getProperty("user.dir");
        configFileName=currentWorkingDirectory + "/src/test/java/config.properties";
        configProperty= ConfigUtils.readProperties(configFileName);
    }

    @BeforeClass
    public void setup() throws Exception {
        url=configProperty.getProperty("baseUrl");
        String browserType=configProperty.getProperty("browserType");

        commonDriver=new CommonDriver(browserType);
        driver=commonDriver.getDriver();
        loginPage=new LoginPage(driver);
        commonDriver.navigateToUrl(url);

    }
    @AfterClass
    public void tearDown(){
        commonDriver.closeAllBrowser();
    }
}
