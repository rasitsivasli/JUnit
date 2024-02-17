package Dersler;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C10_LocatorPractise2 {
    /*
    //Navigate to website  https://testpages.herokuapp.com/styled/index.html
    //Under the Examples
    //Click on Locators - Find By Playground Test Page
    //Print the URL
    //Navigate back
    //Print the URL
    //Click on WebDriver Example Page
    //Print the URL
    //Enter value  20 and Enter to "Enter Some Numbers inputBox"
    //And then verify 'two, zero' message is displayed
    //Close driver.
     */
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void AfindByPlaygroundTestPage() throws InterruptedException {
        WebElement testPage = driver.findElement(By.xpath("//a[@id='findbytest']"));
        testPage.click();
        System.out.println("UrlFindByPlaygroundTestPage = " + driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("UrlAfterBack = " + driver.getCurrentUrl());
        Thread.sleep(2000);
    }
    @Test
    public void BwebDriverExamplePage() throws InterruptedException {
        WebElement examplePage = driver.findElement(By.xpath("//a[@id='webdriverexamplepage']"));
        examplePage.click();
        System.out.println("UrlWebDriverExamplePage = " + driver.getCurrentUrl());
        Thread.sleep(2000);
    }
    @Test
    public void CenterValue() throws InterruptedException {
        WebElement value = driver.findElement(By.xpath("//input[@id='numentry']"));
        value.sendKeys("20"+Keys.ENTER);
        Thread.sleep(2000);
    }
    @Test
    public void DverifyTwoZero() throws InterruptedException {
        WebElement verify = driver.findElement(By.xpath("//p[@id='message']"));
        assertEquals("two, zero", verify.getText());
        Thread.sleep(2000);
    }
}
        /*
        //tagname[.='text name’]  -> //p[.='Submitted Values']
        //*[contains(text(),'piece of text’)]
        //*[text( )= 'text name’]  -> //*[text()='Submitted Values']
        //*[.='text name’]   -> //*[.='Submitted Values']
         */