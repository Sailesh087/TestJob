package aws.utility;

import org.testng.annotations.Test;

import java.util.Scanner;

public class TestClass extends BaseTest {

    @Test
    public void testExample() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        int loopCount=0;
        // Ask the user to manually input credentials
       do {
           driver.navigate().refresh();
           loopCount++;
           System.out.println(loopCount);
           Thread.sleep(2000);
           homePage.waitForElementToBeClickable();
           Thread.sleep(2000);

       }
       while (loopCount<100) ;

        // Start test

        homePage.clickOnMyAccountTab(); // Perform action on the element
        // Add assertions to verify the outcome
    }
}