package Training.T02_XPath;

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
import java.util.List;

public class xpath3 {
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
        driver.get("https://twitter.com/");
        if (driver.findElement(By.xpath("//*[contains(text(),'Alle Cookies akzeptieren')]")).isDisplayed()){
            driver.findElement(By.xpath("//*[contains(text(),'Alle Cookies akzeptieren')]")).click();
        }
    }
    @AfterAll
    public static void afterAll() {
        //driver.quit();
    }
    @Test
    public void test(){
        WebElement mitGoogle= driver.findElement(By.xpath("//span[.=\"Mit Google registrieren\"]/span"));
        mitGoogle.click();
        WebElement account= driver.findElement(By.xpath("//a[@data-testid='signupButton']//span[.='Account erstellen']/span"));
        System.out.println("account = " + account.getText());
        account.click();
        WebElement name= driver.findElement(By.xpath("//input[@name=\"name\"]"));
        name.sendKeys("rasit");
        WebElement eMail= driver.findElement(By.name("email"));
        eMail.sendKeys("a@email.com");
        WebElement text= driver.findElement(By.xpath("//span[starts-with(text(),'Das wird')]"));
        System.out.println("text.getText() = " + text.getText());
        List <WebElement> list= driver.findElements(By.xpath("//script[starts-with(@charset,'utf-8')]"));
        System.out.println("list.size() = " + list.size());
    }

}
