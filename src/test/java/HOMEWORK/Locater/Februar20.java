package HOMEWORK.Locater;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Februar20 {

            /*
        Go to URL: https://demoqa.com/
        Click on Elements.
        Click on Checkbox.
        Verify if Home checkbox is selected.
        Verify that "You have selected" is visible.
             */


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
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterAll
    public static void tearDown() {
        // driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        WebElement elements = driver.findElement(By.xpath("//*[.='Elements']"));
        elements.click();
        Thread.sleep(2000);
        WebElement check = driver.findElement(By.xpath("//*[@class='btn btn-light ']//span[text()='Check Box']"));
        check.click();
        Thread.sleep(2000);
        WebElement verify = driver.findElement(By.xpath("//h1[.='Check Box']"));
        System.out.println("verify.getText() = " + verify.getText());//1. yol
        assertTrue(verify.isDisplayed());//2. yol
        WebElement home = driver.findElement(By.xpath("//span[text()='Home']"));
        home.click();
        WebElement youHaveSelected = driver.findElement(By.xpath("//*[contains(text(),'You have selected :')]"));
        System.out.println("youHaveSelected.getText() = " + youHaveSelected.getText());

        Thread.sleep(2000);


    }
}
