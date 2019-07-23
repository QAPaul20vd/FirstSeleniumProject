package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
    @Test
    public void addToWishList() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");

        WebElement saleButton = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleButton.click();

        WebElement detailsButton = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout >" +
                "div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        detailsButton.click();

        WebElement addToWishlist = driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a"));
        addToWishlist.click();



        driver.quit();
    }
}
