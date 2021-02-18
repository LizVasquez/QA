package calculadoraTest;

import calculadora.Calculadora;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class SumaTest {
    Calculadora cal;
    @Before
    public void before(){
        cal = new Calculadora();

    }

    @Test
    public void sumarPares(){

        int actualResult = cal.suma(4, 2);
        int expectedResult= 6;
        Assert.assertEquals("ERROR, LA SUMA ES INCORRECTA",expectedResult,actualResult);

    }


    @Test
    public void sumarImpares(){

        int actualResult = cal.suma(5, 3);
        int expectedResult= 8;
        Assert.assertEquals("ERROR, LA SUMA ES INCORRECTA",expectedResult,actualResult);

    }

    @Test
    public void sumarParesImpares(){

        int actualResult = cal.suma(4, 7);
        int expectedResult= 11;
        Assert.assertEquals("ERROR, LA SUMA ES INCORRECTA",expectedResult,actualResult);

    }
}
