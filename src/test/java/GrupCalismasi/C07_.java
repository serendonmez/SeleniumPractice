package GrupCalismasi;

import Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C07_ extends TestBaseAll {



    @Test
    public void test(){

        //1. “https://testotomasyonu.com/webtables2” sayfasina gidin

        driver.get("https://testotomasyonu.com/webtables2");

        System.out.println("-----------headers i yazdirdik---");
        //2. Headers da bulunan basliklari yazdirin

        List<WebElement> titles= driver.findElements(By.xpath("//*[@role='hrow']/* [@role='hdata']"));
        for ( WebElement each : titles ) {
            System.out.println(each.getText());
        }

        System.out.println(" 3. sutunbaslik yazdiridk -------------");
        //3. 3.sutunun basligini yazdirin
        WebElement ucuncuBaslik= driver.findElement(By.xpath("//*[@role='hrow'][1]/* [@role='hdata'][3]"));
        System.out.println(ucuncuBaslik.getText());


        System.out.println("---------------------");

        System.out.println(titles.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tumTable = driver.findElements(By.xpath("//*[@role='trow']/* [@role='tdata']"));


        for ( WebElement each: tumTable) {
            System.out.println(each.getText());
        }


        System.out.println("-------------");
        //5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("tum tablei size i yazdiridk :\n"+tumTable.size()+" ");
        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi= driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("satir sayisi:  "+satirSayisi.size());

        System.out.println("-------------------");
        //7. Tablodaki sutun sayisini yazdirin

        List<WebElement> sutunSayisi= driver.findElements(By.xpath("//*[@role='trow'][1]/* [@role='tdata']"));

        System.out.println("Sutun sayisi = "+sutunSayisi.size());






        //8. Tablodaki 3.kolonu yazdirin

        System.out.println("3. kolon : ");
        List<WebElement> ucuncuKolon = driver.findElements(By.xpath("//*[@role='trow']/* [@role='tdata'][3]"));
        for ( WebElement each
                 : ucuncuKolon  ) {
            System.out.println(each.getText());
        }

        //9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin


        System.out.println(" 3 satir 3. sutun");

        System.out.println(cell(3, 3));


        //10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin







    }




    public String cell(int satir , int sutun){


        String istenenCell= driver
                .findElement(By.xpath("//*[@role='trow']["+satir+"]/* [@role='tdata']["+sutun+"]")).getText();


    return  istenenCell;
    }
}
