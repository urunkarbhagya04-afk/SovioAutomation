package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    private WebElement dashboardHeader;
    
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    private WebElement logoutButton;
    
    @FindBy(linkText = "Security Settings")
    private WebElement securitySettingsLink;
    
    @FindBy(xpath = "//button[contains(text(),'Register Passkey')]")
    private WebElement registerPasskeyButton;
    
    @FindBy(xpath = "//div[contains(@class,'user-profile')]")
    private WebElement userProfile;
    
    @FindBy(className = "welcome-message")
    private WebElement welcomeMessage;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(dashboardHeader)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getWelcomeMessage() {
        try {
            return welcomeMessage.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public void navigateToSecuritySettings() {
        securitySettingsLink.click();
    }

    public void clickRegisterPasskey() {
        registerPasskeyButton.click();
    }

    public boolean isUserProfileDisplayed() {
        try {
            return userProfile.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}