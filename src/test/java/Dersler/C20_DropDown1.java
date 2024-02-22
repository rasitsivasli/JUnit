package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C20_DropDown1 {
    //Dropdown : acilir pencere
    //Dropdownlar ozel etkilesimler gerektirdiginden dolayi Selenium bize dropdownlar icin ayri bir class olusturmustur..
    //Class-> Select

    /*Dropdownlar ile calisirken
        * <select> elementi locate edilir  : //select[@id='oldSelectMenu']
        *  select elementi kullanilarak select objesi olusturulur
            Select select = new Select(webElement)
        *  select objesi araciligiyla metodlar kullanilir..
            1-selectByIndex() : option elementinin indexi
            2-selectByValue() : option elementinin value attribute u
            3-selectByVisibleText(): option elementinin gorunur yazisi
        //Select elementlerinde info amaciyla kullanilan methodlar
         select.getAllSelectedOptions(); -> multi selectte secili tum degerleri bize return eden methoddur.
         select.getFirstSelectedOption(); -> Secili ilk option elementini bize getirir.
         select.getOptions(); -> select elementinin tum optionlarini liste halinde return eder
         select.isMultiple(); -> select elementinin multiple secime uygun olup olmadigni bize boolean olarak return eder.

        // 1- deselectByIndex() -> option elementini index ile  kaldirir
        // 2- deselectByValue() -> option elemenini value attribute ile kaldirir
        // 3- deselectByVisibleText() -> option elementini gorunur yazisi (contenti) ile kaldirir
        // 4- deselectAll() -> Butun secimleri kaldirir.
     */


            /*
        Go to URL: https://demoqa.com/
        Click on Elements.
        Click on Checkbox.
        Verify if Home checkbox is selected.
        Verify that "You have selected" is visible.
             */


            /*
           Go to URL: https://demoqa.com/radio-button
           Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
           Her bir seçenek seçildiğinde aşağısında çıkan text'leri konsolda yazdırınız.
            */
    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterAll
    public static void tearDown() {
       // driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        WebElement elements = driver.findElement(By.xpath("//*[.='Elements']"));
        elements.click();
        Thread.sleep(2000);
        WebElement check = driver.findElement(By.xpath("//*[@class='btn btn-light ']//span[text()='Check Box']"));
        check.click();
        Thread.sleep(2000);
        WebElement verify = driver.findElement(By.xpath("//h1[.='Check Box']"));
        System.out.println("verify.getText() = " + verify.getText());//1. yol
        assertTrue(verify.isDisplayed());//2. yol
        WebElement home = driver.findElement(By.xpath("//span[text()='Home']"));
        home.click();
        //assertTrue(home.isSelected());
        WebElement youHaveSelected = driver.findElement(By.xpath("//*[contains(text(),'You have selected :')]"));
        System.out.println("youHaveSelected.getText() = " + youHaveSelected.getText());

        Thread.sleep(2000);


    }
}
