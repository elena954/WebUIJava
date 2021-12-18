package HomeWork5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static HomeWork5.DataTest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class AuthorizationAndNewMessageYandex {
    @Test
    static void newMessage(){
        login();

        ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Написать']")));
        driver.findElement(By.xpath("//span[.='Написать']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[@class='ComposeRecipients-TopRow']//div[@class='composeYabbles']")));
        driver.findElement(By.xpath
                ("//div[@class='ComposeRecipients-TopRow']//div[@class='composeYabbles']"))
                .sendKeys("len4ik.kmx@gmail.com");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Test1");
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("text1");
        driver.findElement(By.xpath("//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']"))
                .click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Вернуться во \"Входящие\"']")));
        Assertions.assertEquals(driver.findElement(By.xpath("//a[.='Вернуться во \"Входящие\"']")).isDisplayed(),true);
        assertThat(driver.findElement(By.xpath("//a[.='Вернуться во \"Входящие\"']")), isDisplayed());
    }

    static void login(){
        driver.findElement(By.xpath("//div[.='Войти']")).click();
        driver.findElement(By.id("passp-field-login")).sendKeys("len4ik359");
        driver.findElement(By.id("passp:sign-in")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-passwd")));
        driver.findElement(By.id("passp-field-passwd")).sendKeys("a3088a");
        driver.findElement(By.id("passp:sign-in")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='desk-notif-card__mail-title']")));
        driver.findElement(By.xpath("//div[@class='desk-notif-card__mail-title']")).click();
    }
}
