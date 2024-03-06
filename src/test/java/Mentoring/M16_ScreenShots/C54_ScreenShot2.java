package Mentoring.M16_ScreenShots;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.io.IOException;

public class C54_ScreenShot2 extends TestBase {

    //Create methods in TestBase class
//getFullscreenShoot
//getSpecificScreenShoot
//Get Clarus page full screen shoot
//Get Specific Web Element scrren Shoot

    @Test
    public void testFullScreen() throws IOException, InterruptedException {
        driver.get("https://clarusway.com/");

        getFullScreenMethos(driver);// burada method olusturuldu

    }
    @Test
    public void testScreenShot() throws IOException, InterruptedException {
        driver.get("https://clarusway.com/");
    /*    WebElement element = driver.findElement(By.xpath())
        getScreenShotMethod();*/



    }
}

