package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*

                                 UTILITIES:

        -Utilities tekrar tekrar kullanacagimiz classlari koydugumuz paketin adidir.
           -TestBase
           -Driver -> Sonra
           -ExcelUtil-> Sonra
           -Configuration-> Sonra
         -Utilities paketinde Test case ler yazilmaz
         -Sadece Tekrar kullanabilecek destek siniflari(support class) olusturulur.
         -Bu support classlar test caselerin yazilmasini hizlandirir.

     */

    @Test
    public void test01(){
        // techproeducation sayfasina git
        driver.get("https://techproeducation.com");

       // ve titlenin 'Bootcamps' kelimesi icerdigini test edelim.,
        String pageTitle=driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));


    }
}
