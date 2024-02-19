package Mentoring.Tag3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class task1 {
    //    Test Case 1: Register User
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'  Pass
//3. Verify that home page is visible successfully    Pass
//4. Click on 'Signup / Login' button                 Pass
////5. Verify 'New User Signup!' is visible             Pass
//6. Enter name and email address                     Pass
//7. Click 'Signup' button                            Pass
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible     Pass
//9. Fill details: Title, Password, Date of birth
//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'

    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//13. Click 'Create Account button'
//14. Verify that 'ACCOUNT CREATED!' is visible
//15. Click 'Continue' button
//16. Verify that 'Logged in as username' is visible
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    static WebDriver driver;
    static int mailNummer = 30;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("http://automationexercise.com");
    }

    @Test
    @Order(1)
    public void test1() throws InterruptedException {
        WebElement vertify = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        vertify.isDisplayed();
        //Thread.sleep(2000);
    }

    @Test
    @Order(2)
    public void test2() throws InterruptedException {
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();
        //Thread.sleep(2000);
    }

    @Test
    @Order(3)
    public void test3() throws InterruptedException {
        WebElement newUserSignup = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        assertEquals(newUserSignup.getText(), "New User Signup!");
        //Thread.sleep(2000);
    }

    @Test
    @Order(7)
    public void test4() throws InterruptedException {
        WebElement name = driver.findElement(By.xpath("//input[@name=\"name\"]"));
        name.sendKeys("rasit");
        //Thread.sleep(2000);
        WebElement mail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        mail.sendKeys("rasit" + mailNummer++ + "@gmail.com");
        //Thread.sleep(2000);
        WebElement signUp = driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]"));
        signUp.click();
        //Thread.sleep(2000);
    }

    @Test
    @Order(8)
    public void test5() throws InterruptedException {
        WebElement enterAccount = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        assertEquals("ENTER ACCOUNT INFORMATION", enterAccount.getText());
        //Thread.sleep(2000);
    }

    @Test
    @Order(9)
    public void test6() throws InterruptedException {
        WebElement gender = driver.findElement(By.xpath("//input[@id=\"id_gender1\"]"));
        gender.click();
        //Thread.sleep(2000);
        WebElement passWord = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        passWord.sendKeys("1234" + Keys.ENTER);
        //Thread.sleep(2000);
        WebElement day = driver.findElement(By.xpath("//select[@id=\"days\"]"));
        day.sendKeys("19" + Keys.ENTER);
        WebElement month = driver.findElement(By.xpath("//select[@id=\"months\"]"));
        month.sendKeys("April" + Keys.ENTER);
        WebElement year = driver.findElement(By.xpath("//select[@id=\"years\"]"));
        year.sendKeys("1983" + Keys.ENTER);
        WebElement newsLetter = driver.findElement(By.xpath("//*[@id=\"newsletter\"]"));
        newsLetter.click();
        WebElement partners = driver.findElement(By.xpath("//*[@id=\"optin\"]"));
        partners.click();

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstName.sendKeys("rasit");
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        lastName.sendKeys("sivasli");
        WebElement adress = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        adress.sendKeys("Kaiserslautern");
        WebElement country = driver.findElement(By.id("country"));
        country.sendKeys("Canada");
        WebElement state = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        state.sendKeys("Ottowa");
        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys("merkez");
        WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        zipCode.sendKeys("1983");
        WebElement mobileNummer = driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
        mobileNummer.sendKeys("1983");
        WebElement creatAccount = driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]"));
        creatAccount.submit();
        WebElement verify = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        assertEquals("ACCOUNT CREATED!", verify.getText());
        WebElement contunie = driver.findElement(By.xpath("//*[@data-qa=\"continue-button\"]"));
        contunie.click();
        WebElement userVerfy = driver.findElement(By.partialLinkText("rasit"));
        assertTrue(userVerfy.getText().contains("rasit"));
        WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccount.click();
        WebElement verifyDelete = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        assertEquals("ACCOUNT DELETED!", verifyDelete.getText());
    }
    
    @AfterAll
    public static void tearDown() throws InterruptedException {
        driver.quit();
    }
}
