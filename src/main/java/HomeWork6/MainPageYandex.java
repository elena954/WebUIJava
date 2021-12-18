package HomeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPageYandex extends BaseViewYandex {

    @FindBy(xpath = "//div[.='Войти']")
    WebElement loginButton;

    public MainPageYandex clickLoginButton(){
        loginButton.click();
        return this;
    }
    private final static String clickOnTheMail = "//div[@class='desk-notif-card__mail-title']";
    @FindBy(xpath = clickOnTheMail)
    private WebElement logInToTheMail;

    public YandexMailPage entrance(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickOnTheMail)));
        logInToTheMail.click();
        return new YandexMailPage(driver);
    }

    public MainPageYandex(WebDriver driver) {
        super(driver);
    }
}
