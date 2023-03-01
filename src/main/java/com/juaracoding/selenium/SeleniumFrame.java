package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumFrame {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       JavascriptExecutor js =(JavascriptExecutor) driver; //untuk memanggil method scroll
        String url = "https://demoqa.com/frames";
        driver.get(url);
        System.out.println("Get URL :"+url);
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title page :  "+title);

        //alert dan iframe pakai switchTo
        //masuk frame
        WebElement frameSamplePage = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameSamplePage);

        String txtFrame = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtFrame);

        //Keluar dari frame
        driver.switchTo().defaultContent();
        String descFrame = driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]")).getText();
        System.out.println(descFrame);

        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Scroll");
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[contains(@id,'item-4')]")).click();
        System.out.println("modal dialog clicked");

        driver.findElement(By.id("showSmallModal")).click();
        String txtTitleModal = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-sm']")).getText();
        System.out.println(txtTitleModal);
        String txtBodyModal = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(txtBodyModal);

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
