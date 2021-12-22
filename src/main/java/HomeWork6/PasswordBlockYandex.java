package HomeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordBlockYandex extends BaseViewYandex{

    public PasswordBlockYandex(WebDriver driver) {
        super(driver);
    }

    private final static String passwordInputLocatorById = "passp-field-passwd";
    @FindBy(id = passwordInputLocatorById)
    private WebElement passwordInput;

    @Step("Заполнить пароль")
    public PasswordBlockYandex fillPasswordInput(String password){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(passwordInputLocatorById)));
        passwordInput.sendKeys(password);
        return this;
    }

    @FindBy(id = "passp:sign-in")
    private WebElement sumbitPasswordButton;

    @Step("Нажать кнопку войти")
    public MainPageYandex submitPassword(){
        sumbitPasswordButton.click();
        return new MainPageYandex(driver);
    }
}
