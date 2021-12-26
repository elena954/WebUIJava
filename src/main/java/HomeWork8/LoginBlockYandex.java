package HomeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginBlockYandex {

    private SelenideElement loginInput = $(By.id("passp-field-login"));

    @Step("Заполнить логин")
    public LoginBlockYandex fillLoginInput(String login){
     loginInput.sendKeys(login);
     return this;
    }

    private SelenideElement sumbitLoginButton = $(By.id("passp:sign-in"));

    @Step("Нажать на кнопку войти")
    public PasswordBlockYandex submitLogin(){
        sumbitLoginButton.click();
        return page(PasswordBlockYandex.class);
    }

}
