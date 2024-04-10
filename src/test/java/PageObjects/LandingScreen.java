package PageObjects;

import Helper.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingScreen extends BaseClass {

    public WebElement signUpWithGoogle(){
        return driver.findElement(By.xpath("//*[@class='home_left_buttonGoogle']/button"));
    }
    public WebElement signUpWithEmail(){
        return driver.findElement(By.xpath("//button[@type='button']"));
    }
    public WebElement fullName(){
        return driver.findElement(By.xpath("//input[@id='fullName']"));
    }
    public WebElement email(){
        return driver.findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement password(){
        return driver.findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement confirmPassword(){
        return driver.findElement(By.xpath("//input[@id='confirmPassword']"));
    }
    public WebElement checkbox(){
        return driver.findElement(By.xpath("//input[@id='default-checkbox']"));
    }
}
