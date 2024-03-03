package HOMEWORK.H08_FileExist;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileExist extends TestBase {
    /*
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login page valid credentials.
    //Download sample CSV file. pim->configuration->importData CSV file dosya yolu budur.
    //Verify if the file downloaded successfully.
     */

    @Test
    public void fileExist() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
        WebElement admin = driver.findElement(By.xpath("//input[@placeholder='Username']"));

        //Login page valid credentials.
        actions
                .click(admin)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("dmin")
                .perform();
        WebElement passWord = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        actions
                .click(passWord)
                .sendKeys("admin123")
                .perform();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", loginButton);

        //Download sample CSV file. pim->configuration->importData CSV file dosya yolu budur.
        WebElement pim = driver.findElement(By.xpath("//span[text()='PIM']"));
        jsexecutor.executeScript("arguments[0].click();", pim);

        WebElement configuration = driver.findElement(By.xpath("//span[text()='Configuration ']"));
        jsexecutor.executeScript("arguments[0].click();", configuration);

        WebElement dataImport = driver.findElement(By.xpath("(//a[text()='Data Import'])"));
        jsexecutor.executeScript("arguments[0].click();", dataImport);

        WebElement download = driver.findElement(By.xpath("(//a[text()='Download'])"));
        download.click();

        String downloadPath = "C:\\Users\\sivas\\Downloads\\";
        String path = downloadPath  + "importData.csv";
        System.out.println("path = " + path);

        //Verify if the file downloaded successfully.
        assertTrue(Files.exists(Paths.get(path)));



    }
}

