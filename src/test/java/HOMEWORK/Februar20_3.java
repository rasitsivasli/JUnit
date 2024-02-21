package HOMEWORK;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Februar20_3 {
    /*
Go to URL: lichess.org
Get dynamic XPath locators of webelements signed on the secreenshot
*/

    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://lichess.org/");
    }

    @AfterAll
    public static void tearDown() {
        // driver.quit();
    }

    @Test
    @Order(1)
    public void test() throws InterruptedException {
       WebElement lichess = driver.findElement(By.xpath("//h1[@class='site-title']//a"));
       assertTrue(lichess.isDisplayed());
        WebElement oyna = driver.findElement(By.xpath("//span[.='Spielen']"));
        assertTrue(oyna.isDisplayed());
        WebElement bulmacalar= driver.findElement(By.xpath("(//a[text()=\"Aufgaben\"])[1]"));
        assertTrue(bulmacalar.isDisplayed());
        WebElement ogren = driver.findElement(By.xpath("//a[text()=\"Lernen\"]"));
        assertTrue(ogren.isDisplayed());
        WebElement izle = driver.findElement(By.xpath("//a[text()=\"Zuschauen\"]"));
        assertTrue(izle.isDisplayed());
        WebElement topluluk = driver.findElement(By.xpath("//a[text()=\"Gemeinschaft\"]"));
        assertTrue(topluluk.isDisplayed());
        WebElement araclar = driver.findElement(By.xpath("//a[text()=\"Werkzeuge\"]"));
        assertTrue(araclar.isDisplayed());
        WebElement besSifir = driver.findElement(By.xpath("//div[@id='main-wrap']//div[@data-id='5+0']"));
        assertTrue(besSifir.isDisplayed());
        WebElement spieleMitComputer = driver.findElement(By.xpath("//*[text()='Spiele mit dem Computer']"));
        assertTrue(spieleMitComputer.isDisplayed());
        WebElement spieleMitFreund = driver.findElement(By.xpath("//*[text()='Spiele mit einem Freund']"));
        assertTrue(spieleMitFreund.isDisplayed());
        WebElement neuParty = driver.findElement(By.xpath("//button[text()='Neue Partie']"));
        assertTrue(neuParty.isDisplayed());
        WebElement spieler = driver.findElement(By.xpath("//div[@id='main-wrap']//*[text()=' Spieler']"));
        assertTrue(spieler.isDisplayed());
        WebElement einstellungen = driver.findElement(By.xpath("//span[@aria-label='Einstellungen']"));
        assertTrue(einstellungen.isDisplayed());
        WebElement suche = driver.findElement(By.xpath("//span[@data-icon='\uE06C']"));
        assertTrue(suche.isDisplayed());
        WebElement laufendePartei = driver.findElement(By.xpath("//*[text()=' laufende Partien']"));
        assertTrue(laufendePartei.isDisplayed());


    }
}
