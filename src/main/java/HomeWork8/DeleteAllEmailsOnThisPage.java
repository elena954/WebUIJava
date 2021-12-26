package HomeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DeleteAllEmailsOnThisPage {

    private SelenideElement goBackToTheInboxPage = $(By.xpath("//a[.='Вернуться во \"Входящие\"']"));

    @Step("Клик на кнопку <Вернуться во входящие>")
    public DeleteAllEmailsOnThisPage goBackToTheInboxPageYandex(){
        goBackToTheInboxPage.click();
        return this;
    }

    private SelenideElement logInToSentEmails = $(By.xpath("//span[.='Отправленные']"));

    @Step("Клик на кнопку <Отправленные>")
    public DeleteAllEmailsOnThisPage logInToSent(){
        logInToSentEmails.click();
        return this;
    }

    private SelenideElement selectAll = $(By.xpath("//div[@title='Выделить все письма']"));

    @Step("Клик на кнопку <Выделить все письма>")
    public DeleteAllEmailsOnThisPage selectAllEmails(){
        selectAll.click();
        return this;
    }

    private SelenideElement deleteEmails = $(By.xpath("//div[@title='Удалить (Delete)']"));

    @Step("Клик на кнопку <Удалить>")
    public DeleteAllEmailsOnThisPage deleteSentEmails(){
        deleteEmails.click();
        return this;
    }
}
