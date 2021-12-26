import HomeWork8.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class Yandex {
    @Given("Пользователь авторизован")
    public void userAuthorization(){
        open("https://yandex.ru");
        new MainPageYandex()
                .clickLoginButton();
        new LoginBlockYandex()
                .fillLoginInput("len4ik359")
                .submitLogin();
        new PasswordBlockYandex()
                .fillPasswordInput("a3088a")
                .submitPassword();
        new MainPageYandex()
                .entrance();
    }
    @When("Я кликаю на кнопку написвать")
    public void iClickOnTheWriteButton() {
        new YandexMailPage()
                .writeANewEmail();
    }

    @And("Я заполняю поля Кому, Тема, Написать что-нибудь")
    public void iFillInTheFieldsToWhomTheSubjectWriteSomething() {
        new YandexMailPage()
                .toWhomTheLetter("Len4ik.kmx@gmail.com")
                .enteringATopic("Test1")
                .textInput("Hello my friend");
    }

    @And("Я кликаю отправить")
    public void iClickSend() {
        new YandexMailPage()
                .sendEmail();
    }

    @And("Я вижу что сообщение отправилось")
    public void iSeeThatTheMessageHasBeenSent() {
        new YandexMailPage()
                .checkAndReturnToInboxIsDisplayed();
    }

    @And("Я кликаю на кнопку отправленные")
    public void iClickOnTheSentButton() {
        new DeleteAllEmailsOnThisPage()
                .goBackToTheInboxPageYandex()
                .logInToSent();
    }

    @And("Я выделяю все сообщения")
    public void iHighlightAllMessages() {
        new DeleteAllEmailsOnThisPage()
                .selectAllEmails();
    }

    @Then("Я удаляю все сообщения")
    public void iAmDeletingAllMessages() {
        new DeleteAllEmailsOnThisPage()
                .deleteSentEmails();
    }
}
