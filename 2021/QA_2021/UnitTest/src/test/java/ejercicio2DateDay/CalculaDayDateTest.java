package ejercicio2DateDay;

import ejercicio2Tarea.CalculaDayDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class CalculaDayDateTest {
    private int day;
    private String month;
    private int year;
    private int hour;
    private int minute;
    private int second;
    private String expectedResult;

    public CalculaDayDateTest(int day, String month, int year, int hour, int minute, int second, String expectedResult) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects = new ArrayList<>();

        objects.add(new Object[]{15,"febrero",2000,13,00,00,"15 febrero 2000 13:00:01"});
        objects.add(new Object[]{31,"diciembre",2020,23,59,59,"1 enero 2020 00:00:00"});
        objects.add(new Object[]{28,"febrero",2021,23,59,59,"1 marzo 2021 00:00:00"});
        objects.add(new Object[]{32,"noviembre",2018,00,00,00,"Dia invalido"});
        objects.add(new Object[]{-5,"mayo",2000,18,00,00,"Dia invalido"});
        objects.add(new Object[]{30,"octubre",2001,27,30,00,"Hora  invalida"});
        objects.add(new Object[]{24,"junio",1999,15,30,65,"Segundo invalido"});
        objects.add(new Object[]{2,"jajaja",1600,23,10,00,"Mes invalido"});
        objects.add(new Object[]{28,"julio",-1,18,45,32,"Año invalido"});
        objects.add(new Object[]{18,"marzo",2010,19,75,00,"Minuto invalido"});
        objects.add(new Object[]{2,"marte",1500,23,15,00,"Mes invalido"});



        return objects;

    }

    @Test
    public void verify_day_date(){
        CalculaDayDate calculaDayDate = new CalculaDayDate();
        //String actualResult = calculaDayDate.resultado(this.day, this.month, this.year,this.hour, this.minute, this.second);
        //Assert.assertEquals("Invalido", this.expectedResult, actualResult);


    }
}
