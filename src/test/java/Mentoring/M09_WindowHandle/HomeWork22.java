package Mentoring.M09_WindowHandle;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import utils.TestBase;

import java.util.Set;

import static org.openqa.selenium.WindowType.WINDOW;

public class HomeWork22 extends TestBase {
//Open 3 window
//Every window have to 2 tabs
//get urls: https://www.tkmaxx.com/LandingPage/

   /* https://ikea.com
    https://facebook.com
    https://google.com
    https://linked.com
    https://flipgrid.com/
    */

// In the Set print window handles
//Use for each loop  if title contains ikea switch to this page

    @Test
    public void test2() throws InterruptedException {

        //Open 3 window
        //Every window have to 2 tabs

        driver.get("https://www.tkmaxx.com/LandingPage/");
        ((JavascriptExecutor) driver).executeScript("window.open()");

        String mainHandle1 = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String s : windowHandles) {
            if (!s.equals(mainHandle1)) {
                driver.switchTo().window(s);
                break;
            }
        }driver.get("https://ikea.com");
        String mainHandle2 = driver.getWindowHandle();



        driver.switchTo().newWindow(WINDOW);
        driver.get("https://facebook.com");
        ((JavascriptExecutor) driver).executeScript("window.open()");

        String mainHandle3 = driver.getWindowHandle();
        Set<String> windowHandles2 = driver.getWindowHandles();
        for (String s : windowHandles2) {
            if (!s.equals(mainHandle2)&& !s.equals(mainHandle1)&& !s.equals(mainHandle3)) {
                driver.switchTo().window(s);
                break;
            }
        }
        driver.get("https://google.com");


        driver.switchTo().newWindow(WINDOW);
        driver.get("https://linked.com");
        ((JavascriptExecutor) driver).executeScript("window.open()");

        String mainHandle4 = driver.getWindowHandle();
        Set<String> windowHandles3 = driver.getWindowHandles();
        for (String s : windowHandles3) {
            if (!s.equals(mainHandle2)&& !s.equals(mainHandle1)&& !s.equals(mainHandle3)&& !s.equals(mainHandle4)) {
                driver.switchTo().window(s);
                break;
            }
        }
        driver.get(" https://flipgrid.com/");

        Set<String> windowHandleSet = driver.getWindowHandles();
        System.out.println(windowHandleSet);

        for (String s : windowHandleSet) {
            if (driver.getTitle().contains("ikea")) {
                driver.switchTo().window(s);
                break;
            }
        }
        String ikeaHandle = driver.getWindowHandle();
        System.out.println(ikeaHandle);
    }

}
