package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class C49_FileUpload extends TestBase {
    //Go to URL: https://the-internet.herokuapp.com/upload
    //Find the path of the file that you want to upload.
    //Click on Upload button.
    //Verify the upload message.
    @Test
    public void fileupload() throws InterruptedException {
        //Go to URL: https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));

        //Find the path of the file that you want to upload.
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\selenium_methodlar.pdf";
        dosyaSec.sendKeys(path);
        Thread.sleep(3000);

        //Click on Upload button.
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        //Verify the upload message.
        WebElement uploadedMessage = driver.findElement(By.tagName("h3"));
        assertTrue(uploadedMessage.isDisplayed());


    }
}

