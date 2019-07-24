package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest {

    @Test
    public void validLoginTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("QAautotest@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("autotest123");
        driver.findElement(By.cssSelector("#send2")).click();

//        driver.quit();
    }

    @Test
    public void invalidMailTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("QAautotest@mailinator");
        driver.findElement(By.cssSelector("#pass")).sendKeys("autotest123");
        driver.findElement(By.cssSelector("#send2")).click();

//        driver.quit();
    }

    @Test
    public void wrongPasswordTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("QAautotest@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("autotest");
        driver.findElement(By.cssSelector("#send2")).click();

//        driver.quit();
    }

    @Test
    public void emptyFieldsTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("");
        driver.findElement(By.cssSelector("#pass")).sendKeys("");
        driver.findElement(By.cssSelector("#send2")).click();

//        driver.quit();
    }

    @Test
    public void emptyFieldsTestMozilla() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("");
        driver.findElement(By.cssSelector("#pass")).sendKeys("");
        driver.findElement(By.cssSelector("#send2")).click();

//        driver.quit();
    }
}
