package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class fistSite {
    WebDriver driver;

    @Test
    void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dancing-salmiakki-1738ee.netlify.app/");
        boolean a = true;
        int i = 1;
        while (a) {
            System.out.println("Iteration number  ::  "+i);
//            new Actions(driver).click().perform();
            driver.findElement(By.xpath("//button[@type='button']")).click();
            Thread.sleep(15000);

            i++;
            if (i > 2000) {
                break;
            }
        }

    }
}
