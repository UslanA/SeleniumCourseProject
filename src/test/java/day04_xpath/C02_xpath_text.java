package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_xpath_text {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna basin

        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        // 3- Delete butonu’nun gorunur oldugunu test edin

        WebElement deleteButtonElenmti = driver.findElement(By.xpath("//*[text()='Delete']"));

        if (deleteButtonElenmti.isDisplayed()) {
            System.out.println("delete butonu gorunme testi PASSED");
        } else {
            System.out.println("delete butonu gorunme testi FAILED");
        }

        // 4- Delete tusuna basin

        deleteButtonElenmti.click();

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveButtonElenmti = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveButtonElenmti.isDisplayed()) {
            System.out.println("delete butonu gorunme testi PASSED");
        } else {
            System.out.println("delete butonu gorunme testi FAILED");
        }

        driver.close();


    }
}
