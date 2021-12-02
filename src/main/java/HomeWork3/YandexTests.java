package HomeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;


public class YandexTests {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ru");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div/a[1]")).click();
        WebElement loginField = driver.findElement(By.id("passp-field-login"));
        loginField.sendKeys("len4ik359");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("passp-field-passwd")).sendKeys("a3088a");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='desk-notif-card__mail-title']")).click();
        Thread.sleep(5000);

        ArrayList tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));

        driver.findElement(By.xpath("//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div[2]/div[1]/div/div/div/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"js-apps-container\"]/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")).sendKeys("len4ik.kmx@gmail.com");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Test1");
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("text1");
        driver.findElement(By.xpath("//*[@id=\"js-apps-container\"]/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")).click();
        driver.quit();
    }
}
