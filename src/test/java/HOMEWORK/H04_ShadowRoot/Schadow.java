package HOMEWORK.H04_ShadowRoot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utils.TestBase;

public class Schadow extends TestBase {
    /*
    //Goto home https://www.n11.com/ //Locate "Tümünü kabul et"
 */
    //!!!!!!!!! Shadow DOM içerisinde sadece cssSelector çalışır !!!!!!!!!!!

    @Test
    public void withGetShadowRootMethod() throws InterruptedException {
        driver.get("https://www.n11.com/");
        Thread.sleep(3000);
        WebElement target = driver.findElement(By.tagName("efilli-layout-dynamic")).getShadowRoot()
                .findElement(By.cssSelector("div[id='480698fc-e6ac-41bc-a722-51059b783200']"));
        target.click();


        //2.yol

    /*  WebElement schadowHost =  driver.findElement(By.tagName("efilli-layout-dynamic"));
        SearchContext schadowRoot = schadowHost.getShadowRoot();
        WebElement acceptButton = schadowRoot.findElement(By.cssSelector("div[id='b7bca45b-4b2f-4bf7-a04a-c5b0aec83d7e']"));
        acceptButton.click();*/

    }
    @Test
    public void javascriptExecutor(){

        driver.get("https://www.n11.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element1 = (WebElement) js.executeScript("return document.querySelector(\"body > efilli-layout-dynamic\")" +
                ".shadowRoot.querySelector(\"div[id='480698fc-e6ac-41bc-a722-51059b783200']\")");
        element1.click();

    }
}
