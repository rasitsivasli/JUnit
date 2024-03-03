package Mentoring.M12_CodeChallange2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;

public class C23_Waits extends TestBase {
 /*  1) Open the browser
     2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html”
     3)1 + 3
     4) ... should be 4, wait for it*/

    @Test
    public void impiliciteWait() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");


        WebElement eins = driver.findElement(By.xpath("//span[.='1']"));
        eins.click();

        WebElement plus = driver.findElement(By.xpath("//span[.='+']"));
        plus.click();

        WebElement drei = driver.findElement(By.xpath("//span[.='3']"));
        drei.click();

        WebElement equals = driver.findElement(By.xpath("//span[.='=']"));
        equals.click();

        WebElement sonuc = driver.findElement(By.xpath("//div[.='4']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(sonuc));
        Assertions.assertEquals(sonuc.getText(),"4");

    }
}