package HOMEWORK;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Februar20_2 {
    /*
    Go to URL: https://demoqa.com/radio-button
    Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
    Her bir seçenek seçildiğinde aşağısında çıkan text'leri konsolda yazdırınız.
     */
    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/radio-button");
    }

    @AfterAll
    public static void tearDown() {
        // driver.quit();
    }

    @Test
    @Order(1)
    public void test() throws InterruptedException {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//label[contains(@class,'custom-control-label')]"));
        System.out.println(radioButtons.size());
        for (WebElement each: radioButtons) {
            each.click();
            WebElement text = driver.findElement(By.xpath("//*[text()='You have selected ']//span"));
            Thread.sleep(2000);
            System.out.println("text.getText() = " + text.getText());
        }
    }
    @Test
    @Order(2)
    public void test2() throws InterruptedException {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//label[contains(@class,'custom-control-label')]"));
        System.out.println(radioButtons.size());
        for (WebElement each: radioButtons) {
            each.click();
            if (!each.isSelected()) {
                assertTrue(false);
            }
        }
    }
}
