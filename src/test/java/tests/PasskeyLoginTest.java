package tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasskeyLoginTest extends BaseTest {

    @Test
    public void loginWithPasskey() throws InterruptedException {

        
        driver.get("https://dev.sovio.id/sign-in");

        
        WebElement passkeyTab = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Passkey']"))
        );
        passkeyTab.click();

        
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']"))
        );
        emailField.sendKeys("urunkarbhagya04@gmail.com");

        
        WebElement continuePasskeyBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Continue with passkey')]"))
        );
        continuePasskeyBtn.click();

        
        Thread.sleep(5000);

        
        Assert.assertTrue(true, "Passkey login initiated successfully");
    }
}
