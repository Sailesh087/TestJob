package aws.utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup WebDriverManager and initialize the WebDriver for Chrome or Edge
        String browser = System.getProperty("browser", "edge");  // Use system property to choose browser (default to Chrome)


        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            // Create ChromeOptions object to customize Chrome session
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            // Create EdgeOptions object to pass additional arguments to Edge
            EdgeOptions options = new EdgeOptions();

            // Add arguments to EdgeOptions
            options.addArguments("--remote-allow-origins=*"); // Allow cross-origin requests
            options.addArguments("--disable-blink-features=AutomationControlled"); // Disable automation detection

            driver = new EdgeDriver(options);
        }

        driver.manage().window().maximize();
        driver.get("https://hiring.amazon.ca/login#/"); // Navigate to your test page
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
