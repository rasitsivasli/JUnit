package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C22_DropDown3 {
        /*
    Launch the browser.
    Open "https://demoqa.com/select-menu".
    Select the Standard Multi-Select using the element id.
    Verifying that the element is multi-select.
    Select 'Opel' using the index and deselect the same using index.
    Select 'Saab' using value and deselect the same using value.
    Deselect all the options.
    Close the browser.
     */
        static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"cars\"]"));
        Select select = new Select(element);
        assertTrue(select.isMultiple());
        select.selectByValue("opel");
        Thread.sleep(3000);
        select.deselectByValue("opel");
        Thread.sleep(3000);
        select.selectByValue("saab");
        Thread.sleep(3000);
        select.deselectByValue("saab");
        Thread.sleep(3000);
        select.deselectAll();
        Thread.sleep(3000);


    }
}
