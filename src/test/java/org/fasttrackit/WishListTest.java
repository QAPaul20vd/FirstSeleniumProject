package org.fasttrackit;

import org.junit.AfterClass;
import org.junit.Assert;
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
    public void addToWishListUserNotLoggedIn() {

        driver.get("https://fasttrackit.org/selenium-test/");

//        Navigate to Sale Menu
        WebElement saleButton = driver.findElement(By.cssSelector(".nav-5"));
        saleButton.click();

//        Navigate to Detail page of the first product
        WebElement detailsButton = driver.findElement(By.cssSelector(".products-grid > li:first-child a[title^=View]"));
        detailsButton.click();

//        Verify that the user is not Logged In
        driver.findElement(By.cssSelector(".skip-account")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[title='Log In']")).isDisplayed());

//        Add product to wishlist
        WebElement addToWishlist = driver.findElement(By.cssSelector(".link-wishlist"));
        addToWishlist.click();

//        Verify that the user is redirected to the Login Page
        WebElement loginButton = driver.findElement(By.cssSelector("button[title='Login']"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @Test
    public void addToWishListUserLoggedIn(){

        driver.get("https://fasttrackit.org/selenium-test/");

//        Login with valid account
        WebElement accountButton = driver.findElement(By.cssSelector(".skip-account"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("a[title^=Log]"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("QAautotest@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("autotest123");
        driver.findElement(By.cssSelector("#send2")).click();

//        Verify that the User is Logged In
        WebElement helloText = driver.findElement(By.cssSelector(".welcome-msg .hello"));
        Assert.assertEquals("Hello, Auto Test!", helloText.getText());

        driver.findElement(By.cssSelector(".skip-account")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[title='Log Out']")).isDisplayed());

//        Navigate to Sale Menu
        WebElement saleButton = driver.findElement(By.cssSelector(".nav-5"));
        saleButton.click();

//      Navigate to Detail page of the first product
        WebElement detailsButton = driver.findElement(By.cssSelector(".products-grid > li:first-child a[title^=View]"));
        detailsButton.click();

//        Add product to WishList
        WebElement addToWishList = driver.findElement(By.cssSelector(".link-wishlist"));
        addToWishList.click();

//        Verify that the product is added to My WishList
        WebElement myWishList = driver.findElement(By.cssSelector(".my-wishlist"));
        Assert.assertTrue(myWishList.isDisplayed());
    }

    @Test
    public void removeItem(){
        driver.get("https://fasttrackit.org/selenium-test/");

//        Login with valid account
        WebElement accountButton = driver.findElement(By.cssSelector(".skip-account"));
        accountButton.click();

        WebElement loginLink = driver.findElement(By.cssSelector("a[title^=Log]"));
        loginLink.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("QAautotest@mailinator.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("autotest123");
        driver.findElement(By.cssSelector("#send2")).click();

//        Verify that the User is Logged In
        WebElement helloText = driver.findElement(By.cssSelector(".welcome-msg .hello"));
        Assert.assertEquals("Hello, Auto Test!", helloText.getText());

        driver.findElement(By.cssSelector(".skip-account")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[title='Log Out']")).isDisplayed());

//        Navigate to Sale Menu
        WebElement saleButton = driver.findElement(By.cssSelector(".nav-5"));
        saleButton.click();

//      Navigate to Detail page of the first product
        WebElement detailsButton = driver.findElement(By.cssSelector(".products-grid > li:first-child a[title^=View]"));
        detailsButton.click();

//        Add product to WishList
        WebElement addToWishList = driver.findElement(By.cssSelector(".link-wishlist"));
        addToWishList.click();

//        Verify that the product is added to My WishList
        WebElement myWishList = driver.findElement(By.cssSelector(".my-wishlist"));
        Assert.assertTrue(myWishList.isDisplayed());

//        Click on Remove Button
        driver.findElement(By.cssSelector(".btn-remove")).click();
//        Accept to remove
        driver.switchTo().alert().accept();

//        Verify if the wishlist is empty
        Assert.assertTrue(driver.findElement(By.cssSelector(".wishlist-empty")).isDisplayed());
    }

    @Test
    public void editDetails(){
        addToWishListUserLoggedIn();

        driver.findElement(By.cssSelector("td:nth-child(5) a.link-edit")).click();

        driver.findElement(By.cssSelector("span img")).click();

        driver.findElement(By.cssSelector(".input-box ul li:nth-child(3)")).click();

        driver.findElement(By.cssSelector("li:first-child a.link-compare")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("td:nth-child(5) a.details")).isDisplayed());
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }
}
