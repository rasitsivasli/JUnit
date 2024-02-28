package HOMEWORK.H01_Locater;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class faceBook {
    //    Goto page https://testpages.herokuapp.com/styled/basic-html-form-test.html
    //        Create webdriver object
    //        1-Test userName input text.Send name
    //        2-Test password input text.Send password

    /*WebElement searchBox1 = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchBox2 = driver.findElement(By.name("field-keywords"));
        WebElement searchBox3 = driver.findElement(By.className("nav-input nav-progressive-attribute"));
        WebElement searchBox4 = driver.findElement(By.tagName("input"));
        WebElement link = driver.findElement(By.linkText("Bewerbe deine Produkte"));
        WebElement linkPartial = driver.findElement(By.partialLinkText("Bewerbe deine "));*/

    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
        if (driver.findElement(By.xpath("//button[@title='Alle Cookies erlauben']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@title='Alle Cookies erlauben']")).click();
        }
    }

    @Test
    public void userName() throws InterruptedException {

        WebElement username = driver.findElement(By.id("email"));
        WebElement username2 = driver.findElement(By.name("email"));
        WebElement password3 = driver.findElement(By.cssSelector("input[data-testid='royal_email']"));
        WebElement usernam4 = driver.findElement(By.tagName("input"));
        username.sendKeys("TestUser");
        assertTrue(username.isDisplayed());
        Thread.sleep(2000);

    }
    @Test
    public void passWord() throws InterruptedException {
        WebElement password = driver.findElement(By.id("pass"));
        WebElement password2 = driver.findElement(By.name("pass"));
        WebElement password3 = driver.findElement(By.cssSelector("input[data-testid='royal_pass']"));
        WebElement password4 = driver.findElement(By.tagName("input"));
        password.sendKeys("TestPassWord");
        assertTrue(password.isDisplayed());
        Thread.sleep(2000);

    }
    @Test
    public void anmelden() throws InterruptedException {
        //WebElement anmelden = driver.findElement(By.id("u_0_5_ON"));//her seferinde ID farkli o yüzden hata veriyor
        WebElement anmelden2 = driver.findElement(By.name("login"));
        WebElement password3 = driver.findElement(By.cssSelector("button[data-testid='royal_login_button']"));
        WebElement anmelden4 = driver.findElement(By.tagName("button"));

        assertTrue(anmelden2.isDisplayed());
        Thread.sleep(2000);

    }
    @Test
    public void passVergessen() throws InterruptedException {
        WebElement link = driver.findElement(By.linkText("Passwort vergessen?"));
        WebElement linkPartial = driver.findElement(By.partialLinkText("vergessen?"));

        assertTrue(link.isDisplayed());
        Thread.sleep(2000);

    }
    @Test
    public void faceBookTitel() throws InterruptedException {
        WebElement faceBookTitel = driver.findElement(By.cssSelector("img[src='https://static.xx.fbcdn.net/rsrc.php/y1/r/4lCu2zih0ca.svg']"));

        assertTrue(faceBookTitel.isDisplayed());
        Thread.sleep(2000);

    }
    @Test
    public void creatNewAccount() throws InterruptedException {

        WebElement creatAccount = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        assertTrue(creatAccount.isDisplayed());
        Thread.sleep(2000);

    }
}
