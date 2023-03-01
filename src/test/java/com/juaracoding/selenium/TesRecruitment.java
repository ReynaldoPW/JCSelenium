package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TesRecruitment {
    WebDriver driver;
//    TestLogin testLogin;
    String pathChromeDriver ="C:\\selenium\\chromedriver_win32\\chromedriver.exe";
    JavascriptExecutor js =(JavascriptExecutor) driver;
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
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();//precondition
    }


    @AfterClass
    public void quitBrowser(){
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    @Test
    public void testAddCandidate(){
        delay(1);
        //step action
        driver.findElement(By.xpath("//span[normalize-space()='Recruitment']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Juara");
        driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("Coding");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Bootcamp");
        driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).sendKeys("Software");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")).sendKeys("juaracoding@test.com");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")).sendKeys("1234");
        String pathDoc = "C:\\Users\\Reypau\\Downloads\\New Microsoft Word Document.docx";
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(pathDoc);
        driver.findElement(By.xpath("//input[@placeholder='Enter comma seperated words...']")).sendKeys("Engineer");
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys(Keys.CONTROL,"a");
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys("2023-02-23");
        delay(3);
        driver.findElement(By.xpath("//textarea[@placeholder='Type here']")).sendKeys("testtest");
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        //step verify

    }
    static void delay(long detik){
        try{
            Thread.sleep(detik*1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
