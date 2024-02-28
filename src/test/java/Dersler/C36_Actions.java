package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C36_Actions extends TestBase {
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
    //Go to URL: https://demoqa.com/buttons
    //Run the buttons on the page using the Actions Class.
    //Verify the texts that appear after the buttons are operated.

    @Test
    public void test() {

        driver.get("https://demoqa.com/buttons");
        WebElement einwllig = driver.findElement(By.xpath("//p[.='Einwilligen']"));
        einwllig.click();
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        WebElement clickMe = driver.findElement(By.xpath("//button[.='Click Me']"));

        //1.yol
        /*actions.doubleClick(doubleClickBtn).perform();
        actions.contextClick(rightClickBtn).perform();
        actions.click(clickMe).perform();*/

        // kisa yol
        actions.doubleClick(doubleClickBtn)
                .contextClick(rightClickBtn)
                .click(clickMe)
                .perform();

        //3.yol
       /* actions.moveToElement(doubleClickBtn)
                .pause(Duration.ofSeconds(2))
                .doubleClick(doubleClickBtn).
                pause(Duration.ofSeconds(2))
                .click(clickMe).perform();*/


        // perform en sona geliyor
        /*actions.doubleClick(doubleClickBtn);
        actions.contextClick(rightClickBtn);
        actions.click(clickMe);
        actions.perform();*/

    }
}
