package JUnit;

import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class C11_kontrolsuzAcilanYeniWindowaGecis extends TestBaseAll {

    @Test

    public void test(){

        Set<String> butunWindowHandles= driver.getWindowHandles();
        String hedefUrl="https://www.youtube.com/";

        for ( String each :butunWindowHandles   ) {

         driver.switchTo().window(each);
         if (driver.getCurrentUrl().equals(hedefUrl)){
             break;
         }

        }

        System.out.println(driver.getTitle());






    }
}
