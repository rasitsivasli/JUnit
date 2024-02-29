package HOMEWORK.M07_Cookies;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HW_26 extends TestBase {
    /*
    Go to URL: http://facebook.com
    getCookies,
    addCookie,
    deleteCookieNamed,
    deleteAllCookies
 */
    @Test
    public void test1() {
        driver.get("http://facebook.com");
        if (driver.findElement(By.xpath("//*[.='Alle Cookies erlauben']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Alle Cookies erlauben']")).click();
        }

        //Print all the cookies.

        System.out.println("cookies.size() = " + driver.manage().getCookies());
        for(Cookie c : driver.manage().getCookies()){
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Add Cookie.
        Cookie newCookie = new Cookie("Ad", "Rasit");
        driver.manage().addCookie(newCookie);

        for (Cookie cookie : driver.manage().getCookies()) {
            System.out.println("cookie = " + cookie);
        }
        System.out.println("******************************************************************");


        //Delete Cookie.
        driver.manage().deleteCookieNamed("expires");
        for (Cookie cookie : driver.manage().getCookies()) {
            System.out.println("cookie = " + cookie);
        }
        System.out.println("******************************************************************");

        //Delete All Cookies.
        driver.manage().deleteAllCookies();
        System.out.println("Size " + driver.manage().getCookies().size());


    }
}





























