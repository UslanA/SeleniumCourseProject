package day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver,chrome,driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wisequarter.com");
        // driver'a url verirken www yazmasaniz da calisir
        // ANCAK https yazmazsaniz calismaz

        System.out.println("ilk sayafa size degeri : " + driver.manage().window().getSize());
        System.out.println("ilk sayafa konumu : " + driver.manage().window().getPosition());

        Thread.sleep(2000);

        driver.manage().window().maximize();
        System.out.println("Maxsimum size degeri : " + driver.manage().window().getSize());
        System.out.println("Maxsimum konumu : " + driver.manage().window().getPosition());

        Thread.sleep(2000);

        driver.manage().window().fullscreen();
        System.out.println("Tam Ekran size degeri : " + driver.manage().window().getSize());
        System.out.println("Tam Ekran konumu : " + driver.manage().window().getPosition());

        Thread.sleep(2000);
        driver.close();



    }
}
