package Mentoring.M09_WindowHandle;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.WindowType.WINDOW;

public class HomeWork21 extends TestBase {
    //Goto page: https://www.tkmaxx.com/LandingPage/
//After goto page locate : TK Maxx Deutschland
//Click link goto new page
//Get current url
//after get curret url back to home page
//Open new Window
//And open Deutcland url(get the before)


    @Test
    public void test2() throws InterruptedException {

        //Go to the above URL.
        driver.get("https://www.tkmaxx.com/LandingPage/");
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //After goto page locate : TK Maxx Deutschland
        //Click link goto new page
        WebElement de = driver.findElement(By.xpath("//span[@class='icon flag-de']"));
        de.click();

        //Get current url
        String currentHandle = driver.getWindowHandle();
        driver.switchTo().window(currentHandle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        if (driver.findElement(By.xpath("//*[.='Alle Cookies akzeptieren']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Alle Cookies akzeptieren']")).click();
        }
        //Open new Window
        driver.switchTo().newWindow(WINDOW);
        System.out.println("WindowHandle = " + driver.getWindowHandle());

        //And open Deutcland url(get the before)
        driver.switchTo().window(currentHandle);
        String currentHandleDe = driver.getWindowHandle();
        System.out.println("currentHandleDe = " + currentHandleDe);
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }
}
