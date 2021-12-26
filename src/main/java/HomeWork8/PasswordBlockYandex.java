package HomeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PasswordBlockYandex {

    private SelenideElement passwordInput = $(By.id("passp-field-passwd"));

    @Step("Заполнить пароль")
    public PasswordBlockYandex fillPasswordInput(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    private SelenideElement sumbitPasswordButton = $(By.id("passp:sign-in"));

    @Step("Нажать кнопку войти")
    public MainPageYandex submitPassword(){
        sumbitPasswordButton.click();
        return page(MainPageYandex.class);
    }
}
