package HOMEWORK.Alerts;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class iFrame {
    //Go to URL: http://demo.guru99.com/test/guru99home/
//Find the number of iframes on the page.
//Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
//Exit the iframe and return to the main page.
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.guru99.com/test/guru99home/");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Nummer of Iframes = " + iframes.size());

    }
    @Test
    public void test2() throws InterruptedException {
        // Burada sayfa acildiginda ilk cikan Iframe icindeki coocki leri kaldiriyoruz.
        WebElement iFrame1 = driver.findElement(By.xpath("//*[@id=\"gdpr-consent-notice\"]"));
        driver.switchTo().frame(iFrame1);
        WebElement alleAkzeptieren = driver.findElement(By.xpath("(//*[@id=\"save\"]//span[.='Alle akzeptieren'])[2]"));
        alleAkzeptieren.click();
        driver.switchTo().defaultContent();


        WebElement element = driver.findElement(By.xpath("//*[@id=\"a077aa5e\"]"));
        driver.switchTo().frame(element);

        WebElement JMeterMadeEasy = driver.findElement(By.xpath("//a[@href=\"http://www.guru99.com/live-selenium-project.html\"]"));
        JMeterMadeEasy.click();

        driver.switchTo().defaultContent();

        // 2. sayfada cikan onay pop-up i handel ediyoruz

        driver.get("https://www.guru99.com/live-selenium-project.html");
        WebElement iFrame2 = driver.findElement(By.xpath("//*[@id=\"sp_message_iframe_1037215\"]"));
        driver.switchTo().frame(iFrame2);
        WebElement zustimmen = driver.findElement(By.xpath("//button[@title='Zustimmen']"));
        Thread.sleep(3000);
        System.out.println("zustimmen.getText() = " + zustimmen.getText());
        zustimmen.click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
    }

}
