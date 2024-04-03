package org.example;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

    @Rule
    public ErrorCollector ec = new ErrorCollector();

    @Test
    public void searchForAValidProduct() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        String expectedTitle = "Your Store abc";
        String actualTitle = driver.getTitle();

        try {
            Assert.assertEquals(expectedTitle, actualTitle);
        }catch (Throwable e){
            System.out.println(e.getMessage());
            ec.addError(e);
        }

        driver.findElement(By.name("search")).sendKeys("HP");
        driver.findElement(By.xpath("//div[@id=\"search\"]//button")).click();
        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());

        driver.quit();
    }
}
