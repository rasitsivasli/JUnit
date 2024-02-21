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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C21_DropDown2 {
    /*
    Launch the browser.
    Open "https://demoqa.com/select-menu".
    Select the Old Style Select Menu using the element id.
    Print all the options of the dropdown.
    Select 'Purple' using the index.
    After that, select 'Magenta' using visible text.
    Select an option using value.
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
    public void test() throws InterruptedException {
        WebElement allElements = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select = new Select(allElements);
        List<WebElement> optionsList = select.getOptions();
        for (WebElement option : optionsList) {
            System.out.println("option = " + option.getText());
        }


    }

    @Test
    public void test2() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select = new Select(element);
        select.selectByIndex(4);
        assertEquals(select.getFirstSelectedOption().getText(),"Purple");
        select.selectByVisibleText("Magenta");
        select.selectByValue("5");
        assertTrue(select.getFirstSelectedOption().getText().contains("Black"));
    }
}

