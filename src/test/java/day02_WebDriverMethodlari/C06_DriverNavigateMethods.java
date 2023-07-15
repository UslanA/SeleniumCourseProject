package day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.wisequarter.com");
        Thread.sleep(2000);

        // ayni browser'da amazon.com anasayfasina gidelim
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);

        // tekrar wise anasayfgasina donun
        driver.navigate().back();
        Thread.sleep(2000);

        //tekrar amazon'a gidin
        driver.navigate().forward();

        driver.close();



    }
}
