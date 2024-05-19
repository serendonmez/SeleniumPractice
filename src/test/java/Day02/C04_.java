package Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C04_ {
    public static void main(String[] args) {

        /* Exercise3... */
// Navigate to  https://testpages.herokuapp.com/styled/index.html
// Click on  Calculater under Micro Apps
// Type any number in the first input
// Type any number in the second input
// Click on Calculate
// Get the result
// Print the result

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/index.html");

       // Actions actions = new Actions(driver);
       // actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.id("calculatetest")).click();








    }
}
