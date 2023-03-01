package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogin {

    WebDriver driver;
    String pathChromeDriver ="C:\\selenium\\chromedriver_win32\\chromedriver.exe";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",pathChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
    }

    @Test(priority = 3)
    public void testValidLogin(){
        delay(1);
        //step action
        validLogin("Admin","admin123");

        //step verify
        String txtDashboard = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();

        Assert.assertEquals(txtDashboard,"Dashboard");
    }

//    @Test(priority = 2)
//    public void logoutAccount(){
        //step action
//        logout();
        //step verify
//        String titlePage =driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")).getText();
//        Assert.assertEquals(titlePage,"Login");
//    }
    @Test(priority = 1)
    public void testInvalidLogin(){
        delay(1);
        //step action
        invalidLogin("rey","admin123");

        //step verify
        String txtInvalidLogin =driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
        Assert.assertEquals(txtInvalidLogin,"Invalid credentials");
    }
    @Test(priority = 2)
    public void testInvalidLoginUsernamePasswordNull(){
        delay(1);
        //step action
        invalidLogin("","");

        //step verify
        String txtInvalidLogin =driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
        Assert.assertEquals(txtInvalidLogin,"Invalid credentials");
    }

    @AfterClass
    public void quitBrowser(){
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    void validLogin(String username,String password){
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    void invalidLogin(String username, String password){
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

//    void logout(){
//        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
//        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
//    }
    static void delay(long detik){
        try{
            Thread.sleep(detik*1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
