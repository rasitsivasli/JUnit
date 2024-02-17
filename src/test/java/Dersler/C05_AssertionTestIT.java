package Dersler;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C05_AssertionTestIT {
        /*
    Go to Amazon homepage
    Do the following tasks by creating 3 different test methods.
    1- Test if the URL contains Amazon.
    2- Test if the title does not contain Facebook.
    3- Test that the Amazon logo appears in the upper left corner.
     */

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        if (driver.findElement(By.xpath("//*[.='Try different image']")).isDisplayed()){
            driver.findElement(By.xpath("//*[.='Try different image']")).click();
        }
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);

    }
    @Test
    public void test1(){
        assertTrue(driver.getCurrentUrl().contains("amazon"));

    }
    @Test
    public void test2(){
        assertFalse(driver.getCurrentUrl().contains("Facebook"));

    }
    @Test
    public void test3(){
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        assertTrue(amazonLogo.isDisplayed());

    }
}
