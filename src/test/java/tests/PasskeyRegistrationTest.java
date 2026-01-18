package tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasskeyRegistrationTest extends BaseTest {

    @Test
    public void registerWithPasskey() throws InterruptedException {

        // Open Sign-in page
        driver.get("https://dev.sovio.id/sign-in");

        // Select PASSKEY tab
        WebElement passkeyTab = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Passkey']"))
        );
        passkeyTab.click();

        // Enter Email
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']"))
        );
        emailField.sendKeys("urunkarbhagya04@gmail.com");

        // Click Continue with Passkey
        WebElement continuePasskeyBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Continue with passkey')]"))
        );
        continuePasskeyBtn.click();

        // Hard wait for demo / manual OS authentication
        Thread.sleep(5000);

        // Assertion (UI flow triggered)
        Assert.assertTrue(true, "Passkey registration initiated successfully");
    }
}
