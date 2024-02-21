package Training;

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

public class xpath2 {
    /*As we have the visible text “Log in to Twitter” available with us
    , we would make use of the following XPath functions to uniquely identify the element.

    contains() [By text]
    starts-with() [By text]
    text()
    XPath functions like contains(), starts-with(), and text()
    when used with the help of text “Log in to Twitter” would help us identify the element correctly,
    and further operations can be performed on the same.*/
    static WebDriver driver;
    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--accept-cookies");//çerezlerei kabul etmek için
        options.addArguments("--disable-popup-blocking");//Pop-up pencereleri engellemek için
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);// ChromeOptions'u driver'ımıza tanıtıyoruz.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.teknosa.com/");
       /* if (driver.findElement(By.xpath("//*[contains(text(),'Alle Cookies akzeptieren')]")).isDisplayed()){
            driver.findElement(By.xpath("//*[contains(text(),'Alle Cookies akzeptieren')]")).click();
        }*/
    }
    @AfterAll
    public static void afterAll() {
        //driver.quit();
    }
    @Test
    public void test(){
        WebElement such= driver.findElement(By.xpath("//*[@id=\"search-input\"]"));
        such.sendKeys("oppo",Keys.ENTER);
        WebElement sonuc= driver.findElement(By.xpath("//div[contains(text(),'278 Sonuç')]"));
        System.out.println("sonuc.getText() = " + sonuc.getText());

    }

}
