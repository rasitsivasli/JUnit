package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C08_WebElementCommands {
//    sendKeys(String keys) methodu elementimize gonderilen degerleri klavyeyle yazarmis gibi gonderir
//    isDisplayed() bize boolean ifadeler dondurur!!!!!!!!!! Elementin sayfada goruntulenip goruntulenmedigi bilgisini verir
//    isSelected() methodumuz bize elementin secili olup olmadigi bilgisini verir. (checkbox, radio)
//    isEnabled() bir elementin aktif mi degil mi oldugunun bilgisini verir (button ve girdi yapilan elementlerde kullanilabilir)
//    submit() methodu formlari submit etmemize yani gondermemize yardimci olur. ENTER tusunun gorevini gorur.
//    click() methodu bir elemente sol tiklamamizi saglar.
//    getLocation() methodu bize elementin konumunu verir
//    clear() methodu input alanlarindaki yazilarin temizlenmesini saglar.
//    getText() methodu elementin contentini bize verir
//    getAttribute(String key) methodu bize elementin istedigimiz attribute degerini getirir.
//    getSize() elementin boyutunu bize verir.
static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        if (driver.findElement(By.xpath("//*[.='Try different image']")).isDisplayed()){
            driver.findElement(By.xpath("//*[.='Try different image']")).click();
        }
    }
    @Test
    public void test1() throws InterruptedException {

        WebElement searchAmazon = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchAmazon.clear();
        Thread.sleep(2000);
        searchAmazon.sendKeys("smart watch"+Keys.ENTER);
        Thread.sleep(2000);
        WebElement garminWatch = driver.findElement(By.xpath("//*[@id='p_89/Garmin']/span/a/span"));
        garminWatch.click();
        Thread.sleep(2000);
        WebElement garminWatchClick = driver.findElement(By.xpath("//html[@data-aui-build-date='3.24.1-2024-02-13']"));
        garminWatchClick.isSelected();
        WebElement resultText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        assertTrue(resultText.getText().contains("smart watch"));

    }


    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
