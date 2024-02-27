package Mentoring.M01_RadioButton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class besipiel {
    /*
       Goto https://practice.expandtesting.com/checkboxes
    1-İlk checkbox ceçili değil ise seçelim
    2-İkinci chekbox seçili iken seçimi kaldıralım.Seçilimi olmadığını test edelim.
    3-Bu menüde toplam kaç tane check box var sayısını yazdıralım
    4-En sonda tüm chekboxların seçili olduğunu for döngüsü ile kontrol edelilm.
     */
    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://practice.expandtesting.com/checkboxes");
    }

    @AfterAll
    public static void tearDown() {
        // driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@class='form-check-input'])[1]"));
        if (!checkBox1.isSelected()) checkBox1.click();
        Thread.sleep(2000);

        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='checkbox2']"));
        if (checkBox2.isSelected()) checkBox2.click();
        Thread.sleep(2000);
        List<WebElement> listRadiButton = driver.findElements(By.xpath("//*[@type='checkbox']"));
        System.out.println("listRadiButton.size() = " + listRadiButton.size());
        for (WebElement each : listRadiButton) {
            if (!each.isSelected()) {
                each.click();
            }
        }
        for (WebElement each : listRadiButton) {
            if (!each.isSelected()) {
                assertTrue(false);
            }
        }
    }
}
