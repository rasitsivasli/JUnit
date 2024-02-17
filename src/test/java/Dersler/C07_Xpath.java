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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C07_Xpath {
    //  format : //tagName[@attribute = 'value']
    // amazon.com sayfasında xpath practise yapıyoruz.
    ///html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div[1]/input----> absolut xpath
    ////*[@id="twotabsearchtextbox"]--->relativ xpath
    static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        if (driver.findElement(By.xpath("//*[.='Try different image']")).isDisplayed()){
            driver.findElement(By.xpath("//*[.='Try different image']")).click();
        }
    }
    @Test
    public void searchAmazon() throws InterruptedException {

        WebElement searchAmazon = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        assertTrue(searchAmazon.isDisplayed());
        Thread.sleep(2000);

    }
    @Test
    public void searchAmazon2() throws InterruptedException {
        //tag i input olan ve name i 'field-keywords' elementi bul
        WebElement searchAmazon = driver.findElement(By.xpath("//input[@name='field-keywords']"));
        searchAmazon.sendKeys("kleidung"+Keys.ENTER);// tag input olmali   VE BU SEKILDE ENTER BASMIS OLUYORUZ
        Thread.sleep(3000);
        //searchAmazon.submit();  //-> 2. yol yukaridakinin

        /*WebElement searchKlick = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchKlick.click();*/ //bu da 3. yol
        Thread.sleep(3000);

    }
    @Test
    public void logo2() throws InterruptedException {

        WebElement amazonLogo1 = driver.findElement(By.xpath("//a[@class='nav-logo-link nav-progressive-attribute']"));
        amazonLogo1.click();
        WebElement amazonLogo2 = driver.findElement(By.xpath("//a[@aria-label='Amazon']"));
        WebElement amazonLogo3 = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));

        Thread.sleep(2000);

    }
    @Test
    public void search() throws InterruptedException {
        Thread.sleep(2000);
        WebElement allButton = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        allButton.isSelected();
        allButton.submit();

        Thread.sleep(2000);

    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



}

