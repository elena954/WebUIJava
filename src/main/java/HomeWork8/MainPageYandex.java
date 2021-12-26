package HomeWork8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPageYandex {
    private SelenideElement loginButton = $(By.xpath("//div[.='Войти']"));

    @Step("Клик на кнопку Логин")
    public MainPageYandex clickLoginButton(){
        loginButton.click();
        return this;
    }

    private SelenideElement logInToTheMail = $(By.xpath("//div[.='Почта']"));

    @Step("Клик на кнопку почту")
    public YandexMailPage entrance(){
        logInToTheMail.click();
        return page(YandexMailPage.class);
    }
}
