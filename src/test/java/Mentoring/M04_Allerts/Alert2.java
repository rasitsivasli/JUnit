package Mentoring.M04_Allerts;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Alert2 {
    // Goto page
    //1-Click "Show Alert Box button
    //2-Handle warning alert
    //3-Get allert message
    //4-After accept() alert verify "You triggered and handled the alert dialog" text
    //5-Click Show confirm button
    //6-Get allert message
    //7-Dismiss alert
    //8-After dismiss() alert verify "You clicked Cancel, confirm returned false." text
    //9-Show prompt box click.Send message and accep verify it
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        WebElement allet1 = driver.findElement(By.xpath("//*[@id='alertexamples']"));
        allet1.click();
        System.out.println("Alert Text = " + driver.switchTo().alert().getText());
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement verifyText = driver.findElement(By.xpath("//*[@id=\"alertexplanation\"]"));
        assertEquals("You triggered and handled the alert dialog", verifyText.getText());
        WebElement verifyText2 = driver.findElement(By.xpath("//*[@id=\"confirmexample\"]"));
        verifyText2.click();
        System.out.println("Alert Text2 = " + driver.switchTo().alert().getText());
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        WebElement verifyText3 = driver.findElement(By.xpath("//*[@id=\"confirmexplanation\"]"));
        verifyText3.click();
        System.out.println("Alert Text3 = " + verifyText3.getText());
        assertEquals("You clicked Cancel, confirm returned false.", verifyText3.getText());
        WebElement verifyText4 = driver.findElement(By.xpath("//*[@id=\"promptexample\"]"));
        verifyText4.click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Hello");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();


    }
}
