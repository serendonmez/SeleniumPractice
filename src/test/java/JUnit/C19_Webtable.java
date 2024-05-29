package JUnit;

import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C19_Webtable extends TestBaseAll {


      /*
    1. “https://testotomasyonu.com/webtables2” sayfasina gidin
 2. Headers da bulunan basliklari yazdirin
 3. 3.sutunun basligini yazdirin
 4. Tablodaki tum datalari yazdirin
 5. Tabloda kac tane cell (data) oldugunu yazdirin
 6. Tablodaki satir sayisini yazdirin
 7. Tablodaki sutun sayisini yazdirin
 8. Tablodaki 3.kolonu yazdirin
 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
     */

    @Test
    public void Test (){

        driver.get("https://testotomasyonu.com/webtables2");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headers= driver.findElements(By.xpath("//*[@role='hrow']/*"));
        for (WebElement each: headers  ) {
            System.out.println(each.getText());
        }

        //3. 3.sutunun basligini yazdirin
        System.out.println("ucuncuSutun baslik ");
        System.out.println(headers.get(2).getText());
        System.out.println("------------------");

        //4. Tablodaki tum datalari yazdirin

       List< WebElement> tumTable=driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata']"));
        System.out.println("tabloyu yazdirin");
       for (WebElement each: tumTable  ) {
           System.out.println(each.getText());
       }
        System.out.println("-----------------");

       // 5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("tablo size : "+tumTable.size());

        // 6. Tablodaki satir sayisini yazdirin
        List< WebElement> satir=driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("satir sayisi : "+satir.size());
        // 7. Tablodaki sutun sayisini yazdirin
        List< WebElement> sutun=driver.findElements(By.xpath("//*[@role='trow'][1]/*[@role='tdata']"));
        System.out.println("tablodaki sutun sayisi :"+sutun.size());
        // 8. Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuSutun = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));

        System.out.println("ucuncu kolon : ");

        for ( WebElement each: ucuncuSutun   ) {
            System.out.println(each.getText());
        }

        System.out.println("---------------------");

        // 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
       WebElement furnitureFiyat=driver.findElement(By.xpath("//*[@role='trow'][3]/*[@role='tdata'][3]"));

        System.out.println("furniture fiyat : ");
        System.out.println(furnitureFiyat.getText());

        System.out.println("------------------");
        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        printCell(2,3);

    }


    public void printCell(int satir, int sutun){


        String tableLocater= "//*[@role='trow']["+satir+"]/*[@role='tdata']["+sutun+"]";


        WebElement cell= driver.findElement(By.xpath(tableLocater));

        System.out.println(cell.getText());

    }





}
