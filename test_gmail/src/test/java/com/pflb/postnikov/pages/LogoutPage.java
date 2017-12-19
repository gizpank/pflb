package com.pflb.postnikov.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends AbstractPage {

    @FindBy(css = "#forgotPassword")
    private WebElement logoutForgotPasswd;

    public boolean submitLogout() {
        return logoutForgotPasswd.getText().contains("Забыли пароль?");
    }
}
