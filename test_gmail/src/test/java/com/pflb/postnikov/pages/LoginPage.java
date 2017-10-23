package com.pflb.postnikov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    @FindBy(css = "#identifierId")
    private WebElement loginField;

    @FindBy(css = ".RveJvd")
    private WebElement loginNextButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div/div[3]/div[1]/div[1]/div/div[1]/div/div[1]/input")
    //@FindBy(css = "#password > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    private WebElement passwordField;

//    @FindBy(id = "login-button")
//    private WebElement submitButton;
//
//    @FindBy(id = "login-failed")
//    private WebElement logonInvalidMessage;

    private String BASE_URL = "http://mail.google.com";

    public LoginPage() {
        super();
        driver.get(BASE_URL);
    }

    public void fillLoginField(String login) {
        loginField.clear();
        loginField.sendKeys(login);
    }

    public  void clickNextButton() {
        loginNextButton.click();
    }

    public void fillPasswordField(String password) throws InterruptedException {
        Thread.sleep(1000);
        passwordField.clear();
        passwordField.sendKeys(password);
    }
}
