package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_Xpath_Absolute {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //ytd-app//ytd-page-manager//ytd-two-column-browse-results-renderer//ytd-section-list-renderer//ytd-item-section-renderer[3]//ytd-shelf-renderer//yt-horizontal-list-renderer//ytd-grid-video-renderer[1]//div/h3/a

        ////ytd-item-section-renderer[3]//ytd-grid-video-renderer[1]//h3/a
        driver.get("https://www.youtube.com/c/Bar%C4%B1%C5%9F%C3%96zcan");

       WebElement videoLink= driver.findElement(By.xpath("//ytd-item-" +
               "section-renderer[3]//ytd-grid-video-renderer[1]//h3/a"));
        videoLink.click();


        Thread.sleep(10000);

        driver.quit();

    }
}
