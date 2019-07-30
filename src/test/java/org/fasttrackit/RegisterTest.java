package org.fasttrackit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private static WebDriver driver;

    @BeforeClass

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void userValidRegTest() {

        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement registerButton = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        registerButton.click();

        driver.findElement(By.id("firstname")).sendKeys("Auto");
        driver.findElement(By.id("middlename")).sendKeys("Ini");
        driver.findElement(By.id("lastname")).sendKeys("Test");
        driver.findElement(By.name("email")).sendKeys("QAautotest@mailinator.com");
        driver.findElement(By.name("password")).sendKeys("autotest123");
        driver.findElement(By.id("confirmation")).sendKeys("autotest123");
        driver.findElement(By.xpath("//*[@id=\"is_subscribed\"]")).click();

    }

    @Test
    public void userDifferentConfirmPassRegTest() {
        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement registerButton = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        registerButton.click();

        driver.findElement(By.id("firstname")).sendKeys("Auto");
        driver.findElement(By.id("middlename")).sendKeys("Ini");
        driver.findElement(By.id("lastname")).sendKeys("Test");
        driver.findElement(By.name("email")).sendKeys("QAautotest@mailinator.com");
        driver.findElement(By.name("password")).sendKeys("autotest123");
        driver.findElement(By.id("confirmation")).sendKeys("autotest");
        driver.findElement(By.xpath("//*[@id=\"is_subscribed\"]")).click();

    }

    @Test
    public void invalidMailRegTest() {

        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement registerButton = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        registerButton.click();

        driver.findElement(By.id("firstname")).sendKeys("Auto");
        driver.findElement(By.id("middlename")).sendKeys("Ini");
        driver.findElement(By.id("lastname")).sendKeys("Test");
        driver.findElement(By.name("email")).sendKeys("QAautotest@mailinator");
        driver.findElement(By.name("password")).sendKeys("autotest123");
        driver.findElement(By.id("confirmation")).sendKeys("autotest");
        driver.findElement(By.xpath("//*[@id=\"is_subscribed\"]")).click();
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }


}
