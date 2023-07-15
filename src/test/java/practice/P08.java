package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class P08 {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10809));

        String ht="https://www.";
        driver.get(ht+"google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to(ht+"amazon.com");
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        String fristPageWH= driver.getWindowHandle();
        System.out.println(fristPageWH);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(ht+"wisequarter.com");
        String secondPageWH= "";
        Set<String> pageWHD = driver.getWindowHandles();
        System.out.println(pageWHD);
        for (String each: pageWHD) {
            if (!fristPageWH.equals(each)) {
                secondPageWH = each;
                break;
            }
        }
        System.out.println(secondPageWH);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(ht+"babayigit.net/");


        //driver.close();
        driver.quit();

    }
}
