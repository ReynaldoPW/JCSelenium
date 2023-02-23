package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxSelenium {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        JavascriptExecutor js =(JavascriptExecutor) driver; //untuk memanggil method scroll
        driver.get("https://demoqa.com/checkbox");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        //locator
        driver.findElement(By.xpath("//*[@id=\'tree-node\']/ol/li/span/button\n")).click();
        driver.findElement(By.xpath("//*[@id=\'tree-node\']/ol/li/ol/li[3]/span/label/span[3]\n")).click();
        String txtDownloads = driver.findElement(By.xpath("//*[@id=\"result\"]/span[2]\n")).getText();// getText() digunakan untuk scrapping
        System.out.println(txtDownloads);

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
