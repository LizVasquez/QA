package ejercicio4TestEstatico;

import Ejercicio4Estatico.Cajero2;

import ejercicio4.BDUtil;

import ejercicio4.ClientDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Parameterized.class)
@PrepareForTest({BDUtil.class,ClientDB.class})

public class Cajero2TestEstatico {
    @Parameterized.Parameter(0)
    private boolean conexion;
    @Parameterized.Parameter(1)
    private int ci;
    @Parameterized.Parameter(2)
    private int saldo;
    @Parameterized.Parameter(3)
    private int amount;
    @Parameterized.Parameter(4)
    private boolean actualizacionMock;
    @Parameterized.Parameter(5)
    private String expectedResult;


    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects= new ArrayList<>();
        objects.add(new Object[]{true,101010,1000,50,true,"Usted esta sacando la cantidad de 50 y tiene en saldo 950"});
        objects.add(new Object[]{true,101010,100,20,true,"Usted esta sacando la cantidad de 20 y tiene en saldo 80"});
        objects.add(new Object[]{true,101010,5000,2500,true,"Usted esta sacando la cantidad de 2500 y tiene en saldo 2500"});

        objects.add(new Object[]{true,101010,5000,0,true,"Amount No Valido"});


        objects.add(new Object[]{false,101010,5000,0,true,"Conexion a BD no fue satisfactoria"});
        objects.add(new Object[]{false,101010,5000,0,false,"Conexion a BD no fue satisfactoria"});
        objects.add(new Object[]{false,101010,0,1,true,"Conexion a BD no fue satisfactoria"});


        objects.add(new Object[]{true,101010,200,201,true,"Usted no tiene suficiente saldo"});

        objects.add(new Object[]{true,101010,10000,11000,true,"Usted no tiene suficiente saldo"});

        return objects;

    }

    @Test
    public void verify_calculate_cajero(){
        // Paso 3
        PowerMockito.mockStatic(Ejercicio4Estatico.BDUtil.class);
        PowerMockito.mockStatic(Ejercicio4Estatico.ClientDB.class);
        
        // Paso 4
        Mockito.when(Ejercicio4Estatico.BDUtil.updateSaldo(this.ci,this.saldo-this.amount)).thenReturn(this.actualizacionMock);
        Mockito.when(Ejercicio4Estatico.ClientDB.isConnectionSuccessfully("mysql")).thenReturn(this.conexion);
        Cajero2 cajero= new Cajero2();
        String actualResult= cajero.getCash(this.ci,this.amount);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }
}
