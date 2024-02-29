package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C48_FileDownload extends TestBase {
    //    Go to URL: https://the-internet.herokuapp.com/download
    //    Download selenium-snapshot.png
    //    Verify if the file downloaded successfully.
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement seleniumSnapshot = driver.findElement(By.xpath("//a[.='selenium-snapshot.png']"));
        seleniumSnapshot.click();
        Thread.sleep(5000);

        String inrilenlerPath = "C:\\Users\\sivas\\Downloads\\";
        String filePath = inrilenlerPath+"s" +
                "";
        assertTrue(Files.exists(Paths.get(filePath)));


    }
   @Test//Bütün linklerin çalıştığını test et.
    public void testAll() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

    }
    @Test//Bütün linklerin çalıştığını test et.
    public void testAll2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

    }
}
// /Users/josephhunter/Downloads/sample.txt













