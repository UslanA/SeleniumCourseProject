package day03_Webelements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_AmazonAramaTesti {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdrive.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfasina gidiniz
        driver.get("https://www.amazon.com/");

        // Arama cubuguna Nutella yazdirip
        /*
            Bir webelement'i kullanabilmek icin
            Oncelikle o webelemntinin driver"in bulabilmesi icin locate etmeliyiz
            yani yerini driver'a tarif edecek bilgiye ulasmaliyiz

            amazon arama cubugu icin bu bilginin id=twotabsearchtextbox oldugunu
            amazon sayfasinda arastirma yaparak bulduk

            Sonra bu locate bilgisini kullanarak, web sayfasinda o elementi bulup,
            bu class'da o webelementi kullanabilmek icin kaybedecek bir hazir method'a
            ihtiyacimiz var

         */
        WebElement aramaKutusuElemnti = driver.findElement(By.id("twotabsearchtextbox"));
        /*
            Bu satirda 3 islem yapiliyor
            1- locate islemi : id = twotabsearchtextbox
            2- bu locate'i kullanarak istedigimiz arama kutusunu bize getirecek
                method ==> driver.findElement(locate stratejisi)
            3- locate edip, findElement() ile buldugumuz web elementi
            icinde bulundugumuz class'da kullana bilmek icin bir WebElement objesine atamak
         */
        aramaKutusuElemnti.sendKeys("Nutella");
        aramaKutusuElemnti.submit();

         //Arama Sonuclarinin Nutella icerdigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("sg-col-inner"));

        /*
        System.out.println(aramaSonucElementi);
        aramaSonucElementi objesi bir WebElement olarak olusturduk
        WebElemnt bir primitive data turu olmadigindan
        direkt yazdirmak istersek referansini yazdirir
         */
        String expectedIcerik = "Nutella";
        String actualSonucYazisi = aramaSonucElementi.getText();

        if (actualSonucYazisi.contains(expectedIcerik)) {
            System.out.println("Nutella arama sonuc Testi PASSED");
        } else {
            System.out.println("Nutella arama sonuc Testi FAILED");
        }

        System.out.println(aramaSonucElementi.getText());


        Thread.sleep(3000);
        driver.close();





    }
}
