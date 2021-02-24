package ejercicio4Test;

import ejercicio4.BDUtil;
import ejercicio4.Cajero;
import ejercicio4.ClientDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class CajeroTest {
    private boolean conexion;
    private int ci;
    private int saldo;
    private int amount;
    private boolean actualizacionMock;
    private String expectedResult;

    public CajeroTest(boolean conexion,int ci, int saldo,int amount, boolean actualizacionMock, String expectedResult){
        this.conexion=conexion;
        this.ci=ci;
        this.saldo = saldo;
        this.amount=amount;
        this.actualizacionMock=actualizacionMock;
        this.expectedResult=expectedResult;
    }
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

    BDUtil dbUtilMocked= Mockito.mock(BDUtil.class);
    ClientDB clientDBMocked= Mockito.mock(ClientDB.class);
    @Test
    public void verify_calculate_cajero(){
        // Paso 3
        Mockito.when(dbUtilMocked.updateSaldo(this.ci,this.saldo-this.amount)).thenReturn(this.actualizacionMock);
        Mockito.when(clientDBMocked.isConnectionSuccessfully("mysql")).thenReturn(this.conexion);

        // Paso 4
        Cajero cajero= new Cajero(this.saldo,dbUtilMocked,clientDBMocked);
        String actualResult= cajero.getCash(this.ci,this.amount);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }
}



