package Dersler;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C51_ApachePoiGetData {
    String sheetName = "";

    int sheetIndex;

    int rowIndex;

    int cellIndex;

    public static Object getDataStringSheet(String sheetName, int rowIndex, int cellIndex) throws IOException {
        String istenenData ;
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\excelfile.xlsx";
        FileInputStream fis = new FileInputStream(path1);//Burada öce alisa aliniyor . Cunku Java önce akisa alarak Bynery coduna ceviriyor ve sonra nesneye dönusuyor.
        Workbook wb = WorkbookFactory.create(fis);
        istenenData = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).toString();
        return istenenData;
    }
    public static Object getDataStringSheet(int sheetIndex, int rowIndex, int cellIndex) throws IOException {
        String istenenData ;
        String path1 = System.getProperty("user.dir") + "\\src\\test\\resources\\excelfile.xlsx";
        FileInputStream fis = new FileInputStream(path1);
        Workbook wb = WorkbookFactory.create(fis);
        istenenData = wb.getSheetAt(sheetIndex).getRow(rowIndex).getCell(cellIndex).toString();
        return istenenData;
    }
}

