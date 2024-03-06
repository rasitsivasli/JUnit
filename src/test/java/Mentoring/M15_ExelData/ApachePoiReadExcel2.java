package Mentoring.M15_ExelData;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ApachePoiReadExcel2 {
    //Muhtesem.xlsx yeni bir sayfa oluşturalım
//Oluşturduğumuz sayfaya isim,soy isim ve id bilgilerini içeren 2 satır oluşturun

    @Test
    public void readExcel() throws IOException {
        // Add the excel file on the resources folder.
        // Open the file.
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\Muhtesem.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path1);
        Workbook wb = WorkbookFactory.create(fis);


        Sheet sheet2 = wb.createSheet("Sayfa4");// burada yeni sayfa creat ediliyor

        List<String> list = new ArrayList<>(Arrays.asList("Muhtesem7li", "selenium", "AsyaHocamIle", "Ogreniyor"));// girilecek data bunlar..

        for (int i = 0; i < 5; i++) {
            if (sheet2.getRow(i) != null) {
                Row row = sheet2.createRow(i);
                for (int r = 0; r < list.size(); r++) {
                    row.createCell(r).setCellValue(list.get(r));
                }
            } else {
                Row row = sheet2.getRow(i);
                for (int r = 0; r < list.size(); r++) {
                    row.createCell(r).setCellValue(list.get(r));
                }

            }


        }

        FileOutputStream fos = new FileOutputStream(path1);
        wb.write(fos);
        fis.close();
        fos.close();

    }

    @Test
    public void readExcel2() throws IOException {

        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\Muhtesem.xlsx";
        FileInputStream fis = new FileInputStream(path1);// burada varolan excell akisa aliniyor, yani dönüstürülüyor..
        Workbook wb = WorkbookFactory.create(fis);// burada excell sayfasi creat ediliyor..


        if (wb.getSheet("Sayfa2") == null) {
            Sheet sheet2 = wb.createSheet("Sayfa2");
            cellMethod(sheet2);

        } else {
            Sheet sheet2 = wb.getSheet("Sayfa2");
            cellMethod(sheet2);
        }

        FileOutputStream fos = new FileOutputStream(path1);//tekrar yazdirmak icin stream a aliyoruz...
        wb.write(fos);
        fis.close();
        fos.close();

    }

    private void cellMethod(Sheet sheet2) {

        List<String> list = new ArrayList<>(Arrays.asList("Muhtesem7li", "YasinHocamIle", "selenium", "Ogreniyor"));// girilecek data bunlar..
        for (int i = 0; i < 5; i++) {
            if (sheet2.getRow(i) == null) {
                Row row = sheet2.createRow(i);
                for (int r = 0; r < list.size(); r++) {
                    row.createCell(r).setCellValue(list.get(r));
                }
            } else {
                Row row = sheet2.getRow(i);
                for (int r = 0; r < list.size(); r++) {
                    row.createCell(r).setCellValue(list.get(r));
                }
            }
        }

    }
}
