package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P07 {
    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");
        //2 ) Nurse 3 farkli relative locator ile locate edin
        WebElement doctorElements = driver.findElement(By.id("dr_thumb"));
        WebElement firemanElements = driver.findElement(By.id("frmn_thumb"));
        WebElement policemanElements = driver.findElement(By.id("pol_thumb"));
        WebElement sellerElements   = driver.findElement(By.id("sll_thumb"));

        WebElement nurse01 = driver.findElement(RelativeLocator.with(By.tagName("img")).
                below(doctorElements).above(sellerElements));
        WebElement nurse02 = driver.findElement(RelativeLocator.with(By.id("nurs_thumb")).
                toLeftOf(policemanElements).toRightOf(firemanElements));
        WebElement nurse03 = driver.findElement(RelativeLocator.with(By.className("ui-li-thumb")).
                above(sellerElements).toRightOf(firemanElements));

        //3 ) Relative locator’larin dogru calistigini test edin
        if (nurse01.getAttribute("id").equals("nurs_thumb")) {
            System.out.println("nurse01 Relative locator calisiyor, Test PASSED");
        } else {
            System.out.println("nurse01 Relative locator calismiyor, Test FAILED");
        }
        System.out.println("===============================================");
        if (nurse02.isDisplayed()) {
            System.out.println("nurse02 Relative locator calisiyor, Test PASSED");
        } else {
            System.out.println("nurse02 Relative locator calismiyor, Test FAILED");
        }
        System.out.println("===============================================");
        if (nurse03.getAttribute("id").equals("nurs_thumb")) {
            System.out.println("nurse03 Relative locator calisiyor, Test PASSED");
        } else {
            System.out.println("nurse03 Relative locator calismiyor, Test FAILED");
        }

        driver.close();
    }
}
