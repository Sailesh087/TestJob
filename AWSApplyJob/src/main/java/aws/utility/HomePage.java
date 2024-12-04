package aws.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@data-test-id='topPanelMyAccountLink']") // Example of a WebElement you want to interact with
    private WebElement myAccount;

    @FindBy(xpath = "//button[contains(@class, 'guidedSearchForwardButton')]") // Example of a WebElement you want to interact with
    private WebElement skipButton;

    @FindBy(xpath = "//div[@data-test-component='StencilReactCard' and contains(@class,'jobCardItem')]") // Example of a WebElement you want to interact with
    private List<WebElement> jobsList;

    @FindBy(xpath ="//div[contains(@class,'jobDetailScheduleDropdown')]")
    private WebElement workShiftElement;

    @FindBy(xpath = "//div[@data-test-id='schedulePanel']//div[@data-test-component='StencilReactCard']") // Example of a WebElement you want to interact with
    private List<WebElement> shiftHrs;

    @FindBy(xpath ="//button[@data-test-id='jobDetailApplyButtonDesktop']")
    private WebElement jobDetailApplyButtonDesktop;

    @FindBy(xpath ="   //button[contains(.,'Next')]")
    private WebElement nextButton;

      public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize WebElements
    }

    public void clickOnMyAccountTab() {
        myAccount.click();
    }

    // Method to wait for the element to be clickable
    public WebElement waitForElementToBeClickable() {
       // Wait until the element is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 seconds timeout
        return wait.until(ExpectedConditions.elementToBeClickable(skipButton));
    }

    public List<WebElement> getListOfJobs() {
       return jobsList;
    }


    public void switchTab(int index){
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(index));
    }

}
