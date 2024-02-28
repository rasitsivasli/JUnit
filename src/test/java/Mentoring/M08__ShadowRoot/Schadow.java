package Mentoring.M08__ShadowRoot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class Schadow extends TestBase {
    /*
    Go to https://www.teknosa.com/
    Accept cookies with javascriptexecutor and getShadowRoot() method separately.
    Do it in two methods. One method for jsexecutor and the other for getShadowRoot() method.
    Accept notification.
 */
    //!!!!!!!!! Shadow DOM içerisinde sadece cssSelector çalışır !!!!!!!!!!!

    @Test
    public void withGetShadowRootMethod() throws InterruptedException {
        driver.get("https://www.teknosa.com/");
        Thread.sleep(3000);
        WebElement target = driver.findElement(By.tagName("efilli-layout-dynamic")).getShadowRoot()
                .findElement(By.cssSelector("div[id='b7bca45b-4b2f-4bf7-a04a-c5b0aec83d7e']"));
        target.click();


        //2.yol

      /*  WebElement schadowHost =  driver.findElement(By.tagName("efilli-layout-dynamic"));
        SearchContext schadowRoot = schadowHost.getShadowRoot();
        WebElement acceptButton = schadowRoot.findElement(By.cssSelector("div[id='b7bca45b-4b2f-4bf7-a04a-c5b0aec83d7e']"));
        acceptButton.click();
*/
    }
    @Test
    public void javascriptExecutor(){

        driver.get("https://www.teknosa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element1 = (WebElement) js.executeScript("return document.querySelector(\"body > efilli-layout-dynamic\")" +
                ".shadowRoot.querySelector(\"div[id='b7bca45b-4b2f-4bf7-a04a-c5b0aec83d7e']\")");
        element1.click();

    }
}
