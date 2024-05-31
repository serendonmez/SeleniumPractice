package JUnit.excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ExcelTablosundaUlkeVarMi {




    @Test
   public void test() throws IOException {



        String dosyaYolu= "src/test/java/JUnit/excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // kayitli ulkeler arasinda ingilizce ismi Netherlands olan bir ulke
        // bulundugunu test edin

        Sheet sayfa1= workbook.getSheet("Sayfa1");

        System.out.println(sayfa1.getRow(0).getCell(1).toString());

        int sonSatir= sayfa1.getLastRowNum();





        boolean netherlandsVarMi= false;

        for (int i =0; i <= sonSatir; i++) {
            if (sayfa1.getRow(i).getCell(0).toString().equalsIgnoreCase("Netherlands")){


                netherlandsVarMi=true;
            }

        }
        Assertions.assertTrue(netherlandsVarMi);


                // kayitli ulkeler icinde ingilizce baskent ismi Ankara olan ulkenin
               // ingilizce isminin Turkey oldugunu test edin


        for (int i = 0; i <sonSatir ; i++) {


            if(sayfa1.getRow(i).getCell(1).toString().equalsIgnoreCase("Ankara")){

              String actualTurkey= sayfa1.getRow(i).getCell(0).toString();

               Assertions.assertEquals("Turkey",actualTurkey);
            }

        }










    }




}
