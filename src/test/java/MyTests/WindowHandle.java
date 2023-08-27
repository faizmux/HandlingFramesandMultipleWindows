package MyTests;

import Base.BaseTest;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class WindowHandle extends BaseTest {

    @Test
    public void windowHandle() throws IOException {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        //Get the main window handle
        String mainWindowHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='getwebsitebtn']")));
        //Try it button have some issue which is used another element link to new window
        WebElement getWebsite = driver.findElement(By.xpath("//a[@id='getwebsitebtn']"));
        getWebsite.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String titleOfPage = driver.getTitle();
        System.out.println(titleOfPage);
        String urlOfPage = driver.getCurrentUrl();
        System.out.println(urlOfPage);
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenShotFile, new File("src/test/resources/screenshots/ss3.png"));
        System.out.println("Screenshot is captured");

        //close the new window
        driver.close();

        //switch back to main window
        driver.switchTo().window(mainWindowHandle);
        String urlMain = driver.getCurrentUrl();
        System.out.println(urlMain);

    }
}
