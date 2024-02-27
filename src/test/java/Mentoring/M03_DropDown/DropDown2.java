package Mentoring.M03_DropDown;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDown2 {
    /*
    Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */
    static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @AfterAll
    public static void tearDown() {
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@class=\"item active\"]//h1"));
        assertTrue(element.getText().contains("Automation"));
        WebElement signUp = driver.findElement(By.xpath("//*[@id=\"header\"]//*[@class='fa fa-lock']"));
        signUp.click();
        WebElement newerUp = driver.findElement(By.xpath("//*[@class=\"signup-form\"]//h2"));
        assertTrue(newerUp.isDisplayed());
        Faker faker = new Faker();
        WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]//*[@data-qa=\"signup-name\"]"));
        name.sendKeys(faker.name().firstName());
        WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]//*[@data-qa=\"signup-email\"]"));
        email.sendKeys(faker.internet().emailAddress());
        WebElement click = driver.findElement(By.xpath("//*[@id=\"form\"]//*[@data-qa=\"signup-button\"]"));
        click.click();
        WebElement verify = driver.findElement(By.xpath("//*[@id=\"form\"]//h2[.=\"Enter Account Information\"]"));
        assertEquals("ENTER ACCOUNT INFORMATION", verify.getText());

        WebElement gender = driver.findElement(By.xpath("//input[@id=\"id_gender1\"]"));
        gender.click();
        //Thread.sleep(2000);
        WebElement passWord = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        passWord.sendKeys(faker.internet().password() + Keys.ENTER);
        //Thread.sleep(2000);
        WebElement day = driver.findElement(By.xpath("//select[@id=\"days\"]"));
        day.sendKeys(faker.date().birthday().toString() + Keys.ENTER);
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
        WebElement verify2 = driver.findElement(By.xpath("//b[text()='Account Created!']"));
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


    }


