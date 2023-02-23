package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class demoOrangehrm {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.get("https://www.google.com/");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        //locator
//        driver.findElement(By.xpath("//*[@id=\'tree-node\']/ol/li/span/button\n")).click();
//        driver.findElement(By.xpath("//*[@id=\'tree-node\']/ol/li/ol/li[3]/span/label/span[3]\n")).click();
//        String txtDownloads = driver.findElement(By.xpath("//*[@id=\"result\"]/span[2]\n")).getText();// getText() digunakan untuk scrapping
//        System.out.println(txtDownloads);
        //demoOrangehrm
//        driver.findElement(By.name("username")).sendKeys("Admin");
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
//        System.out.println("Button login clicked");

        //Google LinkText
        driver.findElement(By.linkText("Gmail")).click();

        System.out.println("Delay 3 Seconds");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");
    }
}
