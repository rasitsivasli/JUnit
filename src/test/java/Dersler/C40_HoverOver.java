package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C40_HoverOver extends TestBase {
    //Go to URL: https://www.amazon.com/
    //Move to “Hello, Sign in Account & Lists” link.
    //Click on Orders page.
    //Verify the page title contains “Amazon”.

    @Test
    public void hoverOver() {


        //Go to URL: https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        if (driver.findElement(By.xpath("//a[.='Try different image']")).isDisplayed()) {
            driver.findElement(By.xpath("//a[.='Try different image']")).click();
        }
        //Move to “Hello, Sign in Account & Lists” link.
        //Click on Orders page.
        WebElement signLink = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        WebElement orders = driver.findElement(By.xpath("//span[.='Empfehlungen']"));

        actions
                .moveToElement(signLink)
                .click(orders)
                .perform();

        //Verify the page title contains “Amazon”.
        assertTrue(driver.getTitle().contains("amazon"));
    }


}

