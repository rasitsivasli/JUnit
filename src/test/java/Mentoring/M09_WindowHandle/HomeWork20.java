package Mentoring.M09_WindowHandle;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork20 extends TestBase {
    /*
     Example-1: How to Handle Multiple Windows in Selenium?
     Test website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
     Test Scenario:
     Go to the above URL.
     Get the current window’s handle and write to the console window. It must be the first window handle.
     Locate the “Visit W3Schools.com!” link and click it.
     Get all window handles and hold them in a list.
     Write to total window handle number to the console. It must be 2.
     Switch t the second window.
     Get the current window’s handle and write to the console window. It must be a second window handle.
     Check the upper left side logo in the second window.
     Go back (Switch) to the first window.
     Get the current window’s handle and write to the console window. It must be the first window handle.
     Check the See Run Button Text. It must contain “Run >” text.
      */

    @Test
    public void test2() throws InterruptedException {

        //Go to the above URL.
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
        if (driver.findElement(By.xpath("//*[.='Accept all & visit the site']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Accept all & visit the site']")).click();
        }

        //Get the current window’s handle and write to the console window. It must be the first window handle.
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //Locate the “Visit W3Schools.com!” link and click it.
        WebElement iFrame1 = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
        driver.switchTo().frame(iFrame1);
        WebElement element1 = driver.findElement(By.linkText("Visit W3Schools.com!"));
        element1.click();


        //Get all window handles and hold them in a list.
        Set<String> windowhandleList = driver.getWindowHandles();
        for (String s : windowhandleList) {
            if (!s.equals(mainHandle)) {
                driver.switchTo().window(s);
                break;
            }
        }
        String second = driver.getWindowHandle();
        System.out.println("second = " + second);

        WebElement logo = driver.findElement(By.xpath("//*[@id=\"w3-logo\"]"));
        logo.click();

        driver.switchTo().window(mainHandle);
        assertTrue(driver.getTitle().contains("Tryit"));
    }
}
