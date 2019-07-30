package org.fasttrackit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validLoginTest() {

        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector(".skip-account"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("a[title^=Log]"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("QAautotest@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("autotest123");
        driver.findElement(By.cssSelector("#send2")).click();

        WebElement helloText = driver.findElement(By.cssSelector(".welcome-msg .hello"));
        Assert.assertEquals("Hello, Auto Test!", helloText.getText());

        driver.findElement(By.cssSelector(".skip-account")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[title='Log Out']")).isDisplayed());
    }

    @Test
    public void invalidMailTest() {

        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector(".skip-account"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("a[title^=Log]"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("QAautotest@mailinator");
        driver.findElement(By.cssSelector("#pass")).sendKeys("autotest123");
        driver.findElement(By.cssSelector("#send2")).click();

        WebElement invalidEmail = driver.findElement(By.cssSelector("div[id$=email]"));
        Assert.assertTrue(invalidEmail.isDisplayed());

    }

    @Test
    public void wrongPasswordTest() {

        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector(".skip-account"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("a[title^=Log]"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("QAautotest@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("autotest");
        driver.findElement(By.cssSelector("#send2")).click();

        WebElement invalidPassword = driver.findElement(By.cssSelector(".error-msg"));
        Assert.assertTrue(invalidPassword.isDisplayed());

        WebElement emptyPassBox = driver.findElement(By.cssSelector("input[type^=pass]"));
        Assert.assertTrue(emptyPassBox.getText().isEmpty());
    }

    @Test
    public void emptyFieldsTest() {

        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector(".skip-account"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("a[title^=Log]"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("");
        driver.findElement(By.cssSelector("#pass")).sendKeys("");
        driver.findElement(By.cssSelector("#send2")).click();

        WebElement emptyEmail = driver.findElement(By.cssSelector("div[id*=email]"));
        Assert.assertTrue(emptyEmail.isDisplayed());

        WebElement emptyPassword = driver.findElement(By.cssSelector("div[id*=pass]"));
        Assert.assertTrue(emptyPassword.isDisplayed());
    }


    @AfterClass
    public static void quit() {
        driver.quit();
    }
}
