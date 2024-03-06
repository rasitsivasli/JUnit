package Dersler;

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
import java.util.Date;

public class C54_ScreenShot2 extends TestBase {

    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Saving the image to  the path.
    //Getting screenshot of Orange HRM Logo.
    //Getting screenshot of  Orange HRM Page Section.

    @Test
    public void testScreenShot() throws IOException, InterruptedException {
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement orangeLogo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        Thread.sleep(3000);
        File source = orangeLogo.getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

        //Saving the image to  the path.
        File destination = new File("./testOutput/ScreenShots/orangeLogo"+date+".png");

        //Getting screenshot of Orange HRM Logo.
        FileUtils.copyFile(source, destination);

        //Getting screenshot of  Orange HRM Page Section.
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source2 = ts.getScreenshotAs(OutputType.FILE);
        File destination2 = new File("./testOutput/ScreenShots/orangeFullPage"+date+".png");
        FileUtils.copyFile(source2, destination2);
    }
}

