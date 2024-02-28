package HOMEWORK.H05_WindowHandle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.WindowType.TAB;
import static org.openqa.selenium.WindowType.WINDOW;

public class HomeWork20 extends TestBase {
    //Go to URL: https://the-internet.herokuapp.com/windows
//Verify the text: "Opening a new window"
//Verify the title of the page is "The Internet"
//Click on the "Click Here" button
//Verify the new window title is "New Window"
//Go back to the previous window and then verify the title: "The Internet"

    @Test
    public void test2() throws InterruptedException {

        //Go to URL: https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        String mainHandle = driver.getWindowHandle();

        //Verify the text: "Opening a new window"
        WebElement element1 = driver.findElement(By.xpath("//*[.='Opening a new window']"));
        assertTrue(element1.isDisplayed());

        //Verify the title of the page is "The Internet"
        assertTrue(driver.getTitle().contains("The Internet"));

        //Click on the "Click Here" button
        WebElement element2 = driver.findElement(By.xpath("//a[.='Click Here']"));
        element2.click();

        //Verify the new window title is "New Window"
        Set<String> windowhandleList = driver.getWindowHandles();
        Iterator<String> iterator = windowhandleList.iterator();

        while (iterator.hasNext()) {
            String currentHandle = iterator.next();
            driver.switchTo().window(currentHandle);

            if (driver.getTitle().contains("New Window")){
                driver.switchTo().window(currentHandle);
                break;
            }
        }
        assertEquals("New Window", driver.getTitle());

        //Go back to the previous window and then verify the title: "The Internet"

        driver.switchTo().window(mainHandle);
        assertTrue(driver.getTitle().contains("The Internet"));





    }
}
