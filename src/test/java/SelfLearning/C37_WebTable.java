package SelfLearning;

import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C37_WebTable extends TestBaseAll {


    /*
1. “https://demoqa.com/webtables” sayfasina gidin
 2. Headers da bulunan basliklari yazdirin
 3. 3.sutunun basligini yazdirin
 4. Tablodaki tum datalari yazdirin
 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
 6. Tablodaki satir sayisini yazdirin
 7. Tablodaki sutun sayisini yazdirin
 8. Tablodaki 3.kolonu yazdirin
 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
10. bir method olusturun, satir ve sutun sayisi girildiğinde datayi yazdirin
 */


    @Test


    public  void test (){


        //1. “https://demoqa.com/webtables” sayfasina gidin


        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin

        List<WebElement> header= driver.findElements(By.xpath("//*[@role='row']/*[@role='columnheader']"));

        System.out.println("header ");
        for ( WebElement each: header   ) {
            System.out.println(each.getText());
        }

        System.out.println("---------------------");


        // 3. 3.sutunun basligini yazdirin

        System.out.println("3. sutun baslik : "+header.get(2).getText());
        System.out.println("----------------------");

        // 4. Tablodaki tum datalari yazdirin

        List<WebElement> tumData= driver.findElements(By.xpath("//*[@role='rowgroup']//*[@class='rt-td']"));

        System.out.println("tum table data");

        for ( WebElement each : tumData ) {

            System.out.println(each.getText());
        }

        System.out.println("---------------------");
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin


        int toplamDoluCell= 0;
        for ( WebElement
               each :  tumData  ) {
          if(! each.getText() .isBlank()){
              toplamDoluCell++;
          }
        }
        System.out.println("toplam yazili cell : "+ toplamDoluCell);

        System.out.println("-----------------");

        // 6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirList= driver.findElements(By.xpath("//*[@role='rowgroup']"));
        System.out.println("sati sayisi: "+satirList.size());


        // 7. Tablodaki sutun sayisini yazdirin




        List<WebElement> sutunList= driver.findElements(By.xpath("//*[@role='rowgroup'][1]//*[@role='gridcell']"));
        System.out.println(" tablodaki sutun sayisi "+sutunList.size());


        System.out.println("-----------------");


        // 8. Tablodaki 3.kolonu yazdirin


        List<WebElement> ucuncuKolun = driver.findElements(By.xpath("//*[@role='rowgroup']//*[@role='gridcell'][3]"));

        System.out.println("ucuncu kolon : ");
        for ( WebElement each : ucuncuKolun ) {
            System.out.println(each.getText());
        }

        System.out.println("------------------------");
        // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        tumData= driver.findElements(By.xpath("//*[@role='rowgroup']//*[@class='rt-td']"));

        System.out.println("kierra nin salarysi");
        for ( WebElement each : tumData) {
           if (each.getText().equalsIgnoreCase("Kierra")){
               System.out.println(tumData.get(1).getText());


           }
        }
        System.out.println("---------------");


        //10. bir method olusturun, satir ve sutun sayisi girildiğinde datayi yazdirin

        System.out.println("2,4 : ");
        satirSutun(2,4);
    }


    public void satirSutun (int satir, int sutun){


        String dinamicTableWebElement= "//*[@role='rowgroup']["+satir+"]//*[@role='gridcell']["+sutun+"]";


        WebElement tumData=driver.findElement(By.xpath(dinamicTableWebElement));

        System.out.println(tumData.getText());


    }
}
