package Mentoring.M17_Table;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;

public class WebTables extends TestBase {

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


    //Goto: "https://www.bundesliga.com/en/bundesliga/table"
    //Locate WebTable
    //How many rows
    //Print all rows
    //Get Screen Shoot include "Bayer"

    @Test
    public void test() throws InterruptedException {
        //Goto: "https://www.bundesliga.com/en/bundesliga/table"
        driver.get("https://www.bundesliga.com/en/bundesliga/table");
        WebElement acceptButton = driver.findElement(By.xpath("//*[.='Accept All Cookies']"));
        if (acceptButton.isDisplayed()) {
            acceptButton.click();
        }

        //Locate WebTable
        WebElement webTable1 = driver.findElement(By.tagName("table"));

        //How many rows
        List<WebElement> rows = webTable1.findElements(By.xpath(".//tbody/tr"));
        System.out.println("rows.size() = " + rows.size());


        // Tabela basligi icin
        System.out.println(webTable1.findElement(By.xpath("./thead/tr")).getText());

        //Print all rows
        for (WebElement row : rows) {
            String rowData = row.getText();
            System.out.println(rowData);
        }

        //Get Screen Shoot include "Bayern"
        WebElement bayern = driver.findElement(By.xpath("//span[normalize-space()='FC Bayern München']"));
        getScreenShotMethod(bayern);

        // Bayernin Puani
        System.out.println();
        WebElement bayernPunkt = webTable1.findElement(By.xpath("./tbody/tr[1]/td[13]/span"));
        System.out.println("bayernPunkt = " + bayernPunkt.getText());


    }
}
