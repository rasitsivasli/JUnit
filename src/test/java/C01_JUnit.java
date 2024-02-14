
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnit {
    /*
 ******JUNIT*****
Java ile en temel framework JUNit ile oluşturulabilir.
* JUnit açık kaynaklı bir birim test aracıdır ve küçük/büyük kod birimlerini test etmek için kullanılır
* JUnit testini çalıştırmak için bir sınıf nesnesi oluşturmanız veya main method tanımlamanız gerekmez.
Developerlar da unit testleri calistirmak icin kullanirlar.
Biz testlerimizi yapmak icin JUnit'in ileri sürümü olduğundan TestNG framework oluşturup kullanacagiz
* JUnit ayrıca birden çok test senaryosuna sahip Otomasyon paketini çalıştırmak için kullanılır.
*
*
* Test dediğimizde tek bir method veya içinde birçok class ve package barındıran bir yapı olabilir.
*  Regression Test, Smoke Test vb.
* Testmethod’u ise @Test notasyonu kullanılarak oluşturulan ve bağımsız olarak çalıştırabileceğimiz en küçük test yapısıdır.
@Test annotation : Test methodu
 */
    static WebDriver driver = new ChromeDriver();
    @Test
    public void test01(){
        /*//Create chrome driver.
        WebDriver driver = new ChromeDriver();

        //Maximize the window.
        driver.manage().window().maximize();

        //Sayfanın load olması için tanınan max süre
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));*/

        //Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
    }
    @Test
    public void test02(){
/*        //Create chrome driver.
        WebDriver driver = new ChromeDriver();

        //Maximize the window.
        driver.manage().window().maximize();

        //Sayfanın load olması için tanınan max süre
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));*/

        //Open google home page https://www.google.com/
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void test03(){
/*        //Create chrome driver.
        WebDriver driver = new ChromeDriver();

        //Maximize the window.
        driver.manage().window().maximize();

        //Sayfanın load olması için tanınan max süre
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));*/

        //Open google home page https://www.google.com/
        driver.get("https://www.youtube.com/");
    }
    @Before
    public void before(){
        //Create chrome driver.
        driver = new ChromeDriver();

        //Maximize the window.
        driver.manage().window().maximize();

        //Sayfanın load olması için tanınan max süre
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void after(){
        driver.quit();
    }

}
