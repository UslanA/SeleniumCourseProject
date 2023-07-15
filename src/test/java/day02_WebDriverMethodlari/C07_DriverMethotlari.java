package day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_DriverMethotlari {
    public static void main(String[] args) {
        //1.Yeni bir class olusturalim (Homework)

        System.setProperty("Webdriver,chrome,driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        //(title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi
        //yazdirin.
        driver.get("https://www.facebook.com");
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Facebook title testi Passed");
        } else {
            System.out.println("Facebook title testi Failed \nSayfa basligi : " + actualTitle );
        }

        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        //“actual” URL’i yazdirin.
        String expectedUrlContend = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlContend)) {
            System.out.println("Facebook Url testi Passed");
        } else {
            System.out.println("Facebook Url testi Failed \nactual Url : " + actualUrl);
        }

        //4.https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/ ");

        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
         String expectedTitleContent = "Walmart.com";
        actualTitle = driver.getTitle();

        if (actualUrl.contains(expectedTitle)) {
            System.out.println("Walmart title testi Passed");
        } else {
            System.out.println("Walmart title Failed \nSayfa basligi : " + actualTitle );
        }

        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        //7. Sayfayi yenileyin
        driver.navigate().refresh();

        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //9.Browser’i kapatin
        driver.close();



    }
}
