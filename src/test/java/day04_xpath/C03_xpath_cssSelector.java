package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_xpath_cssSelector {
    public static void main(String[] args) {
        //1- bir class olusturun
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedTitleContined = "Spend Less";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleContined)) {
            System.out.println("Title test' PASSED");
        } else {
            System.out.println("Title test' PASSED");
        }
        //6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();
        //7- Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();
        //8- Best Seller bolumunden ilk urunu tiklayin
        List<WebElement> bestSellerUrunlerElementleri = driver.findElements(By.xpath
                ("//div[@class='a-section a-spacing-mini a-spacing-top-micro acs-product-block__product-image']"));
        bestSellerUrunlerElementleri.get(0).click();
        //9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("//span[@class='a-button a-button-toggle']")).click();
        //10-Urun ucretinin 25$ oldugunu test edin
        String expectedUrunUcreti = "25$";
        String actualUrunUcreti = driver.findElement(By.cssSelector("#gc-live-preview-amount")).getText();
        //.xpath("//span[@class='']")).getText();

        if (actualUrunUcreti.equals(expectedUrunUcreti)) {
            System.out.println("Urun Ucrei testi PASSED");
        } else {
            System.out.println("Urun Ucrei testi FAILED\nActual ucret :" + actualUrunUcreti );
        }

        //11-Sayfayi kapatin
        driver.close();
    }
}
