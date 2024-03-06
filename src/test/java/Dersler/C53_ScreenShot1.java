package Dersler;

import org.apache.commons.io.FileUtils;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C53_ScreenShot1 extends TestBase {
    // Go to ebay.com.
    // Take Page ScreenShot.
    // Spesific WebElement ScreenShot

    // Take Page ScreenShot.
    @Test
    public void takeFullPageScreenShot() throws IOException {
        driver.get("https://www.ebay.com/");

        // Ekran görüntüsü almak için TakesScreenshot arayüzü kullanılır. Bu sadece tüm ekranin fotosu icin gerekli.
        TakesScreenshot ts = (TakesScreenshot) driver; // driver nesnesi, TakesScreenshot arayüzüne cast edilir.

        // Ekran görüntüsü alınır ve bir File nesnesine atanır.
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Ekran görüntüsünün adı için bir tarih formatı belirlenir.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String date = LocalDateTime.now().format(formatter);

        // Ekran görüntüsünün kaydedileceği dosyanın yolu belirlenir.
        File destination = new File("./testOutput/ScreenShots/ebayFullPage" + date + ".png");

        // Ekran görüntüsü kaydedilir veya kopyalanmis olur.
        FileUtils.copyFile(source, destination);
    }

    // Spesific WebElement ScreenShot
    @Test
    public void takeSpesificWEScreenShot() throws IOException, InterruptedException {
        driver.get("https://www.ebay.com/");
        WebElement ebayLogo = driver.findElement(By.id("gh-la"));
        File source = ebayLogo.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

        File destination = new File("./testOutput/ScreenShots/ebayLogo"+date+".png");

        FileUtils.copyFile(source, destination);
    }
}

