package HOMEWORK.H06_KeyBoardActions_RobotClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass extends TestBase {
    /*
Amazona gidin
robot ile sayfanın en altına gidin
"Back to top" weblementini clickleyin
javascriptexecutor ile sayfanın altındaki (footer bölümündeki logo) Amazon logosunu clickleyin (scroll yapmadan, direkt clickleyin)
Actions ile Arama kutusuna "ClarusWay" yazdırıp aratın
*/
    @Test
    public void test1() throws AWTException, InterruptedException {
        driver.get("https://www.amazon.com/");
        if (driver.findElement(By.xpath("//*[.='Try different image']")).isDisplayed()){
            driver.findElement(By.xpath("//*[.='Try different image']")).click();
        }
        WebElement fortFahren = driver.findElement(By.xpath("//span[@class='a-button-inner'][1]"));
        fortFahren.click();

        Thread.sleep(2000);


       // JavascriptExecutor ile sayfanın en altına gidin
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        //"Back to top" weblementini clickleyin
        WebElement backToTab= driver.findElement(By.className("navFooterBackToTopText"));
        js.executeScript("arguments[0].click();", backToTab);
        Thread.sleep(2000);

        //javascriptexecutor ile sayfanın altındaki (footer bölümündeki logo) Amazon logosunu clickleyin (scroll yapmadan, direkt clickleyin)
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        WebElement amazonLogo= driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']"));

        js.executeScript("arguments[0].click();", amazonLogo);
        Thread.sleep(2000);

        //Actions ile Arama kutusuna "ClarusWay" yazdırıp aratın
        WebElement searchBox= driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        actions.click(searchBox).sendKeys("ClarusWay", Keys.ENTER).perform();
    }
}

