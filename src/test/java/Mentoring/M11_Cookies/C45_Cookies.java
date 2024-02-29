package Mentoring.M11_Cookies;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.Set;

public class C45_Cookies extends TestBase {
    //https://www.rossmann.de/de/
    // GEt cookies
    // Find the total number
    // Add Cookies
    // Edit Cookies
    // Delete Cookies
    // Delete All Cookies
    @Test
    public void test1() {
        driver.get("https://www.rossmann.de/de/");
        WebElement aczept = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        aczept.click();

        //Print all the cookies.
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie c : cookies){
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Add Cookie.
        Cookie newCookie = new Cookie("Crem", "Nivea");
        driver.manage().addCookie(newCookie);
        Set<Cookie> cookiesUpdated = driver.manage().getCookies();
        for(Cookie c : cookiesUpdated){
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Edit Cookie.
        Cookie editCookie = new Cookie("Sampoo", "Elidor");
        driver.manage().addCookie(editCookie);
        Set<Cookie> cookiesUpdated2 = driver.manage().getCookies();
        for(Cookie c : cookiesUpdated2){
            System.out.println(c);
        }
        System.out.println("******************************************************************");

        //Delete Cookie.
        driver.manage().deleteCookieNamed("JSESSIONSHOPID");
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





























