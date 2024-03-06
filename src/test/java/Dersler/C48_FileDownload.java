package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

        //    Download selenium-snapshot.png
        seleniumSnapshot.click();
        Thread.sleep(5000);
        String downloadPath = "C:\\Users\\sivas\\Downloads\\";
        String filePath = downloadPath + System.getProperty("file.separator") + "selenium-snapshot.png";

        //    Verify if the file downloaded successfully.
        assertTrue(Files.exists(Paths.get(filePath)));
    }

    @Test//Bütün linklerin çalıştığını test et.
    public void testAll() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

        List<WebElement> links = new ArrayList<>(driver.findElements(By.tagName("a")));
        System.out.println("links.size() = " + links.size());
        for (WebElement link : links) {
            assertTrue(link.isEnabled());
        }
        System.out.println("links.get(10).getText() = " + links.get(10).getText());
    }

    @Test//Bütün linklerin çalıştığını test et.
    public void testAll2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        List<WebElement> links = new ArrayList<>(driver.findElements(By.tagName("a")));
        System.out.println("links.size() = " + links.size());

        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        String downloadPath = "C:\\Users\\sivas\\Downloads\\";

        for (int i = 1; i < links.size()-1; i++) {
            System.out.println("Link Text = " + links.get(i).getText());
            jsexecutor.executeScript("arguments[0].click();", links.get(i));
            String filePath = downloadPath +"\\"+links.get(i).getText();
            Thread.sleep(5000);
            assertTrue(Files.exists(Paths.get(filePath)));
        }

    }
}














