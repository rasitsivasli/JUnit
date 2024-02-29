package Izinler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.TestBase;

public class alleCookiesErlauben extends TestBase {
    @Test
    public void test() {

        driver.get("http://facebook.com");
        if (driver.findElement(By.xpath("//*[.='Alle Cookies erlauben']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Alle Cookies erlauben']")).click();
        }
    }

}
