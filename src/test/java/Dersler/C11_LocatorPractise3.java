package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C11_LocatorPractise3 {
    /*
    //https://id.heroku.com/login sayfasına gidiniz.
    //Bir mail adresi giriniz.
    //Bir password giriniz.
    //Login butonuna tıklayınız.
    //"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
    //Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
    //Tüm sayfaları kapatınız.
     */
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://id.heroku.com/login");
        if (driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).isDisplayed()){
            driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        }
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        WebElement eMail = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
        eMail.sendKeys("rasit@gmail.com");

        WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("1234");

        WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']"));
        login.click();

        Thread.sleep(2000);

        WebElement verify = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        if (verify.getText().contains("There was a problem with your login.")) {
            System.out.println("Kayıt Yapılamadı");
        } else {
            System.out.println("Kayıt Yapıldı");
        }
    }

}

