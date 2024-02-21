package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--accept-cookies");//çerezlerei kabul etmek için
        options.addArguments("--disable-popup-blocking");//Pop-up pencereleri engellemek için
        driver = new ChromeDriver(options);// ChromeOptions'u driver'ımıza tanıtıyoruz.
        /*if (driver.findElement(By.xpath("//button[starts-with(@id,'u_0_k')]")).isDisplayed()){
            driver.findElement(By.xpath("//button[starts-with(@id,'u_0_k')]")).click();
        }*/
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
    }

    @AfterAll
    public static void tearDown() {
        //driver.close();
    }//Close driver.

    /*  @Test
      public void test() throws InterruptedException {
          WebElement userNameBox = driver.findElement
                  (By.xpath("//input[starts-with(@placeholder,'E-Mail-Adresse oder Telefonnummer')]"));
          userNameBox.sendKeys("abc@gmail.com");
          Thread.sleep(3000);
          WebElement passWordBox = driver.findElement
                  (By.xpath("//input[contains(@data-testid,'pass')]"));
          passWordBox.sendKeys("1234");
          Thread.sleep(3000);
          WebElement loginButton = driver.findElement
                  (By.xpath("//button[contains(text(),'Anmelden')]"));
      }*/
    @Test// dynamic
    public void test2() throws InterruptedException {
        WebElement userNameBox = driver.findElement
                (By.xpath("//div[starts-with(@class,'_6')]//input[contains(@placeholder,'Telefonnummer')]"));
        userNameBox.sendKeys("abc@gmail.com");
        Thread.sleep(3000);
       WebElement passWordBox = driver.findElement
                (By.xpath("//div[@id='reg_pages_msg']/preceding-sibling::div//input[@id='pass']"));// preceding-sibling ust taraf anlamina geliyor.
        passWordBox.sendKeys("1234");
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement
                (By.xpath("//div[@class='_6ltg']/button"));// buradaki "/" 1. derecedeki cocuk anlamina geliyor
    }

    }

