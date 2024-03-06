package utils;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class TestBase {
        /*
     TestBase Class : Her test class’inda tekrar tekrar yazdigimiz setup ve teardown method’lari tekrar
    yazmaktan kurtulmak icin Java OOP konsept’I kullanarak olusturdugumuz bir class’dir
    -Test Base’I parent olarak Kabul eden class’lar hazirlik icin olusturdugumuz driver, setup( ) ve
    teardown( ) olusturmak zorunda kalmazlar, kendilerinde olmasa bile parent class’dan kullanilmis
    olur.
    -TestBase genelde testlerden farkli bir package’da oldugundan driver’i kullanabilmek icin public
    veya protected yapmamiz gerekir. Biz hep child class’lardan kullanacagimiz icin protected yapmayi
    tercih ettik
    -Bu class sadece child class’lardan inheritance ozellikleri ile kullanilsin istedigimizden, bu class’in
    obje olusturularak kullanilmasina engel olmak icin class’I abstract YAPABILIRIZ.

    -Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz.
    TestBase Class'ı sadece extends ile inherit ederek kullanacağız.
    Dolayısıyla oluşturduğumuz driver variable'i için protected access modifier seçiyoruz.
     */
        protected static WebDriver driver;
        protected static Actions actions;
        @BeforeAll
        public static void setup(){
            driver = new ChromeDriver();
            //driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            actions = new Actions(driver);
        }
        @AfterAll
        public static void tearDown(){
            //driver.quit();
        }
        public static void getFullScreenMethos(WebDriver driver){
            TakesScreenshot ts = (TakesScreenshot) driver; // driver nesnesi, TakesScreenshot arayüzüne cast edilir.
            File source = ts.getScreenshotAs(OutputType.FILE);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
            String date = LocalDateTime.now().format(formatter);

            File destination = new File("./testOutput/ScreenShots/" + date + ".png");

            try {
                FileUtils.copyFile(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    public static void getScreenShotMethod(WebElement element) {

        File source = element.getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        File destination = new File("./testOutput/ScreenShots/"+date+".png");

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
