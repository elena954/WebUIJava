package HomeWork7;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class CustomLoggerNew implements WebDriverListener {

    private static Logger logger= LoggerFactory.getLogger("WebDriver");

    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Кликаем на элемент с текстом: " + element.getText());
        Allure.step("Кликаем на элемент с текстом" + element.getText());
    }

    public void beforeFindElement(WebDriver driver, By locator){
        Allure.addAttachment("Скриншот страницы",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
