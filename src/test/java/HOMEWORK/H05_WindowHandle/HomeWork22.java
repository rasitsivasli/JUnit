package HOMEWORK.H05_WindowHandle;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork22 extends TestBase {
    // https://www.hepsiburada.com/ adresine gidin
// Sayfanın windowhandle değerini alın.
// iphone kelimesini aratın
// Sonuçlar arasından 3.ürünün fiyatını alın
// Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
// Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
// Herbir ürün sekmesindeki title'ı yazdırın
// Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın
// Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın

    @Test
    public void test2() throws InterruptedException {

        // https://www.hepsiburada.com/ adresine gidin
        driver.get("https://www.hepsiburada.com/kampanyalar");
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
        if (driver.findElement(By.xpath("//*[.='Kabul et']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Kabul et']")).click();
        }
        Thread.sleep(3000);

        // Sayfanın windowhandle değerini alın.
        // iphone kelimesini aratın

        WebElement searchBox = driver.findElement(By.xpath("//*[@aria-controls='react-autowhatever-1']"));
        searchBox.sendKeys("iphone", Keys.ENTER);



       // Sonuçlar arasından 3.ürünün fiyatını alın

        WebElement preis = driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[3]"));
        System.out.println("preis.getText() = " + preis.getText());

        // Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
        List<WebElement> list = driver.findElements(By.xpath("//div[@data-test-id='price-current-price']"));
        Set<String> windowhandleList = driver.getWindowHandles();

        for (int i = 0; i < 4; i++) {
            list.get(i).click();
            windowhandleList = driver.getWindowHandles();


        }

        // Herbir ürün sekmesindeki title'ı yazdırın
        for (String currentHandle : windowhandleList) {
            driver.switchTo().window(currentHandle);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        // Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
        for (String s : windowhandleList) {
            System.out.println("s = " + s);
        }

        // Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın

        for (String currentHandle : windowhandleList) {
            driver.switchTo().window(currentHandle);
            if (driver.getTitle().contains("iPhone 12")) {
                driver.switchTo().window(currentHandle);
                break;
            }
        }
        WebElement preis2 = driver.findElement(By.xpath("(//*[@id=\"offering-price\"]/span)[1]"));
        System.out.println("preis2.getText() = " + preis2.getText());

       // assertEquals(preis.getText().substring(0,6), preis2.getText());

        // Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın
        driver.switchTo().window(mainHandle);
        Thread.sleep(3000);
        driver.quit();
    }
}
