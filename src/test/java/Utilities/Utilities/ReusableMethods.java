package Utilities.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    public static WebElement istenenIframeGec(WebDriver driver,int kacinciIframe,String url) throws InterruptedException {
        driver.get(url);
        List<WebElement> iframes= driver.findElements(By.tagName("iframe"));


        System.out.println(iframes);
            String iframeWebelement="";
            WebElement istenenIframe=null;

        for (int i = 1; i < iframes.size(); i++) {
            if (i==kacinciIframe){
                iframeWebelement= iframes.get(i).getText();
                istenenIframe= driver.findElement(By.xpath(iframeWebelement));
                Thread.sleep(3);
                driver.switchTo().frame(istenenIframe);
                break;

            }



        }
     return istenenIframe;
    }
}
