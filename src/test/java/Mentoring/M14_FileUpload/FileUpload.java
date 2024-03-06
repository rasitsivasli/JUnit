package Mentoring.M14_FileUpload;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUpload extends TestBase {
    //Goto page: https://kitchen.applitools.com/ingredients/file-picker
    @Test
    public void fileupload() throws InterruptedException {

        driver.get("https://kitchen.applitools.com/ingredients/file-picker");
        WebElement dosyaSec = driver.findElement(By.id("photo-upload"));

        //Find the path of the file that you want to upload.
        String path = System.getProperty("user.home") + "\\Downloads\\download.jpeg";
        dosyaSec.sendKeys(path);
        Thread.sleep(3000);

        //Verify the upload message.
        WebElement verify = driver.findElement(By.id("photo-upload-label"));
        assertTrue(verify.isDisplayed());


    }
}

