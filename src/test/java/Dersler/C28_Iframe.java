package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C28_Iframe {
    //Go to URL: https://the-internet.herokuapp.com/iframe
    //Verify the Bolded text contains “Editor”
    //Locate the text box
    //textBox webelemetine erismek icin iframe e switch yapmamiz gerekir, aksi takdirde NoSuchElementExcepion aliriz.
    //Delete the text in the text box
    //Type “Hi everyone”
    //Verify the text Elemental Selenium text is displayed on the page.
    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }//Close driver.
    @Test
    public void test1(){
        //Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement boldText = driver.findElement(By.tagName("h3"));
        assertTrue(boldText.getText().contains("Editor"));

        WebElement iframe = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        //driver.switchTo().frame("mce_0_ifr"); // eger uniq ise name yada id ile buluruz
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Hi everyone");

        WebElement textSelenium = driver.findElement(By.xpath("//*[.=\"Elemental Selenium\"]"));
        assertTrue(textSelenium.isDisplayed());

    }
}
