package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

import java.time.Duration;

public class C37_MouseActions extends TestBase {
    // Go to URL: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.

    @Test
    public void test(){
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        WebElement norway = driver.findElement(By.id("box101"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement us = driver.findElement(By.id("box103"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement korea = driver.findElement(By.id("box105"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));

        actions.dragAndDrop(oslo,norway).pause(Duration.ofSeconds(1))
                .dragAndDrop(stockholm,sweden).pause(Duration.ofSeconds(1))
                .dragAndDrop(washington,us).pause(Duration.ofSeconds(1))
                .dragAndDrop(copenhagen,denmark).pause(Duration.ofSeconds(1))
                .dragAndDrop(seoul,korea).pause(Duration.ofSeconds(1))
                .dragAndDrop(rome,italy).pause(Duration.ofSeconds(1))
                .dragAndDrop(madrid,spain).pause(Duration.ofSeconds(1))
                .perform();

    }

}
