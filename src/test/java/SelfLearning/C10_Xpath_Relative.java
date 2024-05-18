package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_Xpath_Relative {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/");

        WebElement searchBox=  driver.findElement(By.xpath("//input[@id='global-search']"));


        searchBox.sendKeys("dress"+ Keys.ENTER);

        Thread.sleep(3000);


        driver.quit();

    }
}
