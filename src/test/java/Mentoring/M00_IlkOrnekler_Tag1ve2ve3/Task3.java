package Mentoring.M00_IlkOrnekler_Tag1ve2ve3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Task3 {
    //    Goto page https://testpages.herokuapp.com/styled/basic-html-form-test.html
    //        Create webdriver object
    //        1-Test userName input text.Send name
    //        2-Test password input text.Send password

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
    }

    @Test
    public void test1() throws InterruptedException {

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("TestUser");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("TestPassword");
        Thread.sleep(2000);
    }
    @Test
    public void test2() throws InterruptedException {

        assertTrue(driver.getTitle().contains("Form"));
    }
    @Test
    public void test3() throws InterruptedException {

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("rasit");
        Thread.sleep(2000);
    }
    @Test
    public void test4() throws InterruptedException {

        WebElement comment = driver.findElement(By.name("comments"));
        comment.clear();
        comment.sendKeys("rasit");
        Thread.sleep(2000);
    }
}
