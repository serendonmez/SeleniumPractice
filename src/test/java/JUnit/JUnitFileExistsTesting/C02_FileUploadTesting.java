package JUnit.JUnitFileExistsTesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class C02_FileUploadTesting {


    @Test

    public  void Test(){

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement dosyaSec= driver.findElement(By.xpath("//*[@id='file-upload']"));

        String FilePath= "C:\\Users\\User\\Desktop\\luminoslogo.png";
        dosyaSec.sendKeys(FilePath);

        WebElement upload= driver.findElement(By.xpath("//*[@class='button']"));
        upload.click();
        Assertions.assertTrue(Files.exists(Paths.get(FilePath)));


        // uploaded testi icin:
        WebElement uploaded= driver.findElement(By.xpath("//*[text()='File Uploaded!']"));

        String expectedUploadedText= "File Uploaded!";
        String actualUploadedText= uploaded.getText();

        Assertions.assertEquals(expectedUploadedText,actualUploadedText);







    }
}
