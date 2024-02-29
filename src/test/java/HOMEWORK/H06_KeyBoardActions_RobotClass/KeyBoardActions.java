package HOMEWORK.H06_KeyBoardActions_RobotClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class KeyBoardActions extends TestBase {

// https://www.google.com/ u ac
// Arama kismina  keyboard Actionlarla "Scroll Methodlar"  yaz
// Büyük harfleri klavyedeki SHIFT tuşuyla yazdırınız.

    @Test
    public void testKeyboardActions() {
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));

        actions
                .click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("croll ")
                .keyDown(Keys.SHIFT)
                .sendKeys("m")
                .keyUp(Keys.SHIFT)
                .sendKeys("ethodlar")
                .perform();

    }
}
