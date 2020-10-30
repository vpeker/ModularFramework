package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    // if any element is static we can add them into at CacheLookUp.
    // This enhance the performance so it will not search for this element again.
    @CacheLookup

     @FindBy(name="uid")
    private WebElement userId;

    @FindBy(name="password")
    private WebElement userPassword;

    @FindBy(name="btnLogin")
    private WebElement loginButton;



    public LoginPage(WebDriver driver){
        super(driver);  // calling explicit constructor
        PageFactory.initElements(driver,this);


    }
    public void loginToApplication(String username, String password){
        elementControl.setText(userId,username);
        elementControl.setText(userPassword,password);
        elementControl.clickElement(loginButton);
    }
}

/*
// pageFactory for initilize all this element in this page
        //benefit of using page factory is all those elements which are dynamic elements which loads
        //late on the page like when we we scroll down or any other operations.
        //if we initialize the normal way that is using driver.findElement they will throw an exception
        //called element not found exception if they are not found at that moment
        //but if we are using page factory , they will not throw any exception
        //rather this page factory ,how to initlize that your driver instance will search for those element when at that time off.

        //interaction not only at the time of initalization.
 */
