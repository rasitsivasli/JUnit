package Dersler;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C52_WriteExcel {
    /*
        //Create an object of File class to open xlsx file.
        //Create an object of FileInputStream class to read excel file.
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
        //Create an object of FileInputStream class to read excel file.
        //Create an object of FileInputStream class to read excel file.
        //Creating workbook instance that refers to .xlsx file.
        //Creating a Sheet object.
        //Get all rows in the sheet.
        //Create a row object to retrieve row at index 3.
        //Create a cell object to enter value in it using cell Index.
        //Write the data in excel using output stream.

        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\excelData.xlsx";// burada yolu yaziyoruz
        FileInputStream fis = new FileInputStream(path1);//Burada önce alisa aliniyor . Cunku Java önce akisa alarak Bynery coduna ceviriyor ve sonra nesneye dönusuyor.
        Workbook wb = WorkbookFactory.create(fis);// burada yeni bir exell sayfayi creat ediyoruz
        Sheet refenzen = wb.createSheet("referenz"); // burada sayfa üretiyoruz ve ismini veriyoruz

        Row row3 = refenzen.createRow(2);  // burada 3. satiri üretiyoruz
        List<String> list = new ArrayList<>(Arrays.asList("ad", "soyad", "Kimlik no", "Yas"));// girilecek data bunlar..
        for (int i = 7; i < 11; i++) {
            row3.createCell(i).setCellValue(list.get(i-7));
        }

        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);
        fis.close();
        fos.close();
    }
}

