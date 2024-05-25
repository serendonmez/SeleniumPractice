package JUnit.JUnitFileExistsTesting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;


public class C03_DinamicFileTesting {



    @Test
    public void test(){


        //C:\\Users\\User\\ --> bu kisim herkes icin farkli old icin Java codelariyla
        // bu kismi standardize etmis ("user.home") + dosyanin adi
        // Desktop\\luminoslogo.png" --> dosya adi

        String desktopFilePath=System.getProperty("user.home")+"\\Desktop\\luminoslogo.png";


        Assertions.assertTrue(Files.exists(Paths.get(desktopFilePath)));


    }














}
