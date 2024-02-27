package Mentoring.M07_CodeChallange1;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task5_DropDown_Select {
  /*   select objesi araciligiyla metodlar kullanilir..
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
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Print the result
    //Use Select class :
    //1-return all options for operators
    //2-select minus ,


    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
    }

    @Test
    public void test1() throws InterruptedException {
        int index=0;
        for (int i = 0; i < 3; i++) {

            Faker faker = new Faker();
            WebElement calc = driver.findElement(By.xpath("//*[@id=\"calculatetest\"]"));
            calc.click();

            WebElement nummer1 = driver.findElement(By.xpath("//*[@id=\"number1\"]"));
            nummer1.sendKeys(faker.number().digit());
            Thread.sleep(1000);

            WebElement nummer2 = driver.findElement(By.xpath("//*[@id=\"number2\"]"));
            nummer2.sendKeys(faker.number().digit());
            Thread.sleep(1000);

            WebElement funkt = driver.findElement(By.xpath("//*[@id=\"function\"]"));
            Select select = new Select(funkt);
            select.selectByIndex(index++);
            Thread.sleep(1000);

            WebElement button = driver.findElement(By.xpath("//*[@id=\"calculate\"]"));
            button.click();
            beforeAll();


        }
    }
}
