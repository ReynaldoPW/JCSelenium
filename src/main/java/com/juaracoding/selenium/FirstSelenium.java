package com.juaracoding.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.google.com";
        driver.get(url);
//       driver.get("https://www.google.com");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
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
