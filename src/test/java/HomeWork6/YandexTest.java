package HomeWork6;

import Lesson7.CustomLoggerNew;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.Iterator;

@Story("Почта")
public class YandexTest {
    WebDriver driver;
    MainPageYandex mainPageYandex;
    LoginBlockYandex loginBlockYandex;
    PasswordBlockYandex passwordBlockYandex;
    YandexMailPage yandexMailPage;
    DeleteAllEmailsOnThisPage deleteAllEmailsOnThisPage;
    private final static String YANDEX_URL = "https://yandex.ru";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver(){
        driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new ChromeDriver());
        mainPageYandex = new MainPageYandex(driver);
        loginBlockYandex = new LoginBlockYandex(driver);
        passwordBlockYandex = new PasswordBlockYandex(driver);
        yandexMailPage = new YandexMailPage(driver);
        deleteAllEmailsOnThisPage = new DeleteAllEmailsOnThisPage(driver);
        driver.get(YANDEX_URL);
    }

    @Test
    @Description("Тест отправка нового сообщения и удаление всех отправленных")
    void Yandex(){
        new MainPageYandex(driver).clickLoginButton();

        new LoginBlockYandex(driver)
                .fillLoginInput("Len4ik359")
                .submitLogin();

        new PasswordBlockYandex(driver)
                .fillPasswordInput("a3088a")
                .submitPassword();

        new MainPageYandex(driver)
                .entrance();

        new YandexMailPage(driver)
                .writeANewEmail()
                .toWhomTheLetter("Len4ik.kmx@gmail.com")
                .enteringATopic("Test2")
                .textInput("Hello my friend")
                .sendEmail()
                .checkAndReturnToInboxIsDisplayed();

        new DeleteAllEmailsOnThisPage(driver)
                .goBackToTheInboxPageYandex()
                .logInToSent()
                .selectAllEmails()
                .deleteSentEmails();
    }

    @AfterEach
    void tearDown(){
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logs.iterator();

        while (iterator.hasNext()){
            Allure.addAttachment("Элемент лога браузера", iterator.next().getMessage());
        }
        driver.quit();
    }

}
