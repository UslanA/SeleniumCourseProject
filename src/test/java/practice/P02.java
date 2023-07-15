package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    /*
     . .Exercise2...

     */
    public static void main(String[] args) {
        //1-Driver oluşturalim
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        //2-Java class'imiza chnomedriver.exet i tanitalim
        WebDriver driver = new ChromeDriver();
        //3-Driver'in tum ekranı kaplamasini saglayalim
        driver.manage().window().fullscreen();
        //4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        //5-"https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");
        //6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String title =driver.getTitle();
        String url = driver.getCurrentUrl();
        //7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
        String expectedIcerik = "OTTO";
        if (title.contains(expectedIcerik)) {
            System.out.println("Title 'OTTO' iceriyor, test PASSED");
        } else {
            System.out.println("Title 'OTTO' icermiyor, test FAILED");
        }
        if (url.contains(expectedIcerik)) {
            System.out.println("Url 'OTTO' iceriyor, test PASSED");
        } else {
            System.out.println("Url 'OTTO' icermiyor, test FAILED");
        }
        //8-Ardindan "https://wisequarter.com/" adresine gidip
        driver.navigate().to("https://wisequarter.com/");
        //9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
        title = driver.getTitle();
        expectedIcerik = "Quarter";
        if (title.contains(expectedIcerik)) {
            System.out.println("Title 'Quarter' iceriyor, test PASSED");
        } else {
            System.out.println("Title 'Quarter' icermiyor, test FAILED");
        }
        //10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        //11-Sayfayı yenileyelim
        driver.navigate().refresh();
        //12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
        driver.navigate().forward();
        //13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}

