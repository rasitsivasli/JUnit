package HOMEWORK.H05_WindowHandle;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork21 extends TestBase {
    //Go to URL: https://demoqa.com/browser-windows
    //Click on the windows - "WindowButton"
//Click on all the child windows.
//Print the text present on all the child windows in the console.
//Print the heading of the parent window in the console.


    @Test
    public void test2() throws InterruptedException {

        //Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        /*if (driver.findElement(By.xpath("//p[.='Einwilligen']")).isDisplayed()) {
            driver.findElement(By.xpath("//p[.='Einwilligen']")).click();
        }*/
        String firstHandle = driver.getWindowHandle();

        //Click on the windows - "WindowButton"
        WebElement windowButton = driver.findElement(By.xpath("//*[@id=\"windowButton\"]"));
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", windowButton);

        //Click on all the child windows.
        List<WebElement> list = driver.findElements(By.xpath("//button[contains(@class,'btn btn-primary')]"));

        for (WebElement element : list) {
            jsexecutor.executeScript("arguments[0].click();", element);
        }

        // Convert window handles set to a list
        List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
        System.out.println("windowHandlesList = " + windowHandlesList);
        for (String windowHandle : windowHandlesList) {
            System.out.println("windowHandle = " + windowHandle);
            driver.switchTo().window(windowHandle);
            Thread.sleep(2000);
            //System.out.println("getTitle() = " + driver.getTitle());
        }
    }
}


