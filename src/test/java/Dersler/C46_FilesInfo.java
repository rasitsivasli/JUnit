package Dersler;

import org.junit.jupiter.api.Test;

public class C46_FilesInfo {

    @Test
    public void test1() {

        // DOSYA YOLUNU AYIRAN KARAKTERi VERiR
        System.out.println("1) " + System.getProperty("file.separator"));

        // PROJENiN YUKLU OLDUGU ADRESi VE YUKLU OLAN JAR DOSYALARININ ADRESLERiNi GOSTERiR
        System.out.println("2) " + System.getProperty("java.class.path"));

        // JAVA RUNTiME  ENViROMENT (JRE) iCiN KURULUM DiZiSi
        System.out.println("3) " + System.getProperty("java.home"));

        // JRE SATICI ADI
        System.out.println("4) " + System.getProperty("java.vendor"));

        // JRE SATICI URL
        System.out.println("5) " + System.getProperty("java.vendor.url"));

        // JRE SURUM NUMARASI
        System.out.println("6) " + System.getProperty("java.version"));

        // iSLETiM SiSTEMi ADI
        System.out.println("7) " + System.getProperty("os.name"));

        // iSLETiM SiSTEMi SURUMU
        System.out.println("8) " + System.getProperty("os.version"));

        // KULLANILAN YOL AYIRICI KARAKTER
        System.out.println("9) " + System.getProperty("path.separator"));

        // KULLANICI CALISMA DiZiNi- projenin content rootu
        System.out.println("10) " + System.getProperty("user.dir"));

        // KULLANICI ANA DiZiNi - windows user C nin altindaki isim
        System.out.println("11) " + System.getProperty("user.home"));

        // KULLANICI HESABI ADI
        System.out.println("12) " + System.getProperty("user.name"));

        // DOSYA AYIRACI: Windows icin '\' - mac icin '/'
        System.out.println("13) "+ System.getProperty("file.separator"));
    }
}

