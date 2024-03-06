package HOMEWORK.H11_ScreenShot;

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

public class ScreenShot1 extends TestBase {
    // Go to n11.com.
    // Take Full Page Screenshot.
    // Spesific WebElement ScreenShot


    @Test
    public void takeFullPageScreenShot() throws IOException, InterruptedException {
        driver.get("https://www.n11.com/");

        // SCHADOW-ROOT oldugu icin
        Thread.sleep(3000);
        WebElement target = driver.findElement(By.tagName("efilli-layout-dynamic")).getShadowRoot()
                .findElement(By.cssSelector("div[id='480698fc-e6ac-41bc-a722-51059b783200']"));
        target.click();


        // Ekran görüntüsü almak için TakesScreenshot arayüzü kullanılır. Bu sadece tüm ekranin fotosu icin gerekli.
        TakesScreenshot ts = (TakesScreenshot) driver; // driver nesnesi, TakesScreenshot arayüzüne cast edilir.

        // Ekran görüntüsü alınır ve bir File nesnesine atanır.
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Ekran görüntüsünün adı için bir tarih formatı belirlenir.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String date = LocalDateTime.now().format(formatter);

        // Ekran görüntüsünün kaydedileceği dosyanın yolu belirlenir.
        File destination = new File("./testOutput/ScreenShots/n11FullPage" + date + ".png");

        // Ekran görüntüsü kaydedilir veya kopyalanmis olur.
        FileUtils.copyFile(source, destination);
    }

    // Spesific WebElement ScreenShot
    @Test
    public void takeSpesificWEScreenShot() throws IOException, InterruptedException {
        driver.get("https://www.n11.com/");
        WebElement logo = driver.findElement(By.xpath("//img[@alt='hayat sana gelir']"));
        File source = logo.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

        File destination = new File("./testOutput/ScreenShots/elementLogo"+date+".png");

        FileUtils.copyFile(source, destination);
    }
}

