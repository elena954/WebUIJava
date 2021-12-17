package HomeWork5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static HomeWork5.DataTest.*;


public abstract class DeleteASentMessageYandex {

    @Test
    static void deleteSentMessages(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Вернуться во \"Входящие\"']")));
        driver.findElement(By.xpath("//a[.='Вернуться во \"Входящие\"']")).click();
        driver.findElement(By.xpath("//span[.='Отправленные']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Выделить все письма']")));
        actions.clickAndHold(driver.findElement(By.xpath("//div[@title='Выделить все письма']")))
                .click()
                .build()
                .perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Удалить (Delete)']")));
        actions.clickAndHold(driver.findElement(By.xpath("//div[@title='Удалить (Delete)']")))
                .click()
                .build()
                .perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='button2__text'][.='Удалить']")));
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='button2__text'][.='Удалить']")))
                .click()
                .build()
                .perform();
   }
}
