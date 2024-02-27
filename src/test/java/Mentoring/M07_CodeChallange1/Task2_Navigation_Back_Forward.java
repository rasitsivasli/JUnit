package Mentoring.M07_CodeChallange1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Task2_Navigation_Back_Forward {

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.ikea.com/");
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement acceptAll = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        acceptAll.click();
        driver.navigate().to("https://www.ikea.com/global/en/stories/");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }
}
