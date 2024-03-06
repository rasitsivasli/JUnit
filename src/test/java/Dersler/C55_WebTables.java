package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class C55_WebTables extends TestBase {

//<table>, bir web tablosunu tanımlamak için kullanılan HTML etiketidir.
//Tablonun başlığını tanımlamak için <th> kullanılırken ,
// web tablosu için sırasıyla satırları ve sütunları tanımlamak için <tr> ve <td> etiketleri kullanılır.
//table//tbody//tr  tbody içindeki tüm satırları döndürür.
//table//tbody//tr[1]  tbody'deki ilk satırı döndürür.
//table//tbody//tr[1]//td  İlk satırdaki tüm tablo hücrelerini döndürür.
//table//tbody//tr[1]//td[4]  tbody'deki ilk satırdaki 4. hücreyi döndürür.
//table//tbody//tr[4]//td[5]  4. satır 5. sütun
//table//tbody//tr[10]//td[2]  Satır 10 data 2
//table//tbody//tr//td[5]  5. sütundaki tüm satırları döndürür.

//Go to URL: http://demo.guru99.com/test/web-table-element.php
//To find third row of table
//To get 3rd row's 2nd column data
//Get all the values of a Dynamic Table

    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        Thread.sleep(3000);
        driver.switchTo().frame("gdpr-consent-notice");
        WebElement acceptButton = driver.findElement(By.xpath("//*[.='Alle akzeptieren']"));
        if (acceptButton.isDisplayed()) {
            acceptButton.click();
        }
        driver.switchTo().defaultContent();


        WebElement webTable = driver.findElement(By.xpath("//table[@class='dataTable']"));

        //To find third row of table
        System.out.println(webTable.findElement(By.xpath("./tbody/tr[3]")).getText());

        //To get 3rd row's 3rd column data
        System.out.println(webTable.findElement(By.xpath(".//tr[3]/td[3]")).getText());

        //Get all the values of a Dynamic Table

        int satirNum = webTable.findElements(By.xpath("./tbody/tr")).size();
        int sutunNum = webTable.findElements(By.xpath(".//tr[3]/td")).size();

        System.out.println(satirNum);
        System.out.println("*********************************************");
        System.out.println();
        System.out.println(webTable.findElement(By.xpath("./thead/tr")).getText());
        for (int i = 1; i <= satirNum; i++) {
            for (int j = 1; j <= sutunNum; j++) {
                String tdata = webTable.findElement(By.xpath(".//tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print(tdata + "  ");
            }
            System.out.println();
        }

    }
}
