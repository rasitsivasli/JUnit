package Mentoring.M05_IFrame;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C28_Iframe {
    //Goto page:  https://demo.automationtesting.in/Frames.html
    //Verify :iFrame Demo text
    //Click Iframe with in an Iframe button
    //verify Nested iFrames text
    //Send text input area
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demo.automationtesting.in/Frames.html");
        if (driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).isDisplayed()) {
            driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]")).click();
        }
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"singleframe\"]"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("(//h5[text()='iFrame Demo'])[1]"));
        System.out.println("textBox.getText() = " + textBox.getText());
        WebElement textBox2 = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        textBox2.sendKeys("Hello");
        Thread.sleep(3000);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.switchTo().defaultContent();
        WebElement iframeWithButton = driver.findElement(By.xpath("//a[.='Iframe with in an Iframe']"));
        iframeWithButton.click();

        WebElement iframeGross = driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
        driver.switchTo().frame(iframeGross);

        WebElement nestedIframe = driver.findElement(By.xpath("//*[.=\"Nested iFrames\"]"));
        nestedIframe.isDisplayed();
        System.out.println("nestedIframe.getText() = " + nestedIframe.getText());

        WebElement nestedIframe2 = driver.findElement(By.xpath("//div[@class=\"iframe-container\"]/iframe"));
        driver.switchTo().frame(nestedIframe2);

        WebElement nestedBox = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        nestedBox.sendKeys("World!");

    }

}
