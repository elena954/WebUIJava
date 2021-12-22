package HomeWork6;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class YandexMailPage extends BaseViewYandex {
    public YandexMailPage(WebDriver driver) {
        super(driver);
    }

    private final static String clickOnWrite = "//span[.='Написать']";
    @FindBy(xpath = clickOnWrite)
    private WebElement newEmail;

    @Step("Клик на кнопку написать")
    public YandexMailPage writeANewEmail() {

        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickOnWrite)));
        newEmail.click();
        return this;
    }

    private final static String toWhom = "//div[@class='ComposeRecipients-TopRow']//div[@class='composeYabbles']";
    @FindBy(xpath = toWhom)
    private WebElement toWhomEmail;

    @Step("Заполнить поле <Кому>")
    public YandexMailPage toWhomTheLetter(String email) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toWhom)));
        toWhomEmail.sendKeys(email);
        return this;
    }

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement emailSubject;

    @Step("Заполнить поле <Тема>")
    public YandexMailPage enteringATopic(String topic) {
        emailSubject.sendKeys(topic);
        return this;
    }

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement letteEntryField;

    @Step("Заполнить поле <Напишите что нибудь>")
    public YandexMailPage textInput(String text) {
        letteEntryField.sendKeys(text);
        return this;
    }

    @FindBy(xpath = "//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']")
    private WebElement sendButton;

    @Step("Нажать на кнопку отправить")
    public YandexMailPage sendEmail(){
        sendButton.click();
        return this;
    }

    public final static String returnToInbox = "//a[.='Вернуться во \"Входящие\"']";
    @FindBy(xpath = returnToInbox)
    private WebElement checkAndReturnToInbox;

    @Description("Проверка на успешную отправку нового сообщение")
    public YandexMailPage checkAndReturnToInboxIsDisplayed(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(returnToInbox)));
        assertThat(checkAndReturnToInbox, isDisplayed());
        return this;
    }
}