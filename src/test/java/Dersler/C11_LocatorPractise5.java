package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_LocatorPractise5 {
    //Go to URL: //Go to URL: https://opensource-demo.orangehrmlive.com/
//Locate the username, password, login button using absolute xpath and relative xpath.
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//html/body/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        WebElement password = driver.findElement(By.xpath("//html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        WebElement login = driver.findElement(By.xpath("//html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));


    }
}

