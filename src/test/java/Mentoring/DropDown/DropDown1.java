package Mentoring.DropDown;

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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDown1 {
    //https://demoqa.com/select-menu
    //Get all the options of the dropdown
    //Options size
    //Print all test
    //Verify the dropdown has option "Black"
    //Print FirstSelectedOptionTest
    //Select option "Yellow"
        static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://formstone.it/components/dropdown/demo/");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"demo_label\"]"));
        Select select = new Select(element);
        select.selectByValue("AZ");
        select.selectByIndex(3);
        select.selectByVisibleText("Massachusetts");
        List<WebElement> allOptions=select.getOptions();
        System.out.println("Options Size = " + allOptions.size());
        for (WebElement webElement : allOptions) {
            System.out.println("Option = " + webElement.getText());
        }
    }
    @Test
    public void test2() throws InterruptedException {
        WebElement multi = driver.findElement(By.xpath("//*[@id=\"demo_multiple\"]"));
        Select select = new Select(multi);
        select.selectByIndex(2);
    }
}
