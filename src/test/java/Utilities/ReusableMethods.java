package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ReusableMethods {


    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static  void listYazdir(List<WebElement> list){

        for (WebElement each : list   ) {
            System.out.println(each.getText());
        }


    }



    public static void windowaGecis(String url, WebDriver driver){


        Set<String> handles= driver.getWindowHandles();

        for ( String each : handles   ) {

            driver.switchTo().window(each);

            if (driver.getCurrentUrl().equals(url)){
                break;
            }
        }





    }




    public static void takeScreenshot(WebDriver driver )  {


        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        File tumSayfaScreenshot= new File("target/Screenshots/ekranResmi.png");

        File geciciDosya= takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void takeScreenshot(WebDriver driver, String raporIsmi)  {
        bekle(2);
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        File tumSayfaScreenshot= new File("target/Screenshots/"+ raporIsmi+".png");
        File geciciDosya= takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public  static void takeWebElementScreenshot ( String WebelementDosyaISmi,WebElement webElement){


        File dosyaYolu= new File("target/Screenshots/"+WebelementDosyaISmi+".png");

        File geciciDosya= webElement.getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(geciciDosya,dosyaYolu);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
