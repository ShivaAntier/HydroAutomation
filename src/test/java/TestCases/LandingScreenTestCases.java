package TestCases;

import Helper.BaseClass;
import PageObjects.LandingScreen;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class LandingScreenTestCases extends BaseClass {

    LandingScreen landingScreen = new LandingScreen();

    @BeforeMethod
    void testStart() {
        super.openBrowser();
    }

    @AfterMethod
    void testCLose() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    void signUpWithGoogle() throws InterruptedException {
        landingScreen.signUpWithGoogle().click();
        Thread.sleep(3000);
        String a = driver.findElement(By.xpath("//div[text()='Sign in with Google']")).getText();
        try {
            Assert.assertEquals("Sign in with Google", a);
        } catch (Exception e) {
            Assert.fail("signUpWithGoogle test Fail    ::   " + a);
            takeScreenshot(driver, "src/test/java/ScreenShots/LandingScreen/signUpWithGoogle.png");
        }
    }

    @Test
    void signUpWithEmailMandatoryFields() {
        landingScreen.signUpWithEmail().click();
        landingScreen.fullName().click();
        landingScreen.email().click();
        landingScreen.password().click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250","");
        landingScreen.confirmPassword().click();
        landingScreen.checkbox().click();
        Assert.assertEquals("This field is mandatory.", driver.findElement(By.xpath("//form[@class='register']/div[1]/p")).getText());
        Assert.assertEquals("This field is mandatory.", driver.findElement(By.xpath("//form[@class='register']/div[2]/p")).getText());
        Assert.assertEquals("This field is mandatory.", driver.findElement(By.xpath("//form[@class='register']/div[3]/p")).getText());
        Assert.assertEquals("This field is mandatory.", driver.findElement(By.xpath("//form[@class='register']/div[4]/p")).getText());
    }
}
