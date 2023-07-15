package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    public static void main(String[] args) throws InterruptedException {
        //  1-Driver oluşturalim
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        //  2-Java class'imiza chnomedriver. exetyi tanitalim
        WebDriver driver = new ChromeDriver();
        //  3-Driver'in tum ekranı kaplamasini sagu ayalim
        driver.manage().window().maximize();
        //  4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
            //Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10809));
        //  5-Navigate to http://www.babayigit.net/murat/testpage.html
        driver.navigate().to("http://www.babayigit.net/murat/testpage.html");
        //  6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
            //alanlarına gerekli bilgileri yazsın
        driver.findElement(By.xpath("//input[@id='ad']")).sendKeys("Adem");
        driver.findElement(By.xpath("//input[@name='soyad']")).sendKeys("Uslan");
        driver.findElement(By.id("yas")).sendKeys("40");
        driver.findElement(By.name("meslek")).sendKeys("QA-Software Tester");
        driver.findElement(By.id("dogum_yeri")).sendKeys("Fethiye");
        driver.findElement(By.name("mezun_okul")).sendKeys("Harran Universty");
        driver.findElement(By.id("cocuk_sayisi")).sendKeys("3");
        //  7- Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        //  8- All information was entered correctly.. yazısının göründüğünü test etsin
        WebElement textElementi = driver.findElement(By.id("uyari"));
        if (textElementi.isDisplayed()) {
            System.out.println("All information was entered correctly.. Uyarisi Goruntulendi" +
                    "\nTest PASSED");
        } else {
            System.out.println("Yazi Goruntulenemedi. Test FAILED");
        }
        //  9- Clear butonu ile tüm butonları temizlesin
        driver.findElement(By.xpath("//input[@value='Clear']")).click();
        //  10- Manuel olarak temizlendiğini görecek kadar beklesin
        Thread.sleep(2000);
        //  11- Sayfayı kapatsın
        driver.close();

    }
}
