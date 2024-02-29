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
        driver.get("https://www.hepsiburada.com/");
        String firstHandle = driver.getWindowHandle();
        System.out.println("firstHandle = " + firstHandle);
        if (driver.findElement(By.xpath("//*[.='Kabul et']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Kabul et']")).click();
        }
        Thread.sleep(2000);
        /*if (driver.findElement(By.xpath("//*[.='Consent']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Consent']")).click();
        }*/

        Thread.sleep(2000);
        WebElement searchbox1= driver.findElement(By.xpath("//div[@class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']"));
        searchbox1.click();
        WebElement searchbox2= driver.findElement(By.xpath("//input[@type='text']"));
        searchbox2.sendKeys("iphone"+ Keys.ENTER);
        Thread.sleep(2000);

       // Sonuçlar arasından 3.ürünün fiyatını alın

        WebElement preis = driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[3]"));
        String firstPreis = preis.getText().substring(0,6);


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
        String priceSecond = preis2.getText();

        assertEquals(firstPreis, priceSecond);

        // Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın
        driver.switchTo().window(firstHandle);
        Thread.sleep(3000);
        driver.quit();
    }
}
