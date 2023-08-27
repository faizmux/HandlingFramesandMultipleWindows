package MyTests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ImageUrls extends BaseTest {

    @Test
    public void imageLinks() throws InterruptedException {
        //driver.get("https://www.imdb.com/chart/top/");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[1]/div[2]/div/div/div/div[1]/div/div[2]/a/div")).click();
        List<WebElement> urls = driver.findElements(By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[2]//div//a//img"));
        System.out.println("Count of urls" + urls.size());
    }

}
