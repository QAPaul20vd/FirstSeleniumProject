package org.fasttrackit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {

    private static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void addToWishList() {

        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement saleButton = driver.findElement(By.cssSelector(".nav-5"));
        saleButton.click();

        WebElement detailsButton = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout >" +
                "div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        detailsButton.click();

        WebElement addToWishlist = driver.findElement(By.cssSelector(".link-wishlist"));
        addToWishlist.click();

    }

//    @AfterClass
//    public static void quit() {
//        driver.quit();
//    }
}
