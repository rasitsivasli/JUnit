package Dersler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class C04_AssertionMethods {

    @Test
    public void assertEqualsMethod() {
        //2 parametre alir ve parametreler karsilastirilir ve esitlerse test PASSED olur,
        // esit degilse AssertionError firlatir

        Assertions.assertEquals(10, 10);//passed
        Assertions.assertEquals(new String("ali"), "ali");//passed
    }

    @Test
    public void assertTrueMethod() {
        //1 parametre alir ve gonderilen parametrenin true olmasi durumunda testimiz PASSED,
        // false olmasi durumunda da FAILED olur
        assertTrue(5 == 5);
        //assertTrue(false);// Fail

    }

    @Test
    public void assertFalseMethod() {
        //1 parametre alir ve gonderilen parametrenin false olmasi durumunda testimiz PASSED,
        // true olmasi durumunda da FAILED olur
        assertFalse(5 == 3);

    }

    @Test
    public void assertNullMethod() {
        //1 parametre alir, Parametre null ise test PASSED,
        // null degil ise test FAILED olur

        assertNull(null); //true
        assertNull(252); //fail
    }

    @Test
    public void assertNotNullMethod() {
        //1 parametre alir, Parametre null degil ise test PASSED,
        // null ise test FAILED olur

    }

    @Test
    public void assertSameMethod() {
        //bu method iki nesnenin esit olup olmadigini dogrulamak icin dahili olarak == operatorunu kullanir
        //assertSame referans degerlerini de karsilastirir..
        //obje kontrolunde deger ve referanslar ayni olmalidir...

        //assertSame(new String("Rasit"), new String("Rasit"));//false

    }

    @Test
    public void assertNotSameTestMethod() {
        //obje kontrolunde deger ve referanslar ayni olmayanlar icin gecerlidir
        assertNotSame(new String("Rasit"), new String("Rasit"));// true

    }

    @Test
    public void assertArrayEqualsMethod() {
        //2 parametre alir ve verilen arraylerin uzunluklari ve ayni indexdeki elemanlari ayni olmalidir

        int[] arr1 = {0, 1, 2, 3, 4}, arr2 = {0, 1, 2, 3, 4};
        assertArrayEquals(arr1,arr2);// pass


        char[] actualArr = {'h', 'o', 'm', 'e'};
        char[] expectedArr = {'H', 'O', 'M', 'E'};

        //assertArrayEquals(actualArr,expectedArr); // fail

    }
}
 /*
    import org.junit.jupiter.api.Assertions;

    import static org.junit.Assert.assertSame;

     Assertions sınıfı için statik içe aktarmanın avantajı şudur:

        Assertions sınıf adının gereksiz kullanımını Assert yöntemleriyle ortadan kaldırmak için.
        Zaman kazandırır.
        Yazmayı daha iyi hale getirir ve
        Kodun okunabilirliğini artırır.
     */