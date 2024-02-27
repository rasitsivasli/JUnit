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

public class Task1_Url_PageSource {
    /*
    * driver.get() Methodlari
-  driver.get(String Url);     String olarak girilen Url’e gider
-  driver.getTitle();          Icinde olunan sayfanin basligini String olarak getirir
-  driver.getCurrentUrl();     Icinde olunan sayfanin Url’ini String olarak getirir
-  driver.getPageSource();     Icinde olunan sayfanin kaynak kodlarini String olarak getirir */
    /*
    //opening the target website https://www.ikea.com/
    //set expected title contains "Welcome"
    //using getTitle() to retrieve actual title.
    //get currentUrl text
    //get pageSource
     */
    //close driver
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.ikea.com/");
    }

    @Test
    public void test1() throws InterruptedException {

        WebElement acceptAll = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptAll.click();
        Thread.sleep(2000);
        Assertions.assertTrue(driver.getTitle().contains("Welcome"));
        System.out.println("Url = " + driver.getCurrentUrl());
        System.out.println("PageSource= " + driver.getPageSource());
    }
}
