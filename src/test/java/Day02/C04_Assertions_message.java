package Day02;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_Assertions_message {
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
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");



        driver.findElement(By.xpath("(//*[@href='calculator'])[2]")).click();

        driver.findElement(By.id("number1")).sendKeys("150");
        driver.findElement(By.id("number2")).sendKeys("50");


        WebElement ddm= driver.findElement(By.id("function"));

        Select select= new Select(ddm);
        select.selectByValue("divide");


        String secilenoption= select.getFirstSelectedOption().getText();
        System.out.println(secilenoption);

        driver.findElement(By.id("calculate")).click();

       WebElement answer=  driver.findElement(By.id("answer"));
       String actualAnswer= answer.getText();
       String expectedAnswer="34";


        Assertions.assertEquals(expectedAnswer,actualAnswer,"cevap 3 test failed");
        // assertions da message kismi test gecmediginde hata vermek üzere yazilir.
        driver.quit();






    }
}
