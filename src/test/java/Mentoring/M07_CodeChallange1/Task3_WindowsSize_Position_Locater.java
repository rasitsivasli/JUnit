package Mentoring.M07_CodeChallange1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3_WindowsSize_Position_Locater {
    /*

     */

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/geolocation");
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Window Size = " + driver.manage().window().getSize());
        System.out.println("Position = " + driver.manage().window().getPosition());

        // 3- Click "Where I am button"
        WebElement whereIam = driver.findElement(By.xpath("//*[@onclick='getLocation()']"));
        whereIam.click();

        //4- Get your coordinate write
        WebElement loc = driver.findElement(By.xpath("//*[@id=\"lat-value\"]"));
        System.out.println("loc.getText() ilk 6 sayi = " + loc.getText().substring(0, 6));
        String locString = loc.getText().substring(0, 6);

        //5- Then click " See it on Google "
        WebElement google = driver.findElement(By.linkText("See it on Google"));
        google.click();
        Thread.sleep(3000);

        // find actual location
        WebElement actualLoc = driver.findElement(By.xpath("//h2/span"));
        System.out.println("actual = " + actualLoc.getText());

        //6- Verify your coordinate in map
        Assertions.assertTrue(actualLoc.getText().contains(locString));


    }
}
