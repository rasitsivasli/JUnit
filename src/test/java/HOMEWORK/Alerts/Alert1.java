package HOMEWORK.Alerts;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Alert1 {
    //Go to URL: http://demo.automationtesting.in/Alerts.html
//Click "Alert with OK" and click 'click the button to display an alert box:'
//Accept Alert(I am an alert box!) and print alert on console.
//Click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
//Cancel Alert (Press a Button !)
//Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
//And then sendKeys «Bootcamp» (Please enter your name)
//Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.automationtesting.in/Alerts.html");
        if (driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).isDisplayed()) {
            driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).click();
        }
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        WebElement button = driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button"));
        Thread.sleep(3000);
        button.click();
        System.out.println("Alert Text() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }
    @Test
    public void test2() throws InterruptedException {

        WebElement button = driver.findElement(By.xpath("//*[.='Alert with OK & Cancel '] "));
        Thread.sleep(3000);
        button.click();
        WebElement button2 = driver.findElement(By.xpath("//*[.='click the button to display a confirm box '] "));
        button2.click();
        driver.switchTo().alert().accept();

    }  @Test
    public void test3() throws InterruptedException {

        WebElement button = driver.findElement(By.xpath("//*[.='Alert with Textbox '] "));
        Thread.sleep(3000);
        button.click();
        WebElement button2 = driver.findElement(By.xpath("//*[@id='Textbox']/button"));
        button2.click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Rasit");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        WebElement verify = driver.findElement(By.xpath("//*[@id=\"demo1\"]"));
        assertEquals("Hello Rasit How are you today", verify.getText());
    }
}
