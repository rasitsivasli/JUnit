package Dersler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.TestBase;

import java.time.Duration;

public class C39_DragAndDropByVertical extends TestBase {
    // Go to URL: https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html
    // Shift 34 units to the up and 34 units to the down on the vertical axis.

    @Test
    public void dragSliderYaxe() throws InterruptedException {
        driver.get("https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html");
        WebElement verticalSlider = driver.findElement
                (By.xpath("//div[@class='medium-2 columns']/div/div/div/span[1]"));
        actions.dragAndDropBy(verticalSlider, 0, -34)
                .pause(Duration.ofSeconds(3000))
                .dragAndDropBy(verticalSlider, 0, 34)
                .pause(Duration.ofSeconds(3000))
                .perform();

    }
}
