package Izinler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class alleCookiesErlauben extends TestBase {
    @Test
    public void test() {

        WebElement acceptButton = driver.findElement(By.xpath("//*[.='Accept All']"));
        if (acceptButton.isDisplayed()){
            acceptButton.click();
        }
    }

}
