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

public class xpath {
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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.automationpractice.pl/index.php");
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
        WebElement anmelden1= driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        anmelden1.click();
        WebElement email= driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
        email.sendKeys("sdfsdf",Keys.ENTER);
        WebElement verify= driver.findElement(By.xpath("//*[@id='create_account_error']"));
        WebElement verify2= driver.findElement(By.xpath("//li[contains(text(),\"Invalid email address\")]"));
        WebElement verify3= driver.findElement(By.xpath("//li[.=\"Invalid email address.\"]"));
        System.out.println("Text : "+verify3.getText());


    }

}
