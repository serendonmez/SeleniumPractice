package JUnit.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class C02_ExcelKacSatirdanOlusmus {


    /*
    - 85.satirdaki 2.hucreye gidelim ve yazdiralim
 - 85.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
 - 3.satir 4.cell’in Arnavutluk un  baskenti oldugunu test edelim
 - Satir sayisini bulalim
 - Fiziki olarak kullanilan satir sayisini bulun
 - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */

    @Test
    void test () throws IOException {


        String dosyaYolu= "src/test/java/JUnit/excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        System.out.println("85.satirdaki 2.hucre : "+sayfa1.getRow(84).getCell(1)); //Tokyo

       System.out.println("--------------");

       String seksenBEsinciSatirikinciHucre=( sayfa1.getRow(84).getCell(1)).toString();

        System.out.println("seksenBEsinciSatirikinciHucre  : "+seksenBEsinciSatirikinciHucre); //Tokyo

        System.out.println("---------------------------------------------");
        String actualArnavutlukBaskenti = String.valueOf(sayfa1.getRow(2).getCell(3));
        String exceptedArnavutlukBaskenti= "Tiran";


        Assertions.assertEquals(exceptedArnavutlukBaskenti,actualArnavutlukBaskenti);



        System.out.println("last row Num : "+sayfa1.getLastRowNum()); // son satir sayisi : 191

        System.out.println("-------------------------");


        System.out.println("Fiziki olarak kullanilan satir sayisi : "+sayfa1.getPhysicalNumberOfRows()); // 192

        System.out.println("-------------------------------------");




    }
}
