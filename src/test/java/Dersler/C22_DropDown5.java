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

public class C22_DropDown5 {
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
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]"));
        Select select = new Select(element);
        List<WebElement> allOptions=select.getOptions();
        System.out.println("Options Size = " + allOptions.size());
        for (WebElement webElement : allOptions) {
            System.out.println("Option = " + webElement.getText());
        }

        assertTrue(blackOption(allOptions));// black option u old. dogrulayan method
        System.out.println("getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());
        select.selectByValue("3");
        System.out.println("Yellow ?  = " + select.getFirstSelectedOption().getText());
    }

    private boolean blackOption(List<WebElement> allOptions) {
        boolean blackOption = false;
        for (WebElement option : allOptions) {
            if (option.getText().equals("Black")) {
                blackOption = true;
                break;
            }
        }
        return blackOption;
    }
}
