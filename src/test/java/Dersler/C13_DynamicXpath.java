package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C13_DynamicXpath {
     /*
    interview larda dinamik eleman nedir ? ne nasıl bulursunuz ?
   Sayfa yenilendiğinde id ler veya locator lar değişiyorsa buna dinamik eleman denir.
   Aşağıdaki fonksiyonlar ile bulunur.

   Özet Bilgi
    u_0_f7
    u_1_f7
    u_2_f7
    u_3_f7
    u_4_f7
    u_6_f7

    u_ başlıyor
    _f7 bitiyor

    a[id^='u_'][id$='_f7']


    CSS de
    ^ -> ile başlayan
    $ -> ile biten
    * -> içinde geçen

    cssSelector("input[id^='u_'][id$='_b2']   cssSelector("input[id^='u_'][id$='_Wd']

    Xpath
    //a[starts-with(@id,'u_')] -> ile başlayan
    //a[ends-with(@id,'_f7')]    -> ile biten
    //a[contains(@id,'u_')]    -> içinde geçen
     */

}
