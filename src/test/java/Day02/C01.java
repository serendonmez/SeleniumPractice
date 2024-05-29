package Day02;

import Utilities.Utilities.ReusableMethods;
import Utilities.Utilities.TestBaseAll;
import org.junit.jupiter.api.Test;

public class C01 extends TestBaseAll {

    /*
         //....Exercise-1:...
                 // Create a new class with main method
                 // Set Path
                 // Create a chrome driver
                 // Maximize window
                 // Open google home page https://www.google.com
                 // On the same class, navigate to wisequarter home page https://www.wisequarter.com and navigate back to google
                 // Wait about 4 sn
                 // Navigate forward to wisequarter
                 // Refresh page
                 // Close/quit the browser
                 // And Last step print "All is well" on console
         */


    @Test
    public void test(){


    driver.get("https://www.google.com");

    driver.navigate().to("https://www.wisequarter.com");
    driver.navigate().back();
        ReusableMethods.bekle(4);
        driver.navigate().forward();
        driver.navigate().refresh();

        System.out.println("All is well");
    }

}
