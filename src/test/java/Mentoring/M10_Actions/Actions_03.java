package Mentoring.M10_Actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.awt.event.KeyEvent;
import java.time.Duration;

public class Actions_03 extends TestBase {
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

        driver.get(" https://www.garantibbva.com.tr/krediler/kredi-hesaplama");

        WebElement sliderButton = driver.findElement(By.xpath("(//div[@class=' rangeSlider__handle rangeSlider__handle__horizontal'])[1]"));
        actions.dragAndDropBy(sliderButton, 30, 0)
                .pause(Duration.ofSeconds(1))
                .dragAndDropBy(sliderButton, 150, 0)
                .perform();

    }

    @Test
    public void test2() {
        //Goto:https://www.garantibbva.com.tr/krediler/kredi-hesaplama
        //Test PAGE DOWN,PAGE UP
        //Hover to Krediler Menu(not click())
        //Locate "Bonus Flaşh" and click
        driver.get(" https://www.garantibbva.com.tr/krediler/kredi-hesaplama");

        actions
                .sendKeys(Keys.PAGE_DOWN)
                .pause(Duration.ofSeconds(1))
                .sendKeys(Keys.PAGE_UP)
                .perform();

        WebElement credits = driver.findElement(By.xpath("//a[@data-text='Krediler']"));

        actions
                .moveToElement(credits)
                .pause(Duration.ofSeconds(5))
                .perform();

        WebElement avansHesap = driver.findElement(By.xpath("(//span[.='Avans Hesap'])[1]"));

        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].click();", avansHesap);

    }


}

