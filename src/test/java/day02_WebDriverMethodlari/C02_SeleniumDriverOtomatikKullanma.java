package day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C02_SeleniumDriverOtomatikKullanma {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= new EdgeDriver();

        // driver objesini her olusturdugumuzda
        // Selenium istedigimiz browser'in bir kopyasini olusturur
        // kapat demezsek olusturulan browser acik kalir
        // Kodlar cok hizli calistigi icin bazi asamalari gozle gorebilmek
        // veya internetdeki yavasliktan dolayi
        // testin failed olmamasi icin
        // Thread.sleep() ile kodlari istedigimiz sure kadar durdurabiliriz

        Thread.sleep(2000);

        driver.get("https://www.amazon.com");

        driver.close();

    }
}
