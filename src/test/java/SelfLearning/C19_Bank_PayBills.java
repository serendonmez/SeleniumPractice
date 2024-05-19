package SelfLearning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C19_Bank_PayBills {

    /*
    1. http://zero.webappsecurity.com
sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine “username” yazdirin
4. Password alanina “password” yazdirin
5. Sign in buttonuna tiklayin
6. Back tusu ile sayfaya donun
7. Online Banking menusunden Pay Bills sayfasina gidin
8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
9. tarih kismina “2023-09-10” yazdirin
10. Pay buttonuna tiklayin
11. “The payment was successfully submitted.” mesajinin ciktigini test edin
     */


 @Test
    public void bankTest() throws InterruptedException {

     System.setProperty("WebDriver.chrome.driver","src/main/KurulumDosyalari/chromedriver.exe");
     WebDriver driver= new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("http://zero.webappsecurity.com");

     driver.findElement(By.className("icon-signin"))
             .click();
     Thread.sleep(3000);

     driver.findElement(By.xpath("//*[@*='text']")).sendKeys("username");
     driver.findElement(By.id("user_password")).sendKeys("password");


     Thread.sleep(3000);

     WebElement signin= driver.findElement(By.xpath("//*[@name='submit']"));
     signin.click();

     driver.navigate().back();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//*[@*='online-banking']")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click(); ////*[@id='pay_bills_link'] //   (//span[@class='headers'])[4]
  Thread.sleep(3000);

     driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("100"+ Keys.ENTER+"2023-09-10");
     Thread.sleep(3000);
    // driver.findElement(By.className("date")).sendKeys("2023-09-10");
     Thread.sleep(3000);
     driver.findElement(By.id("pay_saved_payees")).click();
     Thread.sleep(3000);


    WebElement text= driver.findElement(By.xpath("//span[@title='$ 100 payed to payee sprint']"));


    String actualText= text.getText();

    String expectedText="The payment was successfully submitted.";

     Assertions.assertEquals(actualText,expectedText);

     driver.quit();

 }




}
