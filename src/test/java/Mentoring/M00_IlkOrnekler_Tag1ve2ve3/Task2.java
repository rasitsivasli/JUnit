package Mentoring.M00_IlkOrnekler_Tag1ve2ve3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Task2 {

    //    Goto page https://testpages.herokuapp.com/styled/basic-html-form-test.html
//       Create webdriver object
//        1-Create BeforeAll, BeforeEach,AfterAll ,Test anotains
//        2-Test page title equal "Form"
//        3-Test url contain "Form"
//        4-Test page after refresh page driver notNull
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
    }

    @AfterAll
    public static void tearDown() {
        driver.navigate().refresh();
       assertFalse(driver.equals(null));
    }
    @Test
    public void test3() {
        assertNotNull(driver);

    }

    @Test
    public void test1() {
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals("form", title);

    }

    @Test
    public void test2() {
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("form"));

    }
}
