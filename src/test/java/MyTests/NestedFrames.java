package MyTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NestedFrames extends BaseTest {

    @Test
    public void handleFrames() {
        //Navigate to url
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        System.out.println("Count of Frames: " + frames.size());

        //locate the top frame and switch to it
        driver.switchTo().frame("frame-top");
        //switch to first child frame and print the text
        driver.switchTo().frame("frame-left");
        WebElement leftFrame = driver.findElement(By.tagName("body"));
        String leftFrameText = leftFrame.getText();
        System.out.println(leftFrameText);
        String expectedLeft = "LEFT";
        Assert.assertEquals(leftFrameText, expectedLeft);

        //Switch to parent frame and again switch to second child frame and print the text
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleFrame = driver.findElement(By.tagName("body"));
        String middleFrameText = middleFrame.getText();
        System.out.println(middleFrameText);
        String expectedMiddle = "MIDDLE";
        Assert.assertEquals(middleFrameText, expectedMiddle);

        //Switch to parent frame and again switch to third child frame and print the text
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightFrame = driver.findElement(By.tagName("body"));
        String rightFrameText = rightFrame.getText();
        System.out.println(rightFrameText);
        String expectedRight = "RIGHT";
        Assert.assertEquals(rightFrameText, expectedRight);

        //Again switch to main content and switch to second main frame and print the text of it
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrame = driver.findElement(By.tagName("body"));
        String bottomFrameText = bottomFrame.getText();
        System.out.println(bottomFrameText);
        String expectedBottom = "BOTTOM";
        Assert.assertEquals(bottomFrameText, expectedBottom);
    }
}
