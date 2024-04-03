package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    WebDriver driver = null;

    @BeforeClass
    public static void preRequisites() {
        System.out.println("Everything is clear to run the Scripts");
    }

    @AfterClass
    public static void releaseResources() {
        System.out.println("Released all the resources");
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginWithValidCredentials() {

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("amotooricap1@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information abc")).isDisplayed());
    }

    @Test
    public void loginWithValidUsernameAndInvalidPassword() {

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("amotooricap1@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='account-login']//div[text()='Warning: No match for E-Mail Address and/or Password.']")).isDisplayed());
    }

    @Test
    public void loginWithInValidUsernameAndValidPassword() {

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("abcde@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='account-login']//div[text()='Warning: No match for E-Mail Address and/or Password.']")).isDisplayed());
    }
}
