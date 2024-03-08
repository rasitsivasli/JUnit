package Mentoring.M18_JavaExucetur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;

public class WindowHandle3 extends TestBase {
    //Goto Page: https://fmig-online.de/
    //Hower to " Unsere Mitglieder" menu
    //Click: Brot- & Backwaren link
    //Verify url:  "https://fmig-online.de/kategorie/brot-backwaren/"


    @Test
    public void test1() throws InterruptedException {
        //Goto Page: https://fmig-online.de/
        driver.get("https://fmig-online.de/");

        if (driver.findElement(By.xpath("(//p[@class='_brlbs-accept'])[1]")).isDisplayed()) {
            driver.findElement(By.xpath("(//p[@class='_brlbs-accept'])[1]")).click();
        }
        Thread.sleep(2000);

        //Hower to " Unsere Mitglieder" menu
        WebElement unsereMitglieder = driver.findElement(By.id("our-members"));
        WebElement brot = driver.findElement(By.partialLinkText("Brot- & Backwaren"));
        actions
                .moveToElement(unsereMitglieder)
                .click(brot)
                .perform();

        //Click: Brot- & Backwaren link


        //Verify url:  "https://fmig-online.de/kategorie/brot-backwaren/"
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("Food Made in Germany"));
    }
}
