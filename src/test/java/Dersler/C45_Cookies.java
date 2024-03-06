package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utils.TestBase;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C45_Cookies extends TestBase {
    //***Cookie cookie  = driver.manage().cookie-methods

    //Go to URL: https://kitchen.applitools.com/ingredients/cookie
    //Print all the cookies.
    //Get Cookie named protein.
    //Find the total number of cookies.
    //Add Cookie.
    //Edit Cookie.
    //Delete Cookie.
    //Delete All Cookies.
    @Test
    public void test1() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        //Print all the cookies.
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie c : cookies){
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Get Cookie named protein.
        System.out.println(driver.manage().getCookieNamed("protein"));
        System.out.println("******************************************************************");

        //Find the total number of cookies.
        System.out.println("Çerez sayısı: "+cookies.size());
        System.out.println("******************************************************************");

        //Add Cookie.
        Cookie newCookie = new Cookie("vitamin", "Dvit");
        driver.manage().addCookie(newCookie);
        Set<Cookie> cookiesUpdated = driver.manage().getCookies();
        for(Cookie c : cookiesUpdated){
            System.out.println(c);
        }
        System.out.println("------------------------------------------------------------------");

        //Edit Cookie.
        Cookie editCookie = new Cookie("vegetable", "cucumber");
        driver.manage().addCookie(editCookie);
        Set<Cookie> cookiesUpdated2 = driver.manage().getCookies();
        for(Cookie c : cookiesUpdated2){
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Delete Cookie.
        driver.manage().deleteCookieNamed("vegetable");
        Set<Cookie> cookiesUpdated3 = driver.manage().getCookies();
        for(Cookie c : cookiesUpdated3){
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Delete All Cookies.
        driver.manage().deleteAllCookies();
        Set<Cookie> cookiesUpdated4 = driver.manage().getCookies();
        System.out.println(cookiesUpdated4.size());
    }
}





























