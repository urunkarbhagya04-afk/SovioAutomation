package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Updated locators based on Sovio application inspection
    @FindBy(name = "email")
    private WebElement emailInput;
    
    @FindBy(name = "password")
    private WebElement passwordInput;
    
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Sign In')]")
    private WebElement signInButton;
    
    @FindBy(xpath = "//button[contains(text(),'Use Passkey')]")
    private WebElement usePasskeyButton;
    
    @FindBy(className = "error-message")
    private WebElement errorMessage;
    
    @FindBy(className = "success-message")
    private WebElement successMessage;
    
    @FindBy(linkText = "Forgot Password?")
    private WebElement forgotPasswordLink;
    
    @FindBy(linkText = "Register")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void navigateToLogin() {
        driver.get("https://dev.sovio.id/login");
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

    public void clickSignIn() {
        signInButton.click();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignIn();
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

    public void clickUsePasskey() {
        usePasskeyButton.click();
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public boolean isLoginFormDisplayed() {
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