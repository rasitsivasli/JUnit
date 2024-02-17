package Training;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Metodlar {
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.de/");
    }

    @Test
    public void test1() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("amazon"));

    }

    @Test
    public void test2() {
        Assertions.assertTrue(driver.getTitle().contains("de"));

    }

    @AfterAll
    public static void afterAll(){
        driver.quit();
    }
}
