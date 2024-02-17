package Dersler;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_LocatorPractiseVersion2 {

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
        public static void beforeAll() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @AfterAll
        public static void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }

        @BeforeEach
        public void beforeEach() throws InterruptedException {
            driver.navigate().to("http://www.google.com");
        }

        @AfterEach
        public void afterEach() throws InterruptedException {
            driver.navigate().back();
        }

        @Test
        public void atest1GreenMile() {
            WebElement searchBox = driver.findElement(By.id("APjFqb"));
            searchBox.sendKeys("Green Mile" + Keys.ENTER);
            WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
            System.out.println(result.getText());
        }

        @Test
        public void btest2Premonition() {
            WebElement searchBox = driver.findElement(By.id("APjFqb"));
            searchBox.sendKeys("Premonition" + Keys.ENTER);
            WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
            System.out.println(result.getText());
        }

        @Test
        public void ctest3BenjaminButton() {
            WebElement searchBox = driver.findElement(By.id("APjFqb"));
            searchBox.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
            WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
            System.out.println(result.getText());
        }
    }

