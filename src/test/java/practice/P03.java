package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    public static void main(String[] args) {
//Exercise3...
        System.setProperty("WebDriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
//Click on  Calculater under Micro Apps
        driver.findElement(By.linkText("Calculator")).click();
//Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("110");
//Type any number in the second
        driver.findElement(By.id("number2")).sendKeys("110");
//Click on Calculate
        driver.findElement(By.className("styled-click-button")).click();
//Get the result
        String result = driver.findElement(By.id("answer")).getText();
//Print the result
        System.out.println("result: "+result);

        driver.close();

    }
}
