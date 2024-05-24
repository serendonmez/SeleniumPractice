package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.util.List;
import java.util.Set;

public class ReusableMethods {


    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*3000);
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
}
