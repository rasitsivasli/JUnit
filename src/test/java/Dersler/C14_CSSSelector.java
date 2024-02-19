package Dersler;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C14_CSSSelector {
    /*
http://the-internet.herokuapp.com/add_remove_elements/
Click on the "Add Element" button 100 times.
Write a function that takes a number, and clicks the "Delete" button.
Given number of times, and then validates that given number of buttons was deleted.
1. Method: createButtons(100)
2. Method: DeleteButtonsAndValidate()

 */
    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
    }//Close driver.
// / div > p child
// / div + p following sibling
// / div ~ p following all p

    @Test
    public void test() {
        createButtons(100);
        deleteButtonsAndValidate(50);
    }

    private void deleteButtonsAndValidate(int a) {
        List<WebElement> deleteButtonList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenOncekiSize = deleteButtonList.size();
        for(int i=0; i<a; i++){
            deleteButtonList.get(i).click();
        }
        int sildiktenSonrakiSize = driver.findElements(By.cssSelector("button[onclick='deleteElement()']")).size();
        assertEquals(silinmedenOncekiSize-a, sildiktenSonrakiSize);
    }

    private void createButtons(int i) {
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int j = 0; j <i; j++) {
            addButton.click();
        }
    }
}
 /*
 ****************  CssSelector Arama Yöntemleri    ****************************************

         ---->> Sadece id  için
         By.cssSelector(‘’#logout’’); // id si logout olan

         By.cssSelector(‘’a#logout’’);  // a tag lılar için de id si logout olan

         ----> Sadece Class için
         By.cssSelector(‘’.center’’); // class=‘’center’’

         By.cssSelector(‘’p.center’’);  // p tag lılar için de class i center olan

         ----> Tagname lerle  Arama
         By.cssSelector(‘’input’’); // bütün input taglı olanları seçer.

         By.cssSelector(‘’input[type=‘text’]’’);  //bütün inputlarda type=‘’text’’ olanları seçer

         By.cssSelector(‘’input[type=‘text’][placeholder=‘First Name’]’’) // bütün inputlar içinden type=‘’text’’ ve placeholder=‘’First Name’’ olanı bulur.

         By.cssSelector(‘’[type=‘text’]’’);  //type=‘’text’’ olanları seçer

         By.cssSelector(‘’input.form-control[type=‘text’]’’);  //bütün inputlarda class=‘form-control’ olanlardan type=‘text’ olanlar seçer
         */