package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class LoginTests extends BaseTests{
    @Parameters({"username","password"})
    @Test
    public void verifyUserLoginWithCorrectCredentials(String username,String password){

        loginPage.loginToApplication(username,password);
        String expectedTitle="Guru99 Bank Manager HomePage";
        String actualTitle=commonDriver.getTitleofThePage();

        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
