package HomeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class YandexMailPage {

    private SelenideElement newEmail = $(By.xpath("//span[.='Написать']"));

    @Step("Клик на кнопку написать")
    public YandexMailPage writeANewEmail() {

        switchTo().window(1);

        newEmail.click();
        return this;
    }

    private SelenideElement toWhomEmail =
            $(By.xpath("//div[@class='ComposeRecipients-TopRow']//div[@class='composeYabbles']"));

    @Step("Заполнить поле <Кому>")
    public YandexMailPage toWhomTheLetter(String email) {
        toWhomEmail.sendKeys(email);
        return this;
    }

    private SelenideElement emailSubject = $(By.xpath("//input[@name='subject']"));

    @Step("Заполнить поле <Тема>")
    public YandexMailPage enteringATopic(String topic) {
        emailSubject.sendKeys(topic);
        return this;
    }

    private SelenideElement letteEntryField = $(By.xpath("//div[@role='textbox']"));

    @Step("Заполнить поле <Напишите что нибудь>")
    public YandexMailPage textInput(String text) {
        letteEntryField.sendKeys(text);
        return this;
    }

    private SelenideElement sendButton =
            $(By.xpath("//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']"));

    @Step("Нажать на кнопку отправить")
    public YandexMailPage sendEmail(){
        sendButton.click();
        return this;
    }

    private SelenideElement checkAndReturnToInbox = $(By.xpath("//a[.='Вернуться во \"Входящие\"']"));

    @Description("Проверка на успешную отправку нового сообщение")
    public YandexMailPage checkAndReturnToInboxIsDisplayed(){
        checkAndReturnToInbox.shouldBe(visible);
        return this;
    }
}