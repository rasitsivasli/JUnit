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

public class C22_DropDown4 {
            /*
        Go to URL: https://the-internet.herokuapp.com/dropdown
        Create method selectByIndexTest and Select Option 1 using index .
        Create method selectByValueTest Select Option 2 by value.
        Create method selectByVisibleTextTest Select Option 1 value by visible text.
        Create method printAllTest Print all dropdown value.
        Verify the dropdown has Option 2 text.
        Create method printFirstSelectedOptionTest Print first selected option.
        Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        */
        static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @AfterAll
    public static void tearDown() {
        //driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByValue("2");
        Thread.sleep(3000);
        select.selectByVisibleText("Option 1");
        Thread.sleep(3000);
        printAllTest(select);
        Thread.sleep(3000);
        assertEquals("Option 2",select.getOptions().get(2).getText());
        System.out.println("First Selected Option Text() = " + select.getFirstSelectedOption().getText());
        List<WebElement> all=select.getOptions();
        System.out.println(all.size()==3?"Expected Is Equal Actual":"Expected Is Not Equal Actual");

    }

    private void printAllTest(Select select) {
        List<WebElement> all=select.getOptions();
        for (WebElement webElement : all) {
            System.out.println("webElement = " + webElement.getText());
        }
    }
}
