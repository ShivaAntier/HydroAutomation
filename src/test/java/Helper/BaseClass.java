package Helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BaseClass {
    public static WebDriver driver;

//    @Test
    public void openBrowser(){
        // Set the Chrome options
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-dashboard.hydro.online/wallet");
    }

    public void takeScreenshot(WebDriver driver, String fileName) {
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Take screenshot and save it to a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileName);

        try {
            // If the file already exists, delete it before saving the new one
            if (destFile.exists()) {
                System.out.println("Entered in the if statement");
                destFile.delete();
            }
            // Copy file to desired location
            Files.copy(srcFile.toPath(), destFile.toPath());
            System.out.println("Screenshot saved as: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
