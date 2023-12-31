package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {
    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
  //Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        //Under the ORIGINAL CONTENTS
        //click on Alerts
        driver.findElement(By.linkText("Alerts")).click();
        //print the URL
        System.out.println(driver.getCurrentUrl());
        //navigate back
        driver.navigate().back();
        //print the URL
        System.out.println(driver.getCurrentUrl());
        //Click on Basic Ajax
        driver.findElement(By.linkText("Basic Ajax")).click();
        //print the URL
        System.out.println(driver.getCurrentUrl());
        //enter value 20 and ENTER
        driver.findElement(By.id("lteq30")).sendKeys("20" + Keys.ENTER);
        //and then verify Submitted Values is displayed open page
        if (driver.findElement(By.xpath("//p[text()='Submitted Values']")).isDisplayed()) {
            System.out.println("Submitted Values is displayed, test PASSED");
        } else {
            System.out.println("Submitted Values is'nt displayed, test FAILED");
        }

        //close driver
        driver.close();
    }
}
