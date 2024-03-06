package Training.T03_FileExist;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileExist extends TestBase {
    /*
   https://kids.dadabhagwan.org/knowledge-house/magazines/
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://kids.dadabhagwan.org/knowledge-house/magazines/");
        WebElement download = driver.findElement(By.xpath("(//h2/a//img)[1]"));

        download.click();
        Thread.sleep(5000);

        String home = System.getProperty("user.home");
        String dosyaName = "AEX-Feb-Eng-2024.pdf";
        String filePath = home +"\\Downloads\\"+ dosyaName;

        //    Verify if the file downloaded successfully.
        assertTrue(Files.exists(Paths.get(filePath)));
    }
}

