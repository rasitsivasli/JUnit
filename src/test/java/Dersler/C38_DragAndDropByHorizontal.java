package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

import java.time.Duration;

public class C38_DragAndDropByHorizontal extends TestBase {
    //Go to URL: https://rangeslider.js.org/
    //Shift 100 units to the right and 100 units to the left on the horizontal axis.

    @Test
    public void dragSliderXaxe() {
        driver.get("https://rangeslider.js.org/");
        WebElement slider = driver.findElement(By.cssSelector("div.rangeslider__handle")); // tag div class i "rangeslider__handle" demek.
        actions.dragAndDropBy(slider, 100, 0).
                pause(Duration.ofSeconds(2)).
                dragAndDropBy(slider, -100, 0).perform();


    }
}
