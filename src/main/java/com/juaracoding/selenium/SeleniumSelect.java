package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SeleniumSelect {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js =(JavascriptExecutor) driver; //untuk memanggil method scroll
        String url = "https://demoqa.com/select-menu";
        driver.get(url);
        System.out.println("Get URL :"+url);
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title page :  "+title);

        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select color = new Select(selectColor);
        selectColor.getText();
        color.selectByValue("10");
        System.out.println("Aqua");
        color.selectByIndex(9);
        System.out.println("Magenta");
        color.selectByVisibleText("Black");
        System.out.println("Test Select");

        System.out.println("===Delay 3 Seconds===");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");
    }
}
