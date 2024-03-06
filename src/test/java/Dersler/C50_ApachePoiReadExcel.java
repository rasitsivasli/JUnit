package Dersler;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C50_ApachePoiReadExcel {
    //Workbook  Excel dosyamız.
    //Sheet  Açık excel sekmesi (Sheet1, Sheet2, etc.)
    //Row (Satır)  Java, yalnızca içeride veri varsa satırları sayar.
    //Cells (Hücre)  Java her satıra bakar ve yalnızca hücrede veri varsa hücre sayısını sayar.

    //workbook(excel)>worksheet(sheet)> row(satir)>cell(hucre) -> hiyerarsi

    // Add the excel file on the resources folder.
    // Open the file.
    // Open the workbook using file input stream.
    // Open the first worksheet.
    // Go to first row.
    // Go to first cell on that first row and print.
    // Go to second cell on that first row and print.
    // Go to 2nd row first cell and assert if the data equal to Russia.
    // Go to 3rd row and print 2nd cell
    // Find the number of used row.
    // Print co   untry, area key value pairs as map object.
    // Verify that you have Türkiye on the list

    @Test
    public void readExcel() throws IOException {
        // Add the excel file on the resources folder.
        // Open the file.
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\excelfile.xlsx";
        String path2 = "C:\\Users\\sivas\\IdeaProjects\\Selenium_JUnit\\src\\test\\resources\\excelfile.xlsx";// manualy


        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);
        Workbook wb = WorkbookFactory.create(fis);


        // Open the first worksheet.
        Sheet sheet1 = wb.getSheet("Sayfa1");
        Sheet sheet2 = wb.getSheetAt(0);

        // Go to first row.

        Row row1 = sheet1.getRow(0);

        // Go to first cell on that first row and print.
        Cell cell1 = row1.getCell(0);
        System.out.println("cell1 = " + cell1);

        // Go to second cell on that first row and print.
        Cell cell2 = row1.getCell(1);
        System.out.println("cell2 = " + cell2);

        // Go to 2nd row first cell and assert if the data equal to Russia.
        Row row2 = sheet1.getRow(1);
        Cell cellR2C1 = row2.getCell(0);
        System.out.println("cellR2C1 = " + cellR2C1);
        assertEquals(cellR2C1.toString(), "Rusya");

        // Go to 3rd row and print 2nd cell
        Row row3 = sheet1.getRow(2);
        System.out.println("row3.getCell(1) = " + row3.getCell(1));

        //2. yol
        System.out.println("3. satir 2. hücre = " + sheet1.getRow(2).getCell(1));

        // Find the number of used row.
        //***getLastRowNum() index starts at 0 * checks the last row that is used
        //son kullanilan satirin index bilgisini bize verir..
        //son satır öncesindeki boş satırlar sonucu etkilemez.
        System.out.println("sheet1.getLastRowNum()+1 = " + (sheet1.getLastRowNum() + 1));// 0 dan basladigi icin 1 ekledik


        // Print country, area key value pairs as map object.
        //***getPhysicalNumberOfRows() index starts at 1  * checks the total rows that is used
        //kullanilan toplam satir sayisini bize verir,satirlar 1 den baslar, bos satir sayilmaz
        //yani fiziksel olarak mevcut olan satirlari sayar

        System.out.println(sheet1.getPhysicalNumberOfRows());

        // Print country, area key value pairs as map object.
        Map<String, String> countryMap = new HashMap<String, String>();
        for (int i = 0; i <= sheet1.getLastRowNum(); i++) {
            String country = sheet1.getRow(i).getCell(0).toString();
            String area = sheet1.getRow(i).getCell(1).toString();
            countryMap.put(country, area);
        }
        countryMap.forEach((key, value) -> System.out.println("Country: " + key + ", Area: " + value));


        //country-area bilgilerini key-value formatinda map gibi yazdiralim
        assertTrue(countryMap.containsKey("Türkiye"));


        System.out.println(C51_ApachePoiGetData.getDataStringSheet("Sayfa1",7,0));


        // excel de 2 sutun oldugu takdirde asagidaki sekilde yapilabilir.


        // Verify that you have Türkiye on the list
    }
}
/*
        Cell cell = WorkbookFactory.create(new FileInputStream(path)).getSheetAt(0).getRow(0).getCell(0);
        System.out.println("cellValue: "+WorkbookFactory.create(new FileInputStream(path)).getSheetAt(0).getRow(0).getCell(0));
 */

