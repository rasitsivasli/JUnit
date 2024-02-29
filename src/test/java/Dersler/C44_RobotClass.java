package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C44_RobotClass extends TestBase {
    //Go to URL: https://www.ebay.com/
    //Search for "Robot" by using RobotClass
    //scroll down to bottom
    //scroll up to top

    @Test
    public void test1() throws AWTException, InterruptedException {
        driver.get("https://www.ebay.com/");
        WebElement searchBox= driver.findElement(By.id("gh-ac"));
        searchBox.click();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);

        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);

        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);

        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        robot.mouseWheel(150);
        Thread.sleep(5000);
        robot.mouseWheel(-150);
    }
}

