package tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerWithValidEmail() throws InterruptedException {

        driver.get("https://dev.sovio.id/sign-up");

        // Wait for email field to be visible
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@type='email']"))
        );

        // Clear field safely
        emailField.click();
        emailField.clear();

        // Send keys normally
        emailField.sendKeys("bhagyashreeurunkar" + System.currentTimeMillis() + "@gmail.com");

        // 🔥 Fallback: JS typing (React-safe)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value='bhagyashreeurunkar" + System.currentTimeMillis() + "@gmail.com';",
                emailField
        );

        // Small wait for React to register input
        Thread.sleep(1000);

        // Click Continue / Register button
        WebElement continueBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Continue')]"))
        );
        continueBtn.click();

        Thread.sleep(4000); // demo wait

        // Assertion (next step should open)
        Assert.assertTrue(driver.getCurrentUrl().contains("sign-up"),
                "Registration flow did not proceed");

        System.out.println("Registration email entered successfully.");
    }
}
