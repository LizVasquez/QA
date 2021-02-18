package basicJUnit;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


public class BasicJUnit {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("---------> Before Class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("---------> after Class");
    }


    @Before
    public void before(){
        System.out.println("---------> Before");
    }
    @After
    public void after(){
        System.out.println("---------> After");
    }



    @Test
    public void verify_some_thing(){
        System.out.println("LOGICA DEL TEST");

    }

    @Test
    public void verify_some_thing2(){
        System.out.println("LOGICA DEL TEST 2");

    }
    @Test
    @Ignore
    public void verify_some_thing3(){
        System.out.println("LOGICA DEL TEST 3");

    }

    @Test//(timeout = 2000)
    public void verify_some_thing4(){
        System.out.println("LOGICA DEL TEST 4 -- velocidad del metodo");

    }


}
