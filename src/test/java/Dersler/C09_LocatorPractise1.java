package Dersler;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C09_LocatorPractise1 {
        /*
    Create the driver with BeforeClass and make it static inside the class.
    Go to http://www.google.com
    Type "Green Mile" in the search box and print the number of results.
    Type "Premonition" in the search box and print the number of results.
    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
    Close with AfterClass.
     */
        static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.google.com");
        if (driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).isDisplayed()){
            driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        }
    }
    @Test
    public void test1() throws InterruptedException {

        WebElement greenMile = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        Thread.sleep(2000);
        greenMile.sendKeys("Green Mile"+Keys.ENTER);
        WebElement text1 = driver.findElement(By.xpath("//*[@id=\"result-stats\"]/nobr"));
        System.out.println(text1.getText());
        Thread.sleep(2000);
        WebElement clear = driver.findElement(By.xpath("//textarea[@value='Green Mile']"));
        System.out.println(clear.getText());
        Thread.sleep(2000);
        clear.clear();
        Thread.sleep(2000);


        WebElement premonition = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        premonition.sendKeys("Premonition"+Keys.ENTER);
        Thread.sleep(2000);
        WebElement text2 = driver.findElement(By.xpath("//*[@id=\"result-stats\"]/nobr"));
        System.out.println(text2.getText());
        Thread.sleep(2000);
        WebElement clear2 = driver.findElement(By.xpath("//textarea[@value='Premonition']"));
        Thread.sleep(2000);
        clear2.clear();


        WebElement benjaminButton = driver.findElement(By.xpath("//textarea[@value='Premonition']"));
        benjaminButton.sendKeys("The Curious Case of Benjamin Button"+Keys.ENTER);
        WebElement text3 = driver.findElement(By.xpath("//*[@id=\"result-stats\"]/nobr"));
        System.out.println(text3.getText());
        Thread.sleep(2000);

    }


    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }
}
