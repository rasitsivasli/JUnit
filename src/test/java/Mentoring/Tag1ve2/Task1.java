package Mentoring.Tag1ve2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1 {
     /*
Invoke FireFox Driver
Go to https://www.youtube.com/
Maximize the window
Verify the page title contains the word video.
Minimize the window
Verify the page title contains the word video.
Make the page fullscreen
Close the driver.
 */
     static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.w3school.com/");


    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        String title= driver.getTitle();
        System.out.println(title);
        assertTrue(title.contains("Wonderful Surprise"));
        driver.manage().window().minimize();
    }
    @Test
    public void test2() {
        String title= driver.getTitle();
        assertTrue(title.contains("Wonderful Surprise"));
        driver.manage().window().fullscreen();
    }
}
