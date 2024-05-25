package JUnit;

import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;


import java.util.Set;

public class C17_Cookies extends TestBaseAll {

     /*
    1- amazon anasayfaya gidin
2- tum cookie’leri listeleyin
3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
6- eklediginiz cookie’nin sayfaya eklendigini test edin
7- ismi skin olan cookie’yi silin ve silindigini test edin
8- tum cookie’leri silin ve silindigini test edin
     */



    @Test
    public void test(){

     driver.get("https://www.amazon.de/ref=nav_logo");

        //2- tum cookie’leri listeleyin
        Set<Cookie> tumCookieSeti= driver.manage().getCookies();


        for ( Cookie each :tumCookieSeti) {

            System.out.println(each);
        }



        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assertions.assertTrue(tumCookieSeti.size() > 5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String expectedCookieDegeri = "USD";
        String actualCookieDegeri = driver
                .manage()
                .getCookieNamed("i18n-prefs")
                .getValue();

        Assertions.assertEquals(expectedCookieDegeri,actualCookieDegeri);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun
        //   ve sayfaya ekleyin

        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");

        driver.manage().addCookie(cookie);

        tumCookieSeti = driver.manage().getCookies();

       int  siraNo = 1;

        for (Cookie eachCookie: tumCookieSeti
        ) {
            System.out.println(siraNo +". cookie  : " + eachCookie);
            siraNo++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin


        boolean sayfayaEklendiMi=false;

        for ( Cookie each :tumCookieSeti   ) {
           if (each.getValue().equals("cikolatali")){
               sayfayaEklendiMi=true;
           }
        }
        Assertions.assertTrue(sayfayaEklendiMi);


        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");

        // silinen cookie'nin set'de olmadigini test edelim

        tumCookieSeti = driver.manage().getCookies();

        boolean skinCookieVarMi = false;

        for ( Cookie eachCookie : tumCookieSeti
        ) {

            if (eachCookie.getName().equals("skin")){
                skinCookieVarMi = true;
            }
        }

        Assertions.assertFalse(skinCookieVarMi);


        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();

        tumCookieSeti = driver.manage().getCookies(); // getCookies methodu Set döner.

        Assertions.assertTrue(tumCookieSeti.isEmpty());
    }


}

