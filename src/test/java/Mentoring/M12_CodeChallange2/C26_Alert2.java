package Mentoring.M12_CodeChallange2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestBase;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C26_Alert2 extends TestBase {
    /*
      https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html adresine gidin
      Launch alert buttonuna tıklayın
      Alert pop-up textin <Hello world!> olduğunu doğrulayın
     */

    @Test
    public void test() throws InterruptedException {

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");

        //Click for JS Alert butonuna tikla
        WebElement launchAllert= driver.findElement(By.xpath("//*[@id=\"my-alert\"]"));
        launchAllert.click();

        String text =  driver.switchTo().alert().getText();
        assertEquals("Hello world!", text);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }
}
