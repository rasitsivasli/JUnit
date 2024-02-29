package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

public class C42_ScrollActions extends TestBase {
    //Go to URL: https://www.amazon.com/
    //By using PAGE_UP, PAGE_DOWN, ARROW_UP, ARROW_DOWN
    //use actions scroll the page
    //scroll down
    //scroll up.

    @Test
    public void scrollPageUpDown() throws InterruptedException {
        driver.get("https://www.ebay.com/");

       /* if (driver.findElement(By.xpath("//a[.='Try different image']")).isDisplayed()) {
            driver.findElement(By.xpath("//a[.='Try different image']")).click();
        }*/
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
    }

    @Test
    public void scrollArrowDown() throws InterruptedException {
        driver.get("https://www.ebay.com/");

       /* if (driver.findElement(By.xpath("//a[.='Try different image']")).isDisplayed()) {
            driver.findElement(By.xpath("//a[.='Try different image']")).click();
        }*/
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
    }

    @Test
    public void scrollMoveToElement() throws InterruptedException {
        driver.get("https://www.ebay.com/");

       /* if (driver.findElement(By.xpath("//a[.='Try different image']")).isDisplayed()) {
            driver.findElement(By.xpath("//a[.='Try different image']")).click();
        }*/

        WebElement faceBookIcon = driver.findElement(By.xpath("(//a[@class='thrd gf-i'])[1]"));
        actions.moveToElement(faceBookIcon).click().perform();
    }


    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");

    }
}
