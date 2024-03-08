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

public class WindowHandle extends TestBase {
    //Goto İkas Page: https://ikas.com/
    //Handle Cookies
    //Scroll down page (Use Javascript)
    //Select Language Almanca
    //Click "Devam" button
    // Verify Titlehttps://ikas.com/de

    @Test
    public void test1() throws InterruptedException {
        //Go to the above URL.
        driver.get("https://ikas.com/");

        //cerezler icin
        driver.findElement(By.xpath("//*[.='Accept all cookies']")).click();

        WebElement german = driver.findElement(By.xpath("//span[.='German']"));

        //Scroll down page (Use Javascript)
        //Select Language Almanca
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", german);
        Thread.sleep(2000);

        //Click "Devam" button
        WebElement start = driver.findElement(By.id("header-primary-cta-de/"));
        start.click();

        // Verify Titlehttps://ikas.com/de
        WebElement flag = driver.findElement(By.xpath("//div[@class='selected-flag']"));
        getScreenShotMethod(flag);

        Assertions.assertTrue(driver.getCurrentUrl().contains("de"));
    }
}
