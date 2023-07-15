package day02_WebDriverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Implicitly wait Selenium'dan gelen Dinamik bir beklemedir
        // Sayfanin yuklenmesi veya islem yapilacak web elementlerin bulunmasi icin
        // belenecek MAXIMUM sureyi belirler,

        //Driver bu sure dolana kadar verilen gorevin yapilip yapilmadigini kontrol eder
        // bu sure icerisinde gorev yapilmaz ise
        // Exception firlatip calismayi durdurur.

        driver.get("https://www.wisequarter.com/");

        System.out.println("Sayfa acilis konumu" + driver.manage().window().getPosition());
        System.out.println("Sayfa acilis boyutu" + driver.manage().window().getSize());

        Thread.sleep(2000);

        driver.manage().window().setSize(new Dimension(1090, 700));
        driver.manage().window().setPosition(new Point(12, 12));

        System.out.println("Degisen konumu" + driver.manage().window().getPosition());
        System.out.println("Degisen boyutu" + driver.manage().window().getSize());

        Thread.sleep(3000);
        // Thread Javadan geir ve yazdigimiz sure boyunca kodlari bekletir


        driver.close();
        /*
            Implicitly wait Selenium'dan gelen DINAMIK bir beklemedir
            Sayfanin yuklenmesi veya islem yapilacak web elementlerin bulunmasi icin
            beklenecek MAXIMUM sureyi belirler

            Driver bu sure dolana kadar verilen gorevin yapilip yapilmadigini kontrol eder
            bu sure icerisinde gorev yapilamazsa
            Exception firlatip calismayi durdurur
         */
    }
}
