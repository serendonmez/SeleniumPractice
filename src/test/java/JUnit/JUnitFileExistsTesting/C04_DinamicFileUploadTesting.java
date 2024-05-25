package JUnit.JUnitFileExistsTesting;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class C04_DinamicFileUploadTesting extends TestBaseAll {


    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim
        //3.day12 altindaki upload.png dosyasini dinamik olarak secelim.

        String yuklenecekDosyaninDosyaYolu = System.getProperty("user.dir") +
                "/src/test/java/day12_fakerClass_fileTestleri/upload.png";

        //   /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team141_JUnit      /src/test/java/day12_fakerClass_fileTestleri/upload.png";
        //   C:\\Users\\Toshiba\\IdeaProjects\\Team141_JUnit                            \\src\\test\\java\\day12_fakerClass_fileTestleri\\upload.png
        //   C:\\Users\\qenbe\\Desktop\\team1414_JUnit                                  \\src\\main\\java\\test\\day12_fakerClass_failTestleri\\upload.png


        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        String filePath= System.getProperty("user.dir") +"\\src\\test\\java\\JUnit\\JUnitFileExistsTesting\\upload.png";


        chooseFileButonu.sendKeys(filePath);

        driver.findElement(By.className("button")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String expectedYazi = "File Uploaded!";
        String actualYazi = driver.findElement(By.tagName("h3")).getText();
        ReusableMethods.bekle(1);



        Assertions.assertEquals(expectedYazi,actualYazi);



        System.out.println( "user.dir ===>> " + System.getProperty("user.dir"));
    }
}
