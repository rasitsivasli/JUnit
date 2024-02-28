package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utils.TestBase;


import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import static org.openqa.selenium.WindowType.TAB;
import static org.openqa.selenium.WindowType.WINDOW;

public class C35_WindowHandle3 extends TestBase {
    // 1- browser ac
    // 2- acilan sekmede https://www.amazon.com/ ac
    // 3- yeni sekme olustur
    // 4- acilan sekmede https://www.linkedin.com/ ac
    // 5- yeni pencere olustur
    // 6- acilan pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
    // 7- amazon sekmesine gecerek arama kismina 'Amazon sekmesini buldun' yaz

    @Test
    public void test1() throws InterruptedException {
        String mainHandle = driver.getWindowHandle();

        // 2- acilan sekmede https://www.amazon.com/ ac
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//a[.='Try different image']")).click();

        // 3- yeni sekme olustur
        driver.switchTo().newWindow(TAB);
        String handleTap = driver.getWindowHandle();

        // 4- acilan sekmede https://www.linkedin.com/ ac
        driver.get("https://www.linkedin.com/");

        // 5- yeni pencere olustur
        driver.switchTo().newWindow(WINDOW);
        String handleWindow = driver.getWindowHandle();

        // 6- acilan pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 7- amazon sekmesine gecerek arama kismina 'Amazon sekmesini buldun' yaz
        driver.switchTo().window(mainHandle);
        //driver.findElement(By.xpath("//a[.='Try different image']")).click();
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Amazon sekmesini buldun");
    }

    @Test
    public void test2() throws InterruptedException {

        // 2- acilan sekmede https://www.amazon.com/ ac
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//a[.='Try different image']")).click();

        // 3- yeni sekme olustur
        driver.switchTo().newWindow(TAB);

        // 4- acilan sekmede https://www.linkedin.com/ ac
        driver.get("https://www.linkedin.com/");

        // 5- yeni pencere olustur
        driver.switchTo().newWindow(WINDOW);

        // 6- acilan pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // 7- amazon sekmesine gecerek arama kismina 'Amazon sekmesini buldun' yaz

        Set<String> windowhandleList = driver.getWindowHandles();
        Iterator<String> iterator = windowhandleList.iterator();

        while (iterator.hasNext()) {
            String currentHandle = iterator.next();
            driver.switchTo().window(currentHandle);

            if (driver.getTitle().contains("Amazon")){
                WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
                searchBox.sendKeys("Amazon sekmesini buldun bravo");
                break;
            }
        }



    }
}
