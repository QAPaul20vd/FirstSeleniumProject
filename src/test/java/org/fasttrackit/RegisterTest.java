package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    @Test
    public void userRegistrationTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement accountButton = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountButton.click();

        WebElement registerButton = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        registerButton.click();

        driver.findElement(By.id("firstname")).sendKeys("Test1");
        driver.findElement(By.id("middlename")).sendKeys("Ini");
        driver.findElement(By.id("lastname")).sendKeys("Last");
        driver.findElement(By.name("email")).sendKeys("paulbvd@gmail.oom");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.id("confirmation")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"is_subscribed\"]")).click();



//        driver.quit();
    }
}
