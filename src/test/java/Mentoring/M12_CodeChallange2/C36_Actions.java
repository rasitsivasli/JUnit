package Mentoring.M12_CodeChallange2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C36_Actions extends TestBase {
  /*sendKeys(): Sends a series of keys to the element
    keyUp(): Performs key release
    keyDown(): Performs keypress without release*/
    //Goto page:https://www.calculator.de/bmi-rechner.html
    //Locate:
    //Größe:168
    //Gewicht:65
    //Alter:34
    //Geschlecht:Frau
    //Click BERECHNEN
    //Verify :"Ihr BMI liegt bei 23,0 kg/m²" text

    @Test
    public void test() {

        driver.get("https://www.calculator.de/bmi-rechner.html");
        WebElement grose = driver.findElement(By.xpath("//*[@id=\"height\"]"));
        actions
                .click(grose).sendKeys("168")
                .sendKeys(Keys.TAB)
                .sendKeys("65")
                .sendKeys(Keys.TAB)
                .sendKeys("34")
                .sendKeys(Keys.TAB)
                .sendKeys("F")
                .sendKeys(Keys.TAB,Keys.ENTER)
                .perform();

        WebElement verify = driver.findElement(By.xpath("//p[text()='Ihr BMI liegt bei ']"));

        String actual = verify.getText();
        String expected = "Ihr BMI liegt bei 23,0 kg/m²";

        //Verify :"Ihr BMI liegt bei 23,0 kg/m²" text
        assertTrue(actual.contains(expected));

    }
}
