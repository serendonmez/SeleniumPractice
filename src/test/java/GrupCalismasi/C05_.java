package GrupCalismasi;

import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C05_ extends TestBaseAll {




    @Test
    public void tes () {


        //1."https://testotomasyonu.com/webtables" adresine gidin


        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin

        List<WebElement> tumBody= driver.findElements(By.xpath("//tbody//tr"));


        for ( WebElement each : tumBody ) {
            System.out.println(each.getText());
        }



        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin


        WebElement tumbody2= driver.findElement(By.xpath("//tbody"));

        System.out.println(tumbody2.getText());
        String actual= tumbody2.getText();
       String expected="Comfortable Gaming Chair";


        Assertions.assertTrue(actual.contains(expected));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin

        List<WebElement> satir = driver.findElements(By.xpath("//tbody//tr"));

        int expectedSatir = 5 ;
        int actualSatir= satir.size();
        Assertions.assertEquals(expectedSatir,actualSatir);

        //5. Tum satirlari yazdirin
        for ( WebElement each : satir ) {
            System.out.println(each.getText());
        }


        //6. Web table’daki sutun sayisinin 4 olduğunu test edin

        List<WebElement> sutun = driver.findElements(By.xpath("//tbody//tr[1]//td"));

        int expectedSutun= 4;
        int actualSutun= sutun.size();

        Assertions.assertEquals(expectedSutun,actualSutun);
        //7. 3.sutunu yazdirin

        List<WebElement> ucuncuSutun= driver.findElements(By.xpath("//tbody//tr//td[3]"));

        for ( WebElement each : ucuncuSutun ) {
            System.out.println(each.getText());
        }


        //8. Tablodaki basliklari yazdirin

        List<WebElement> title= driver.findElements(By.xpath("//thead/tr/th"));

        for ( WebElement each : title) {
            System.out.println(each.getText());
        }

        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(cell(2, 3));


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        WebElement furniture= driver.findElement(By.xpath("//tbody/tr[4]/td[2]"));

        String expectedData= "Furniture";
        String actualData= furniture.getText();

        Assertions.assertEquals(expectedData,actualData);


        // 11. tabloda category'si "Men Fashion" olan urun bulundugunu test edin

        satir = driver.findElements(By.xpath("//tbody//tr"));

        boolean menFashionVarMi= false;
        for (int i = 1; i <= satir.size(); i++) {
            if (cell(i,2).equals("Men Fashion")){

                menFashionVarMi=true;
            }



        }
        Assertions.assertTrue(menFashionVarMi);


        System.out.println("--------------------------------------------------");


        List<WebElement> category =driver.findElements(By.xpath("//tbody/tr/td[2]"));



        String expectedCategory= "Men Fashion";
        for ( WebElement each : category ) {
            if (each.getText().contains(expectedCategory)){
                Assertions.assertEquals(each.getText(), expectedCategory);

            }
        }



    }




    public  String cell (int satir , int sutun ){

        //        //tbody/tr    /td

        String satirSutun = "//tbody/tr["+ satir+"]/td["+sutun+"]";

        WebElement table= driver.findElement(By.xpath(satirSutun));



       return   table.getText();
    }


}
