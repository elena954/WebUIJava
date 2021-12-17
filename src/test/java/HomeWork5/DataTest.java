package HomeWork5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DataTest {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Actions actions;
    public final static String BASE_URL = "https://yandex.ru";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    static void setDriver(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(BASE_URL);
    }


    @AfterEach
    static void tearDown(){
        driver.quit();
    }
}
