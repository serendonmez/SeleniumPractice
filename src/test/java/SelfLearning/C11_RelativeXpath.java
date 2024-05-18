package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {

        /*
        Relative Xpath Soru
1- https://testotomasyonu.com/addremove/ adresine gidin
2- Add Element butonuna basin
3- Remove butonu’nun gorunur oldugunu test edin
4- Remove tusuna basin
5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
         */
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.get("https://testotomasyonu.com/addremove/");

        WebElement addButton= driver.findElement(By.xpath("//*[@*='sub-btn']"));
        addButton.click();



        WebElement removeButton = driver.findElement(By.xpath("//*[@*='remove-btn']"));

        if(removeButton.isDisplayed()){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        //<h2>Add/Remove Elements</h2> --> att ve value su yok sadece text var bu durumda
        // TagName ile identify edebiliriz

       //  WebElement yazi= driver.findElement(By.tagName("h2"));


        WebElement yazi= driver.findElement(By.xpath("//h2"));

        if (yazi.isDisplayed()){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        removeButton.click();

        Thread.sleep(5000);

        driver.quit();


    }
}
