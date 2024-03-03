package Mentoring.M12_CodeChallange2;

import jdk.dynalink.linker.LinkerServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.WindowType.TAB;
import static org.openqa.selenium.WindowType.WINDOW;

public class WindowHandle extends TestBase {
    //Goto website:https://koch-mit.de/
    //Click MediaMarket Link
    //Verify new tab open
    //Get WindowHandles
    //In the mediamarket website input "Samsung"
    //Click Enter verfiy: "Samsung bei MediaMarkt" text include
    //Go Back Koch website input text box pizza
    //187 Suchergebnisse gefunden für "Pizza".

    @Test
    public void test1() throws InterruptedException {
        //Go to the above URL.
        driver.get("https://koch-mit.de/");

        //cerezler icin
        driver.findElement(By.partialLinkText("Alle zulassen")).click();

        String firstHandle = driver.getWindowHandle();
        System.out.println("firstHandle = " + firstHandle);

        //Click MediaMarket Link
        WebElement mediaMarkt = driver.findElement(By.xpath("(//span[.='powered by MediaMarkt/Saturn'])[1]"));
        Thread.sleep(2000);
        mediaMarkt.click();

        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        System.out.println("handles = " + handles);
        for (String handle : handles) {
            if (!handle.contains(firstHandle)) {
                driver.switchTo().window(handle);
            }
        }
        if (driver.findElement(By.xpath("(//span[@class='sc-a8663f6a-0 iWuUrL'])[21]")).isDisplayed()) {
            driver.findElement(By.xpath("(//span[@class='sc-a8663f6a-0 iWuUrL'])[21]")).click();
        }

        //In the mediamarket website input "Samsung"
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search-form\"]"));
        searchBox.click();
        searchBox.sendKeys("Samsung", Keys.ENTER);


        //Click Enter verfiy: "Samsung bei MediaMarkt" text include
        WebElement verify = driver.findElement(By.xpath("//*[.='Samsung bei MediaMarkt']"));
        Assertions.assertEquals("Samsung bei MediaMarkt",verify.getText());

        //Go Back Koch website input text box pizza
        driver.switchTo().window(firstHandle);
        String titlePizza = driver.getTitle();

        //187 Suchergebnisse gefunden für "Pizza".

        WebElement searchBoxPizza = driver.findElement(By.xpath("(//*[@id=\"q\"])[2]"));

        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", searchBoxPizza);
        Thread.sleep(2000);
        searchBoxPizza.sendKeys("Pizza", Keys.ENTER);

        WebElement verify2 = driver.findElement(By.tagName("h1"));
        Assertions.assertEquals("187 Suchergebnisse gefunden für \"Pizza\".",verify2.getText());

    }
}
