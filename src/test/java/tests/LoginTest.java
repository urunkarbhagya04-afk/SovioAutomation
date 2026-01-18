package tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

       
        driver.get("https://dev.sovio.id/sign-in");

       
        WebElement passwordTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Password')]")
                )
        );
        passwordTab.click();

        
        WebElement emailField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[type='email']")
                )
        );
        emailField.clear();
        emailField.sendKeys("urunkarbhagyashree@gmail.com");

     
        WebElement passwordField = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[type='password']")
                )
        );
        passwordField.clear();
        passwordField.sendKeys("Bhagyashree@04");

        // Click Sign In
        WebElement signInBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Sign in')]")
                )
        );
        signInBtn.click();

        
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("sign-in")
        ));

        
        Assert.assertFalse(
                driver.getCurrentUrl().contains("sign-in"),
                "Login failed: still on sign-in page"
        );
    }
}
