package HOMEWORK.H13_AmazonTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.security.Key;
import java.time.Duration;
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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @Test
    public void test() throws InterruptedException {

        //https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        if (driver.findElement(By.partialLinkText("Try different image")).isDisplayed()) {
            driver.findElement(By.partialLinkText("Try different image")).click();
        }

        //Ana sayfanın açıldığı kontrol edilir.
        getFullScreenMethos(driver);

        //Çerez tercihlerinden Çerezleri kabul et seçilir.
        WebElement acceptButton = driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]"));
        Thread.sleep(3000);
        if (acceptButton.isDisplayed()) {
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
        passWord.sendKeys("*********", Keys.ENTER);


        //Login işlemi kontrol edilir.
        WebElement verify = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Thread.sleep(3000);
        getScreenShotMethod(verify);

        //Hesabim bölümünde "Virgosol Liste" isimli bir liste var mi kontrol edilir
        //Eger yoksa liste olusturluacak.
        //"Virgosol Liste" elementini kontrol et
        WebElement loginHover2 = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions
                .moveToElement(loginHover2)
                .perform();
        try {
            WebElement virgosolListe = driver.findElement(By.xpath("(//span[text()='Virgosol Liste'])[1]"));
            assertTrue(virgosolListe.isDisplayed());
        } catch (NoSuchElementException e) {
            // Element bulunamadı, oluşturma işlemine geç
            virgosolListe();
        }

        //Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        //DropDown old. icin Select kullandim

        driver.navigate().refresh();// burada daha önce Virgosol Liste olusmussa hata almiyorum.
                                    // Ama olusmamissa hata almiyorum. O yuzden sayfayi yeniledim
        WebElement searchBox = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(searchBox);
        Thread.sleep(5000);
        select.selectByVisibleText("Computer");
        Thread.sleep(3000);
        //Bilgisayar kategorisi seçildiği kontrol edilir.
        assertTrue(searchBox.getText().contains("Computer"));

        //getScreenShotMethod(searchBox);
        getScreenShotMethod(searchBox);


        //Arama alanına msi yazılır ve arama yapılır.
        WebElement searchBox3 = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox3.sendKeys("msi", Keys.ENTER);
        Thread.sleep(3000);

        //Arama yapıldığı kontrol edilir.
        WebElement verifyMsi = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Thread.sleep(3000);
        assertTrue(verifyMsi.getText().contains("msi"));

        //Arama sonuçları sayfasından 2. sayfa açılır.
        WebElement zweiteSeite = driver.findElement(By.xpath("//a[@aria-label='Zu Seite 2']"));
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", zweiteSeite);

        //2'inci sayfanın açıldığı kontrol edilir.
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.endsWith("sr_pg_2"));

        //Sayfadaki 2'inci ürün oluşturulan "Virgosol Liste" listesine eklenir.
        WebElement zweiteProdukt = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        zweiteProdukt.click();
        WebElement addList = driver.findElement(By.cssSelector("#add-to-wishlist-button-submit"));
        addList.click();

        //2'inci Ürünün listeye eklendiği kontrol edilir.
        WebElement addVerifyKontrol = driver.findElement(By.xpath("(//span[@class='a-size-medium-plus huc-atwl-header-main'])[1]"));
        assertTrue(addVerifyKontrol.isDisplayed());

        //Hesabım  Alışveriş Listesi sayfasına gidilir.
        WebElement meineListe = driver.findElement(By.xpath("//a[text()='Meine Liste anzeigen']"));
        meineListe.click();

        //"Alışveriş Listesi" sayfası açıldığı kontrol edilir.
        WebElement verifyEinkaufList = driver.findElement(By.id("profile-list-name"));
        assertTrue(verifyEinkaufList.isDisplayed());

        //Eklenen ürün Virgosol Liste'sinden silinir.
        WebElement entfernen = driver.findElement(By.name("submit.deleteItem"));
        jsexecutor.executeScript("arguments[0].click();", entfernen);

        //Ürünün Silindigi kontrol edildi
        WebElement gelosht = driver.findElement(By.xpath("//div[text()='Gelöscht']"));
        assertTrue(gelosht.isDisplayed());


    }

    private void virgosolListe() throws InterruptedException {
        //Hesabım bölümünden "Virgosol Liste" isimli yeni bir liste oluşturulur.
        WebElement loginHover2 = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        WebElement neuList = driver.findElement(By.xpath("(//span[text()='Neue Liste anlegen '] )[1]"));
        actions
                .moveToElement(loginHover2)
                .pause(2)
                .click(neuList)
                .perform();
        WebElement eineListeErstellenButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("a-button-input"))); // yeni liste butonu bulunuyor
        eineListeErstellenButton.click();
        WebElement listName = wait.until(ExpectedConditions.elementToBeClickable(By.id("list-name")));
        listName.clear();// Daha önceki liste ismi siliniyor
        listName.sendKeys("Virgosol Liste");
        Thread.sleep(3000);
        WebElement listAnlegen = driver.findElement(By.xpath("//span[@class='a-button a-button-primary']"));
        listAnlegen.click();

    }
}
