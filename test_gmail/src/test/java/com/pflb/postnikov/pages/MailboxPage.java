package com.pflb.postnikov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailboxPage extends AbstractPage{

    private String recipient;
    private String theme;
    private String body;
    private String themeNumber;

    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/a")
    private WebElement accountButton;

    @FindBy(css = ".T-I-KE")
    private WebElement newMessageButton;

    @FindBy(css = ".aYF")
    private WebElement newMessage;

    @FindBy(name = "to")
    private WebElement newMessageRecipient;

    @FindBy (name = "subjectbox")
    private WebElement newMessageTheme;

    @FindBy(xpath = "//div[@class=\"Am Al editable LW-avf\"]" )
    private WebElement newMessageBody;

    @FindBy(xpath = "//img[@class=\"Ha\"]")
    private WebElement newMessageCloseButton;

    public String getAccountButtonTitle() {
        return accountButton.getAttribute("title");
    }

    public void clickNewMessageButton() {
        newMessageButton.click();
    }

    public boolean checkCreateNewMessage() {
        return newMessage.isDisplayed();
    }

    public void fillNewMessageRecipient(String recipient) {
        this.recipient = recipient;
        newMessageRecipient.sendKeys(recipient);
    }

    public void fillNewMessageTheme(String theme) {
        themeNumber = Long.toString(System.currentTimeMillis());
        //для того, чтобы различать письма, добавляем в тему уникальный номер
        this.theme = theme.concat(" №").concat(themeNumber);
        newMessageTheme.sendKeys(this.theme);
    }

    public void fillNewMessageBody(String body) {
        this.body = body;
        newMessageBody.sendKeys(body);
    }

    public void clickNewMessageCloseButton() {
        newMessageCloseButton.click();
    }

    @FindBy(xpath = "//a[@href=\"https://mail.google.com/mail/u/0/#drafts\"]")
    private WebElement draftsLink;

    public void clickDraftsLink() {
        draftsLink.click();
    }

    private WebElement newMessageLink;

//ищем новое сообщение в списке черновиков
    public boolean checkNewMessageInDrafts() {
        try {
            Thread.sleep(1000);
            WebElement newMessageLink = driver.findElement(By.xpath("//span[text()=\"" + theme + "\"]"));
            this.newMessageLink = newMessageLink;
            return newMessageLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickNewMessageInDraftsList() {
        newMessageLink.click();
    }

    @FindBy(xpath = "//div[@class=\"oL aDm az9\"]/span" )
    private WebElement newDraftRecipient;

    @FindBy(xpath = "//input[@name=\"subject\"]" )
    private WebElement newDraftTheme;

    @FindBy(xpath = "//div[@class=\"Am Al editable LW-avf\"]" )
    private WebElement newDraftBody;

    public boolean checkDraftFields() {
        return (newDraftTheme.getAttribute("value").equals(theme) &
                newDraftRecipient.getAttribute("email").equals(recipient) &
                newDraftBody.getText().equals(body));
    }

//определяем кнопку "Отправить"
    @FindBy(xpath = "//div[@class=\"T-I J-J5-Ji aoO T-I-atl L3\"]")
    private  WebElement sendMessageButton;

    public void clickSendMessageButton() {
        sendMessageButton.click();
    }

//подтверждение корректной отправки письма всплывающим сообщением
    public boolean submitSendMessage() {
        WebElement sendMessageSubmitText = driver.findElement(By.xpath("//span[@id=\"link_vsm\"]"));
        return sendMessageSubmitText.getText().equals("Просмотреть сообщение");
    }

    @FindBy(xpath = "//a[@href=\"https://mail.google.com/mail/u/0/#sent\"]")
    private WebElement sentLink;

    public void clickSentLink() {
        sentLink.click();
    }

//ищем новое сообщение в списке отправленных (bold)
    public boolean checkSendMessageInSent() {
        try {
            Thread.sleep(1000);
            WebElement newMessageLink2 = driver.findElement(By.xpath("//span/b[text()=\""+theme+"\"]"));
            return newMessageLink2.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

//выходим из аккаунта
    public void clickAccountButton() {
        accountButton.click();
    }

    @FindBy(xpath = "//a[text()=\"Выйти\"]")
    private WebElement logoutButton;

    public void clickLogoutButton() {
        logoutButton.click();
    }

}
