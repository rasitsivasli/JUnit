package Mentoring.M10_Actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.JavascriptUtils;
import utils.TestBase;

import java.time.Duration;

public class Actions_04 extends TestBase {
        /*
Mouse Actions
click(): Geçerli konumu tıklamak için kullanılır.
doubleClick(): Fare konumuna çift tıklama gerçekleştirmek için kullanılır.
clickAndHold(): Fare tıklamasını serbest bırakmadan gerçekleştirmek için kullanılır.
contextClick(): Geçerli fare konumuna sağ fare tıklaması gerçekleştirmek için kullanılır.
moveToElement (WebElement target): Fare işaretçisini hedef konumun merkezine taşımak için kullanılır.
dragAndDrop(WebElement source, WebElement target): Öğeyi kaynaktan sürüklemek ve hedef konuma bırakmak için kullanılır.
dragAndDropBy(source, xOffset, yOffset): Bu yöntem, kaynak öğeyi tıklar ve tutar ve belirli bir ofset kadar hareket eder, ardından fareyi serbest bırakır. Ofsetler x & y ile tanımlanır.(X = Yatay Kaydır, Y= Dikey Kaydır)
release(): Geçerli konumdaki sol fare düğmesini serbest bırakmak için kullanılır.
perform(): Bir eylemi yürütür. Bu, bir eylemi gerçekleştirmek için sonunda kullanılmalıdır.
perform() KULLANMAYI UNUTMAYIN!

*/
    //Goto website: https://www.garantibbva.com.tr/krediler/kredi-hesaplama
    //Locate Slider
    //goto x:30 y:0 position
    //Wait 1 sn
    //Goto x:150 y:0 position

    @Test
    public void test() {
        driver.get("https://www.garantibbva.com.tr/krediler/kredi-hesaplama");
        actions.sendKeys(Keys.PAGE_DOWN).pause(1000).perform();
        actions.sendKeys(Keys.PAGE_UP).pause(1000).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        WebElement slider= driver.findElement(By.xpath("(//span[@class='icon'])[1]"));
        JavascriptUtils.scrollIntoViewJS(driver,slider);

        WebElement text= driver.findElement(By.xpath("//strong[@class=\"js-calc__total\"]"));
        System.out.println("text.getText() = " + text.getText());
    }


}

