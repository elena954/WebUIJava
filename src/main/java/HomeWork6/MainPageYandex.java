package HomeWork6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPageYandex extends BaseViewYandex {

    @FindBy(xpath = "//div[.='Войти']")
    WebElement loginButton;

    @Step("Клик на кнопку Логин")
    public MainPageYandex clickLoginButton(){
        loginButton.click();
        return this;
    }
    private final static String clickOnTheMail = "//div[.='Почта']";
    @FindBy(xpath = clickOnTheMail)
    private WebElement logInToTheMail;

    @Step("Клик на кнопку почту")
    public YandexMailPage entrance(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickOnTheMail)));
        logInToTheMail.click();
        return new YandexMailPage(driver);
    }

    public MainPageYandex(WebDriver driver) {
        super(driver);
    }
}
