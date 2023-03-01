package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocator {
    public static void main(String[] args) {
        //Setup
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor js =(JavascriptExecutor) driver; //untuk memanggil method scroll

        //test URL
        String url = "https://demoqa.com/text-box";
        driver.get(url);
//       driver.get("https://www.google.com");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
        String titleHeader =driver.getTitle();
        System.out.println("Title header: "+titleHeader);
        //locator
        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title page :  "+title);


        //form identity
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("info@juaracoding.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        //Scroll by pixel(vertical)
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("submit")).click();
        System.out.println("Data berhasil disimpan");

        //verify
        System.out.println("Test Case Result :");
        if(title.equals("Text Box")){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }


        //quit browser
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
