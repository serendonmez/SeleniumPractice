package SelfLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C12_xPath_TextKullanimi {
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
       // WebElement addButonu = driver.findElement(By.xpath("//button[@id='sub-btn']"));
       // addButonu.click();

        driver.findElement(By.xpath("//button[text()='Add']"))
                .click();

        //  //button[text()='Remove'] == //*[text()='Remove']
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();


      WebElement addRemoveElementi=   driver.findElement
              (By.xpath("//h2[text()='Add/Remove Elements']"));


     if (addRemoveElementi.isDisplayed()){
         System.out.println("passed");
     }else {
         System.out.println("failed");
     }

     Thread.sleep(3000);

     driver.quit();

    }
}
