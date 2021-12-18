package HomeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static HomeWork6.YandexMailPage.returnToInbox;

public class DeleteAllEmailsOnThisPage extends BaseViewYandex{

    public DeleteAllEmailsOnThisPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = returnToInbox)
    private WebElement goBackToTheInboxPage;

    public DeleteAllEmailsOnThisPage goBackToTheInboxPageYandex(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(returnToInbox)));
        goBackToTheInboxPage.click();
        return this;
    }

    @FindBy(xpath = "//span[.='Отправленные']")
    private WebElement logInToSentEmails;

    public DeleteAllEmailsOnThisPage logInToSent(){
        logInToSentEmails.click();
        return this;
    }

    private final static String highlight = "//div[@title='Выделить все письма']";
    @FindBy(xpath = highlight)
    private WebElement selectAll;

    public DeleteAllEmailsOnThisPage selectAllEmails(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(highlight)));
        selectAll.click();
        return this;
    }

    private final static String delete = "//div[@title='Удалить (Delete)']";
    @FindBy(xpath = delete)
    private WebElement deleteEmails;

    public DeleteAllEmailsOnThisPage deleteSentEmails(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(delete)));
        deleteEmails.click();
        return this;
    }
}
