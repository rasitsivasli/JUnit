package HOMEWORK.H10_ExelData;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteExcel {
    /*
        //Create an object of File class to open xlsx file.
        //Create an object of FileInputStream class to read excel file.
        //Creating workbook instance that refers to .xlsx file.
        //Creating a Sheet object.
        //Get all rows in the sheet.
        //Create a row object to retrieve row at index 3.
        //Create a cell object to enter value in it using cell Index.
        //Write the data in excel using output stream.
    */
    @Test
    public void writeExcel() throws IOException {
        //Create an object of File class to open xlsx file.
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\HomeWork.xlsx";// burada yolu yaziyoruz

        //Create an object of FileInputStream class to read excel file.
        FileInputStream fis = new FileInputStream(path1);

        //Creating workbook instance that refers to .xlsx file.
        Workbook wb = WorkbookFactory.create(fis);

        //Creating a Sheet object.
        Sheet sayfa = wb.getSheet("Sayfa1");

        //Get all rows in the sheet.
        for (int i = 0; i <= sayfa.getLastRowNum(); i++) {
            System.out.println("Row = " + sayfa.getRow(i).toString());
        }

        //Create a row object to retrieve row at index 7.
        Row r7 = sayfa.createRow(7);

        //Create a cell object to enter value in it using cell Index.
        r7.createCell(10).setCellValue("Rasit");

        //Write the data in excel using output stream.
        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);

        fis.close();
        fos.close();
    }
}

