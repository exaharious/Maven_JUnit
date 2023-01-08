package day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before

    public void stup(){
        System.out.println("Her test Methodundan önce calisir");
    }

    @After
    public void tearDown(){
        System.out.println("Her test Methodundan Sonra Çalışır");
    }

    @Test

    public void test01(){
        System.out.println("İlk Test");
    }

    @Test
    public void test02() {
        System.out.println("İkinci Test");
    }
}
