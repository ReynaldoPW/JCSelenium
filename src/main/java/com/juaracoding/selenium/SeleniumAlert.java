package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        JavascriptExecutor js =(JavascriptExecutor) driver; //untuk memanggil method scroll
        driver.get("https://demoqa.com/alerts");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title page :  "+title);
        //alert button
//        driver.findElement(By.id("alertButton")).click();
//        driver.switchTo().alert().accept();
        //timer button
//        driver.findElement(By.id("timerAlertButton")).click();
//        try{
//            Thread.sleep(5000);
//        }catch (InterruptedException e){
//            throw new RuntimeException(e);
//        }
//        driver.switchTo().alert().accept();
        //confirm button
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        //prompt button
//        driver.findElement(By.id("promtButton")).click();
//        driver.switchTo().alert().sendKeys("Rey");
//        driver.switchTo().alert().accept();
        System.out.println("Alert Ok Clicked");
        System.out.println("Delay 3 Seconds");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
