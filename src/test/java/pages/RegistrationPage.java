package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "email")
    private WebElement emailInput;
    
    @FindBy(name = "password")
    private WebElement passwordInput;
    
    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordInput;
    
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Register')]")
    private WebElement registerButton;
    
    @FindBy(className = "error-message")
    private WebElement errorMessage;
    
    @FindBy(className = "success-message")
    private WebElement successMessage;
    
    @FindBy(xpath = "//div[contains(@class,'password-strength')]")
    private WebElement passwordStrengthIndicator;
    
    @FindBy(xpath = "//input[@type='checkbox' and @name='terms']")
    private WebElement termsCheckbox;
    
    @FindBy(linkText = "Sign In")
    private WebElement signInLink;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegister() {
        driver.get("https://dev.sovio.id/register");
        waitForPageLoad();
    }

    public void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void acceptTerms() {
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
    }

    public void clickRegister() {
        registerButton.click();
    }

    public void register(String email, String password, String confirmPassword) {
        setEmail(email);
        setPassword(password);
        setConfirmPassword(confirmPassword);
        acceptTerms();
        clickRegister();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return isErrorMessageDisplayed() ? errorMessage.getText() : "";
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getSuccessMessage() {
        return isSuccessMessageDisplayed() ? successMessage.getText() : "";
    }

    public boolean isPasswordStrengthVisible() {
        try {
            return passwordStrengthIndicator.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getPasswordStrengthText() {
        return passwordStrengthIndicator.getText();
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public boolean isRegisterFormDisplayed() {
        try {
            return emailInput.isDisplayed() && passwordInput.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void waitForPageLoad() {
        wait.until(d -> ((JavascriptExecutor) d)
            .executeScript("return document.readyState").equals("complete"));
    }
}