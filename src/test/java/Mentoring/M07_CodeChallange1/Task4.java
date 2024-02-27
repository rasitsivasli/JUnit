package Mentoring.M07_CodeChallange1;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Task4 {
  /*    Locators
driver.findElement(Locator);  Tanimladigimiz web elementin yerini driver’in bulabilmesi icin kullanilir
driver.findElement(By.id(String id));
driver.findElement(By.name(String name));
driver.findElement(By.className(String class name));
driver.findElement(By.linkText(String Link));
driver.findElement(By.partialLinkText(String link parcasi));
driver.findElement(By.tagName(String tag name));
driver.findElements(Locator);  Locator degerine uygun Web elementlerinin listesini döndürür
By.xpath(“String”)  //tagName[@attributeIsmi=’attributeValue’]
            //*[text()=’tam metin’]    (relative xpath)
            By.cssSelector(“String”)  TagName[attName=’value’];     tagName#idValue;    .classValue;*/
    /*
1) Open the browser
2) Enter the URL “https://hava-durumu-apps.netlify.app/”
3) Enter Berlin on ınput area
4) Verify result contains Berlin
5) After result locate Degrees of city by using relative locator
6)
   */

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://hava-durumu-apps.netlify.app/");
    }

    @Test
    public void test1() throws InterruptedException {
        Faker faker = new Faker();
        WebElement stadt = driver.findElement(By.xpath("//*[@id=\"input\"]"));
        stadt.sendKeys(faker.address().city(), Keys.ENTER);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]//h2"));
        WebElement loc = driver.findElement(RelativeLocator.with(By.tagName("h1")).
                above(element));
        System.out.println("loc.getText() = " + loc.getText());


    }
}
