package Mentoring.M18_JavaExucetur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

public class WindowHandle2 extends TestBase {
    // Step 1: Go to the URL
    // accept cookies
    // driver.findElement(By.id("accept-choices")).click();
    // Step 2: Switch to the iframe containing the "Try it" button
    // Locate and click the "Try it" button
    // Step 3: Switch to the new window that opened
    // Step 4: Switch back to the original window by using the window handle


    @Test
    public void test1() throws InterruptedException {
        //Go to the above URL.
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        String currentHandle = driver.getWindowHandle();
        //cerezler icin
        driver.findElement(By.id("accept-choices")).click();

        // Step 2: Switch to the iframe containing the "Try it" button
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));

        // Locate and click the "Try it" button
        driver.switchTo().frame(iframe);
        WebElement tryIt = driver.findElement(By.xpath("//button[.='Try it']"));
        tryIt.click();

        // Step 3: Switch to the new window that opened
        /*List<String> handles = new ArrayList<>(driver.getWindowHandles());
        for (String string : handles) {
            if (driver.getWindowHandle().equals(string)) {
                driver.switchTo().window(string);
            }
        }*/
        // Step 4: Switch back to the original window by using the window handle
        driver.switchTo().window(currentHandle);

    }
}
