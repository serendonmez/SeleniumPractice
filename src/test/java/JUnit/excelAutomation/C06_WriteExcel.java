package JUnit.excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.*;

public class C06_WriteExcel {


    @Test
    public void test() throws IOException {

        String dosyaYolu= "src/test/java/JUnit/excelAutomation/ulkeler.xlsx";

        FileInputStream fileInputStream= new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1= workbook.getSheet("Sayfa1");

     //1. satir 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim

        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue(1500000);

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(250000);
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue(54000);

        //9) 45. satirin 5. sutununa 1300000 yazdirin

        sayfa1.getRow(44).createCell(4).setCellValue(1300000);


        //10) Dosyayi kaydedelim


        FileOutputStream fileOutputStream=new FileOutputStream(dosyaYolu);

        workbook.write(fileOutputStream);


        // !!!!!!!!!!!!!! excel dosyasinin acik olmadigindan emin olup!!!!!!!!!!!!!!!!!!!!!
        //  olusturacagimiz FileOutputStream objesi ile bilgileri excel'e kaydedebiliriz



        //11)Dosyayi kapatalim

        fileInputStream.close();
        fileOutputStream.close();





    }




















}
