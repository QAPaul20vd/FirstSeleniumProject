package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    @Test
    public void userValidRegTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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

        driver.quit();
    }

    @Test
    public void userDifferentPassRegTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement registerButton = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        registerButton.click();

        driver.findElement(By.id("firstname")).sendKeys("Auto");
        driver.findElement(By.id("middlename")).sendKeys("Ini");
        driver.findElement(By.id("lastname")).sendKeys("Test");
        driver.findElement(By.name("email")).sendKeys("QAautotest@mailinator.oom");
        driver.findElement(By.name("password")).sendKeys("autotest123");
        driver.findElement(By.id("confirmation")).sendKeys("autotest");
        driver.findElement(By.xpath("//*[@id=\"is_subscribed\"]")).click();

        driver.quit();
    }


}
