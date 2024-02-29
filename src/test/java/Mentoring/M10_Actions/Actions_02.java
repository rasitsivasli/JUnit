package Mentoring.M10_Actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

public class Actions_02 extends TestBase {
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
    //Goto page:Goto page: https://demo.guru99.com/test/drag_drop.html
    //First Manel Test Application
    //Darg and drop values related space
    //After Succesfully moved
    //Verify Perfect

    @Test
    public void test() {

        driver.get("https://demo.guru99.com/test/drag_drop.html");
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"gdpr-consent-notice\"]"));
        driver.switchTo().frame(iframe);

        if (driver.findElement(By.xpath("//*[.='Alle akzeptieren']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[.='Alle akzeptieren']")).click();
        }

        WebElement bankaBox = driver.findElement(By.xpath("//*[@id=\"credit\"]/a"));
        WebElement bankaBoxneuerOrt = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
        actions.dragAndDrop(bankaBox, bankaBoxneuerOrt).perform();

        WebElement salesBox = driver.findElement(By.xpath("//*[@id=\"credit0\"]/a"));
        WebElement salesBoxneuerOrt = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
        actions.dragAndDrop(salesBox, salesBoxneuerOrt).perform();

        WebElement funfTBox = driver.findElement(By.xpath("(//*[@id=\"fourth\"]/a)[1]"));
        WebElement funfTBoxneuerOrt = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
        actions.dragAndDrop(funfTBox, funfTBoxneuerOrt).perform();

        WebElement funfTBox2 = driver.findElement(By.xpath("(//*[@id=\"fourth\"]/a)[2]"));
        WebElement funfTBox2neuerOrt = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
        actions.dragAndDrop(funfTBox2, funfTBox2neuerOrt).perform();

        // Verify the visibility of Perfect text.
        WebElement perfectText = driver.findElement(By.xpath("(//*[@id=\"equal\"]/a)[1]"));
        System.out.println("perfectText.getText() = " + perfectText.getText());

    }
}
