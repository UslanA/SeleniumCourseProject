package day03_Webelements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Locators {

    public static void main(String[] args) {
        /*
            Locator :   Verdigimiz locate bilgisini kullanarak
                        driver'in locate etmesini saglayan hazir method'lardir
            Selenium'da 8 adet Locator vardir
                   - Ilk 6 tanesi WebElementi olusturan HTML kodun icerigine baglidir
                        1- By.id
                        2- By.name
                        3- By.className
                        4- By.linkText
                        5- By.partialLinkText
                        6- By.tagName
                    - Son 2 adet ise her turlu WebElement icin kullanilabilir
                        7- By.xPath
                        8- By.cssSellector
         */
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

        // amazon anasayfasina gidin
        driver.get("https://www.amazon.com/");

        //arama kutusuna nutella yazip aratin

        WebElement aramaKutusuElemnti = driver.findElement(By.name("field-keywords"));
        aramaKutusuElemnti.sendKeys("Nutella");
        aramaKutusuElemnti.submit();

        // gosterilen urun resimlerinin 10'dan fazla oldugunu test edin
        List<WebElement> urunIsimElementleriList = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));

        int actualUrunAdet = urunIsimElementleriList.size();


        if (actualUrunAdet > 10) {
            System.out.println("Amazon arama sonucu 10'dan fazladir/ Test PASSED");
        } else {
            System.out.println("Amazon arama sonucu 10'dan azdir/ Test FAILED");
        }

        /*
            Locator stratejisi olarak By.className secildiginde
            class attribute'unun degeri space iceriyorsa
            locate islemi basarisiz olabilir
            List<WebElement> urunIsimElementleriList = driver.findElements(By.className("a-size-base-plus a-color-base a-text-normal"));
         */

        // 5.urun ismini yazdirin ve ismin Nutella icerdigini test edin
        System.out.println(urunIsimElementleriList.get(5).getText());

        String expectedProductNameContained = "Nutella";
        String actualProductName = urunIsimElementleriList.get(5).getText();

        if (actualProductName.contains(expectedProductNameContained)) {
            System.out.println("amazon urun ismi testi Passed");
        } else {
            System.out.println("amazon urun ismi testi Passed");
        }

        driver.close();

    }
}
