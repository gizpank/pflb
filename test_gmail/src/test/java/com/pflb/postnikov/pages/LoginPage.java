package com.pflb.postnikov.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(css = "#identifierId")
    private WebElement loginField;

    @FindBy(css = ".RveJvd")
    private WebElement loginNextButton;

    @FindBy(name = "password")
    private WebElement passwordField;

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
