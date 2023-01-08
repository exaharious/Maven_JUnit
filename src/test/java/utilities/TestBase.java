package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestBase {

    //TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
    // TestBase testBase=new TestBase();->YAPİLAMAZ
    //Amacim bu sinifi extend etmek ve icindeki hazir methodlari kullanmak

    //driver objesi olustur. Driver ya public yada protected olmali .
    // Sebebi child classlarda gorulebilir olmasi
    protected  static WebDriver driver;

    //setUp
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //tearDown
    @After
    public void tearDown(){
        driver.quit();
    }

    //           MULTIPLE WINDOW:
    //    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
    //    ORNEK:
    //    driver.get("https://the-internet.herokuapp.com/windows");
    //    switchToWindow("New Window");
    //    switchToWindow("The Internet")
    public static void switchToWindow(String targetTitle){
        String origin=driver.getWindowHandle();
        for (String handle:driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);
    }

     //    windowNumber sıfır (0)'dan başlıyor.
     //    index numarasini parametre olarak alir
     //    ve o indexli pencerece gecis yapar
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }
    /*   HARD WAIT:
    @param : second
    */
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}