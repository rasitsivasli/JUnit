package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_LocatorPractise4 {

    // Navigate to  https://testpages.herokuapp.com/styled/index.html
// Click on  Calculate under Micro Apps
// Type any number in the first input
// Type any number in the second input
// Click on Calculate
// Get the result
// Print the result
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        WebElement calculate = driver.findElement(By.id("calculatetest"));
        calculate.click();
        WebElement erste = driver.findElement(By.xpath("//input[@id='number1']"));
        erste.sendKeys("20");
        WebElement zweite = driver.findElement(By.xpath("//input[@id='number2']"));
        zweite.sendKeys("30");
        WebElement button = driver.findElement(By.xpath("//input[@id='calculate']"));
        button.click();
        WebElement answer = driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("answer = " + answer.getText());
    }
}

