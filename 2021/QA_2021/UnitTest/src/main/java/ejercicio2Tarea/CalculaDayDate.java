package ejercicio2Tarea;

public class CalculaDayDate {
    public String resultado(int day, String month, int year, int hour, int minute, int second) {
        String message;
        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio",
                "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
//ESENCIALES
        if (day < 1 || day > 31) {
            message = "Dia invalido";
        } else if (!month.equals("enero") &&  !month.equals("febrero") && !month.equals("marzo") && !month.equals("abril") &&
                !month.equals("mayo") && !month.equals("junio") &&!month.equals("julio") && !month.equals("agosto") && !month.equals("septiembre") &&
                !month.equals("octubre") && !month.equals("noviembre") &&!month.equals("diciembre")){
            message = "Mes invalido";
        } else if (year < 0) {
            message = "Año invalido";
        } else if (hour < 0 || hour > 23) {
            message = "Hora invalida";
        } else if (minute < 0 || minute > 59) {
              message = "Minuto invalido";
        } else if (second < 0 || second > 59) {
              message = "Segundo invalido";


        } else if ((month.equals("marzo") || month.equals("mayo") || month.equals("julio") ||
                month.equals("agosto") || month.equals("octubre")) && day >= 31) {
            message = "Dia invalido";
        }else if(day <28){
            int incrementaDay = day +1;
            message = incrementaDay+" " + month+" "+ year +" " + hour+ ":" + "00:00";

//MESES
        /*} else if (!month.equals("enero") ||  !month.equals("febrero") || !month.equals("marzo") || !month.equals("abril") ||
                !month.equals("mayo") || !month.equals("junio") || !month.equals("julio") || !month.equals("agosto") || !month.equals("septiembre") ||
                !month.equals("octubre") || !month.equals("noviembre") || !month.equals("diciembre")){
                message = "Mes invalido";*/

        } else if (month.equals("febrero") && (day== 29) && (year%4 !=0)) {
            message = "Dia invalido";
        }else if(month.equals("febrero")&& day == 28) {
            if (year % 4 == 0) {
                message = "29 febrero " + year + " 00:00:00";
            } else {
                message = "1 marzo " + year +" 00:00:00";
            }
        }else if (!month.equals("diciembre")){
            int incr = 0;
            for (int i = 0; i<meses.length; i++){
                if(meses[i].equals(month)){
                    incr = i+1;
                }
            }
            message = "1 " + meses[incr]+ " "+year+" 00:00:00";

            //DEMAS
        //} else if (year < 0) {
          //  message = "Año invalido";

        }else if(day == 31 && month.equals("diciembre")){
            int incrementaYear = year +1;
            message = "1 enero " +incrementaYear + " 00:00:00";

       // } else if (hour < 0 || hour > 23) {
         //   message = "Hora invalida";
        }else if(hour != 23){
            int incrementaHora = hour +1;
            message = day+" " + month+" "+ year +" " + incrementaHora+ ":00:00" ;
        //} else if (minute < 0 || minute > 59) {
          //  message = "Minuto invalido";
        }else if(minute != 59){
            int incrementaMin = minute +1;
            message = day+" " + month+" "+ year +" " + hour+ ":" +incrementaMin+ ":00:00";
        //} else if (second < 0 || second > 59) {
          //  message = "Segundo invalido";
        }else if (second != 59){
            int incrementaSec = second +1;
            message = day+" " + month+" "+ year +" " + hour + ":" +minute+":"+ incrementaSec;

        }else{
            message = "";
        }
        return message;

    }


}
