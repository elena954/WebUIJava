package HomeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBlockYandex extends BaseViewYandex {

    public LoginBlockYandex(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "passp-field-login")
    private WebElement loginInput;

    @Step("Заполнить логин")
    public LoginBlockYandex fillLoginInput(String login){
     loginInput.sendKeys(login);
     return this;
    }

    @FindBy(id = "passp:sign-in")
    private WebElement sumbitLoginButton;

    @Step("Нажать на кнопку войти")
    public PasswordBlockYandex submitLogin(){
        sumbitLoginButton.click();
        return new PasswordBlockYandex(driver);
    }

}
