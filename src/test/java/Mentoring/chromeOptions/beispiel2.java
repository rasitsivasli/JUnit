package Mentoring.chromeOptions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class beispiel2 {

    // 1-Goto clarusway home page
    // 2-Cybersecurity linkini baz alarak solundaki AWS linkini locate ediniz.
    // 3-Linkin üzerinde "AWS & DEVOPS" yazısını doğrulayın
    // 4-Cybersecurity linkini baz alarak yukarıdaki  Take Our Quiz and
    // Find Your Ideal Career metnini locate edin ve doğrulayın
    // 5- Cybersecurity linkini baz alarak yan taraftaki görselin varlığını test edin
    static WebDriver driver;
    @BeforeAll
    public static void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.clarusway.com/");
        if (driver.findElement(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]")).click();
        }
    }

    @AfterAll
    public static void tearDown() {
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        WebElement cyberLink = driver.findElement(By.xpath("(//span[.='Cybersecurity'])[1]"));
        WebElement aws=driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(cyberLink));
        System.out.println("aws.getText() = " + aws.getText());
        WebElement takeYourQuiz=driver.findElement(RelativeLocator.with(By.tagName("a")).above(cyberLink));
        System.out.println(takeYourQuiz.getText());
        WebElement bild=driver.findElement(RelativeLocator.with(By.className("elementor-widget-wrap")).near(cyberLink));
        assertTrue(bild.isDisplayed());
    }
}
