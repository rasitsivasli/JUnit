package Mentoring.M15_ExelData;

import Dersler.C51_ApachePoiGetData;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApachePoiReadExcel {
    //Muhtesem.xlsx dosyasındaki isimleri yazdırın
    //Muhtesem.xlsx Id'leri yazdırın
    //Yukardakaki isim ve Id leri bir Map'te toplayarak yazdırın

    @Test
    public void readExcel() throws IOException {
        // Add the excel file on the resources folder.
        // Open the file.
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\Muhtesem.xlsx";


        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);
        Workbook wb = WorkbookFactory.create(fis);


        Sheet sheet1 = wb.getSheet("Sayfa1");

        Map<String, String> map = new LinkedHashMap<>();// sirasiyla gelmesi icin yaptik
        for (int i = 0; i <= sheet1.getLastRowNum(); i++) {
            String ad = sheet1.getRow(i).getCell(0).toString();
            String yas = sheet1.getRow(i).getCell(2).toString();
            map.put(ad, yas);
        }
        map.forEach((key, value) -> System.out.println(key+"  "+ value));


    }
}
