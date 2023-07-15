package day03_Webelements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) {
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("WebDriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryElementsList = driver.findElements(By.className("panel-heading"));

        //4- Category bolumunde 3 element oldugunu test edin
        if (categoryElementsList.size() == 3) {
            System.out.println("Category element sayisi testi PASSED");
        } else {
            System.out.println("Category element sayisi testi FAILED");
        }

        //5- Category isimlerini yazdirin
        /*
        System.out.println(categoryElementleriList);

            Biz bir listeyi direk olarak yazdirabiliriz
            ANCAK
            Bu liste WebElement'ler icerdigi icin
            direk yazdirmak istersek
            bize 3 tane referans degeri yazdirir

            WebElementleri direk yazdiramayacagimiz icin
            bir for-each loop kullanarak
            herbir webElement'i alip
            onun uzerindeki text'i yazdirmaliyiz
         */
        for (WebElement eachelement : categoryElementsList ) {
            System.out.println(eachelement.getText());
        }

        //6- Sayfayi kapatin
        driver.close();


    }
}
