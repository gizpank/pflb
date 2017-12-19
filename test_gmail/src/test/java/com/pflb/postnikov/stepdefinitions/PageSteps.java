package com.pflb.postnikov.stepdefinitions;

import com.pflb.postnikov.pages.LoginPage;
import com.pflb.postnikov.pages.LogoutPage;
import com.pflb.postnikov.pages.MailboxPage;
import cucumber.api.java.ru.*;
import org.testng.Assert;

public class PageSteps {

    private LoginPage loginPage = new LoginPage();

    @Пусть("^пользователь вводит логин '(.+)'$")
    public void fillLogin(String login) {
        loginPage.fillLoginField(login);
    }

    @И("^нажимает кнопку Далее$")
    public void clickEnterButton() {
        loginPage.clickNextButton();
    }

    @И("^вводит пароль '(.+)'$")
    public void fillPassword(String pass) throws InterruptedException {
        loginPage.fillPasswordField(pass);
    }

    private MailboxPage mailboxPage = new MailboxPage();

    @Тогда("^пользователь '(.+)' авторизован$")
    public void checkForUserAuthenticated(String userName) {
        Assert.assertTrue(mailboxPage.getAccountButtonTitle().contains(userName));
    }

    @Пусть("^пользователь нажимает кнопку Написать$")
    public void clickNewMessage() {
        mailboxPage.clickNewMessageButton();
    }

    @Тогда("^всплывает окно Новое сообщение$")
    public void checkCreateNewMessage() {
        Assert.assertTrue(mailboxPage.checkCreateNewMessage());
    }

    @И("^пользователь вводит в поле Адресат '(.+)'$")
    public void fillRecipient(String recipient) {
        mailboxPage.fillNewMessageRecipient(recipient);
    }

    @И("^вводит в поле Тема '(.+)'$")
    public void fillTheme(String theme) {
        mailboxPage.fillNewMessageTheme(theme);
    }

    @И("^вводит в теле письма '(.+)'$")
    public void fillBody(String body) {
        mailboxPage.fillNewMessageBody(body);
    }

    @И("^нажимает кнопку Сохранить и закрыть$")
    public void clickNewMessageClose() {
        mailboxPage.clickNewMessageCloseButton();
    }

    @И("^пользователь переходит в пункт меню Черновики$")
    public void clickDrafts() {
        mailboxPage.clickDraftsLink();
    }

    @Тогда("созданное письмо отображается в списке Черновики")
    public void checkNewMessageInDraftsList() {
        Assert.assertTrue(mailboxPage.checkNewMessageInDrafts());
    }

    @Если("^пользователь открывает новый черновик$")
    public void clickNewMessageInDrafts() {
        mailboxPage.clickNewMessageInDraftsList();
    }

    @То("^черновик открывается$")
    public void checkOpenDraft() {
        Assert.assertTrue(mailboxPage.checkCreateNewMessage());
    }

    //    срабатывает не всегда
//    selenium.StaleElementReferenceException: The element reference of <span> stale:
//    either the element is no longer attached to the DOM or the page has been refreshed
    @И("^поля черновика сохранены корректно$")
    public void checkDraft() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(mailboxPage.checkDraftFields());
    }

    @Пусть("^пользователь нажимает кнопку Отправить$")
    public void SendMessage() {
        mailboxPage.clickSendMessageButton();
    }

    @Тогда("^письмо корректно отправляется$")
    public void checkSendMessage() {
        Assert.assertTrue(mailboxPage.submitSendMessage());
    }

    @Тогда("^отправленное письмо не отображается в списке Черновики$")
    public void checkSendMessageInDrafts() {
        Assert.assertFalse(mailboxPage.checkNewMessageInDrafts());
    }

    @Пусть("^пользователь переходит в пункт меню Отправленные$")
    public void clickSent() {
        mailboxPage.clickSentLink();
    }

    @Тогда("^отправленное письмо отображается в списке Отправленные$")
    public void checkSendMessageInSentList() {
        Assert.assertTrue(mailboxPage.checkSendMessageInSent());
    }

    @Пусть("^пользователь нажимает кнопку Аккаунт$")
    public void clickAccountButton() {
        mailboxPage.clickAccountButton();
    }

    @И("^нажимает кнопку Выйти$")
    public void clickLogoutButton() {
        mailboxPage.clickLogoutButton();
    }

    private LogoutPage logoutPage = new LogoutPage();

    @Тогда("^происходит корректный выход из почты$")
    public void submitLogout() {
        Assert.assertTrue(logoutPage.submitLogout());
        AbstractTest.tearDown();
    }
}
