package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
}
