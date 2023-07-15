package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P05 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        driver.manage().deleteAllCookies();

        driver.findElement(By.name("firstname")).sendKeys("Omer Asim"+ Keys.ENTER);
        Thread.sleep(1000);
        WebElement lastnameElementi = driver.findElement(By.name("lastname"));
        lastnameElementi.sendKeys("Uslan");
        Thread.sleep(1000);
        lastnameElementi.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("sex-0")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("exp-0")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("datepicker")).sendKeys("21.01.2023");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='profession-0']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("tool-2")).click();
        Thread.sleep(1000);

        WebElement ddm01 = driver.findElement(By.id("continents"));
        WebElement ddm02 = driver.findElement(By.id("selenium_commands"));
        Select select = new Select(ddm01);
        select.selectByVisibleText("Europe");
        Thread.sleep(1000);
        select = new Select(ddm02);
        select.selectByVisibleText("Browser Commands");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@name='submit']")).click();
        Thread.sleep(1000);
        driver.close();




    }
}
