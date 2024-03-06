package HOMEWORK.H12_WebTable;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;
import java.util.Scanner;

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


    //Go to URL: https://the-internet.herokuapp.com/tables
//Print the entire table
//Print All Rows
//Print Last row data only
//Print column 5 data in the table body
//Write a method that accepts 2 parameters
//parameter 1 = row number  parameter 2 = column number
//printData(3,4); => prints
//Write a method that accepts 3 parameters, parameter 3 = table id
//printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/tables");

        //Print the entire table
        WebElement webTable1 = driver.findElement(By.xpath("//table[@id='table1']"));
        List<WebElement> rows = webTable1.findElements(By.xpath(".//tbody/tr"));

        System.out.println(webTable1.findElement(By.xpath("./thead/tr")).getText());// baslik icin

        for (WebElement row : rows) {
            String rowData = row.getText();
            System.out.println(rowData);
        }

        //Print Last row data only
        System.out.println();
        System.out.println("Last Row = " + rows.getLast().getText());

        //Print column 5 data in the table body
        System.out.println();
        List<WebElement> columns = webTable1.findElements(By.xpath("./tbody//td[4]"));
        for (WebElement element : columns) {
            String col5 = element.getText();
            System.out.println(col5);
        }

        //printData(3,4); => prints
        System.out.println();
        String r3c4 = rows.get(3).findElement(By.xpath("./td[5]")).getText();
        System.out.println("r3c4 = " + r3c4);


        //Write a method that accepts 3 parameters, parameter 3 = table id
        //printData(3,4,"table1") => prints data in 3rd row 4th Column with table id

        printData(2,4,"table1");//Row u listeden aldigimiz icin 2 yazdik. Index 0 dan basliyor

    }
    private void printData(int r, int c, String table) {
        System.out.println("********************************************");
        WebElement webTable = driver.findElement(By.xpath("//table[@id='"+table+"']"));
        List<WebElement> rows = webTable.findElements(By.xpath(".//tbody/tr"));
        String cell = rows.get(r).findElement(By.xpath("./td["+c+"]")).getText();
        System.out.println("cell = " + cell);
    }
}
