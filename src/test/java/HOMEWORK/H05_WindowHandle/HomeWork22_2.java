package HOMEWORK.H05_WindowHandle;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork22_2 extends TestBase {
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

        driver.get("https://www.hepsiburada.com/");
        String firstHandle = driver.getWindowHandle();
        System.out.println("firstHandle = " + firstHandle);
        if (driver.findElement(By.xpath("//*[.='Kabul et']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Kabul et']")).click();
        }
        Thread.sleep(2000);
        if (driver.findElement(By.xpath("//*[.='Consent']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Consent']")).click();
        }

        Thread.sleep(2000);
        WebElement searchbox1= driver.findElement(By.xpath("//div[@class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']"));
        searchbox1.click();
        WebElement searchbox2= driver.findElement(By.xpath("//input[@type='text']"));
        searchbox2.sendKeys("iphone"+ Keys.ENTER);
        Thread.sleep(2000);
        WebElement thirdPrice= driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[3]"));
        String thirdPriceText= thirdPrice.getText();
        for (int i = 0; i < 5; i++) {
            WebElement eleman = driver.findElement(By.xpath("//li[@id='i"+i+"']"));
            eleman.click();
        }
        Thread.sleep(10000);
        Set<String> handles = driver.getWindowHandles();
        WebElement thirdPrice2= thirdPrice;
        String thirdPrice2Text="";
        for (String handle : handles) {
            System.out.println(handle);
            System.out.println("driver.switchTo().window(handle).getTitle() = " + driver.switchTo().window(handle).getTitle());
            if (driver.getTitle().contains("iPhone 12")){
                thirdPrice2=driver.findElement(By.xpath("//*[@id=\"offering-price\"]/span[1]"));
                thirdPrice2Text=thirdPrice2.getText();
                break;
            }
        }

        thirdPriceText=thirdPriceText.substring(0,6);
        System.out.println("thirdPriceText = " + thirdPriceText);
        System.out.println("thirdPrice2Text = " + thirdPrice2Text);
        assertEquals(thirdPriceText,thirdPrice2Text);
    }
}
