package HOMEWORK.H13_AmazonTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.security.Key;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class amazon extends TestBase {

/*
    Amazon Senaryosu
//https://www.amazon.com.tr/ sitesi açılır.
//Ana sayfanın açıldığı kontrol edilir.
//Çerez tercihlerinden Çerezleri kabul et seçilir.
//Siteye login olunur.
//Login işlemi kontrol edilir.
//Hesabım bölümünden "Virgosol Liste" isimli yeni bir liste oluşturulur.
//Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
//Bilgisayar kategorisi seçildiği kontrol edilir.
//Arama alanına msi yazılır ve arama yapılır.
//Arama yapıldığı kontrol edilir.
//Arama sonuçları sayfasından 2. sayfa açılır.
//2'inci sayfanın açıldığı kontrol edilir.
//Sayfadaki 2'inci ürün oluşturulan "Virgosol Liste" listesine eklenir.
//2'inci Ürünün listeye eklendiği kontrol edilir.
//Hesabım  Alışveriş Listesi sayfasına gidilir.
//"Alışveriş Listesi" sayfası açıldığı kontrol edilir.
//Eklenen ürün Virgosol Liste'sinden silinir.
//Silme işleminin gerçekleştiği kontrol edilir.
//Virgosol Liste'si silinir.
//Üye çıkış işlemi yapılır.
//Çıkış işleminin yapıldığı kontrol edilir.
//Not: Virgosol Liste'si task yeniden çalıştırıldığında sorun olmaması için silinmektedir.
     */

    @Test
    public void test() throws InterruptedException  {

        //https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        if (driver.findElement(By.partialLinkText("Try different image")).isDisplayed()){
            driver.findElement(By.partialLinkText("Try different image")).click();
        }

        //Ana sayfanın açıldığı kontrol edilir.
        getFullScreenMethos(driver);

        //Çerez tercihlerinden Çerezleri kabul et seçilir.
        WebElement acceptButton = driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]"));
        Thread.sleep(3000);
        if (acceptButton.isDisplayed()){
            acceptButton.click();
        }

        //Siteye login olunur.
        WebElement loginHover = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        WebElement login = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions
                .moveToElement(loginHover)
                .click(login)
                .perform();

        WebElement eMail = driver.findElement(By.id("ap_email"));
        eMail.sendKeys("sivaslirasit@gmail.com", Keys.ENTER);

        WebElement passWord = driver.findElement(By.id("ap_password"));
        passWord.sendKeys("Rs34551040", Keys.ENTER);


        //Login işlemi kontrol edilir.
        WebElement verify = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Thread.sleep(3000);
        getScreenShotMethod(verify);

        //Hesabım bölümünden "Virgosol Liste" isimli yeni bir liste oluşturulur.
        WebElement loginHover2 = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        WebElement neuList = driver.findElement(By.xpath("(//span[text()='Neue Liste anlegen '] )[1]"));
        actions
                .moveToElement(loginHover2)
                .click(neuList)
                .perform();

        WebElement neuListeButton = driver.findElement(By.className("a-button-input"));// yeni liste butonu bulunuyor
        Thread.sleep(2000);
        neuListeButton.click();
        WebElement listName = driver.findElement(By.id("list-name"));
        Thread.sleep(3000);
        listName.clear();// Daha önceki liste ismi siliniyor
        listName.sendKeys("Virgosol Liste");

        Thread.sleep(3000);
        WebElement listAnlegen = driver.findElement(By.xpath("//span[@class='a-button a-button-primary']"));
        listAnlegen.click();

        //Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        WebElement searchBox = driver.findElement(By.id("searchDropdownBox"));
        actions
                .click(searchBox)
                .sendKeys("c",Keys.ENTER)
                .perform();
        Thread.sleep(3000);

        //Bilgisayar kategorisi seçildiği kontrol edilir.
        assertTrue(searchBox.getText().contains("Computer"));

        //getScreenShotMethod(searchBox);


        //Arama alanına msi yazılır ve arama yapılır.
        WebElement searchBox3 = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox3.sendKeys("msi",Keys.ENTER);

        Thread.sleep(3000);

        //Arama yapıldığı kontrol edilir.
        WebElement verifyMsi = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Thread.sleep(3000);
        assertTrue(verifyMsi.getText().contains("msi"));

        //Arama sonuçları sayfasından 2. sayfa açılır.


        //2'inci sayfanın açıldığı kontrol edilir.
        //Sayfadaki 2'inci ürün oluşturulan "Virgosol Liste" listesine eklenir.
        //2'inci Ürünün listeye eklendiği kontrol edilir.
        //Hesabım  Alışveriş Listesi sayfasına gidilir.
        //"Alışveriş Listesi" sayfası açıldığı kontrol edilir.
        //Eklenen ürün Virgosol Liste'sinden silinir.
        //Silme işleminin gerçekleştiği kontrol edilir.
        //Virgosol Liste'si silinir.
        //Üye çıkış işlemi yapılır.
        //Çıkış işleminin yapıldığı kontrol edilir.
        //Not: Virgosol Liste'si task yeniden çalıştırıldığında sorun olmaması için silinmektedir.
        //Print the entire table




    }
}
