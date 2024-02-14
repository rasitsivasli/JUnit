package Dersler;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAllAfterAll {

    static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("BeforeAll calisti");
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("AfterAll calisti");
        driver.quit();
    }

}
