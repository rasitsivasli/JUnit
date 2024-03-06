package Mentoring.M13_FileExist;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileExist extends TestBase {
    /*
   http://autopract.com/selenium/download.html
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://autopract.com/selenium/download.html");
        WebElement downlooad = driver.findElement(By.xpath("//*[@id=\"download\"]"));

        downlooad.click();
        Thread.sleep(5000);


        String home = System.getProperty("user.home");
        String dosyaName = "sample2.csv";
        String filePath = home +"\\Downloads\\"+ dosyaName;//"C:\Users\sivas\Downloads\sample2.csv"

        //    Verify if the file downloaded successfully.
        assertTrue(Files.exists(Paths.get(filePath)));
    }
}

