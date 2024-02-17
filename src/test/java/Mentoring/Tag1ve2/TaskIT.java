package Mentoring.Tag1ve2;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskIT {
    static WebDriver driver;

    /*
Go to youtube homepage
Do the following tasks by creating 4 different test methods.
*- Her test() methodundan önce "Test çalışıyor" yazdıralım
*- Her test() methodundan sonra "Test bitti" yazdıralım
3- Test if the currentURL contains "youtube"
4- Test if the title does not contain "Video".
5- Test if the URL contains "youtube".
6- Test if the sourcePage contains "youtube".
*/
    @BeforeAll// BeforeAll sadece testler baslamadan önce calisir ve static olmak zorunda

    public static void beforeAllTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach// her testen önce bir kez calisir
    public void beforeTest() {
        System.out.println("Test calisiyor");
    }

    @AfterEach// her testen sonra bir kez calisir
    public void afterTest() {
        System.out.println("Test test bitti");
    }

    @Test @Disabled ("Test1 beklemeye alindi")
    public void test1Url() {
        driver.get("https://www.youtube.com/");
        String expexted = "youtube";
        String actual = driver.getCurrentUrl();
        System.out.println("actual = " + actual);
        System.out.println(actual.contains(expexted)? "PASS":"FAIL");
        //Assertions.assertEquals(actual,expexted);
    }
    @AfterAll
    public static void afterAllTest() {
        driver.quit();
        System.out.println("Test tamamen bitti");
    }
    @Test
    public void test1Title() {
        driver.get("https://www.youtube.com/");
        String expexted = "Video";
        String actual = driver.getTitle();
        System.out.println("actual = " + actual);
        System.out.print("Test Title: ");
        System.out.println(actual.contains(expexted)? "PASS":"FAIL");
        //Assertions.assertEquals(actual,expexted);
    }
}
