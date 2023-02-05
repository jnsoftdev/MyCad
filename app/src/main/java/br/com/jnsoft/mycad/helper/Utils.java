package br.com.jnsoft.mycad.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    //Converte um inteiro ou texto em boolean válida! ex.: 0 = false; 1 = true; ...
    public static Boolean isIntBool(String value) {
        value = value.toUpperCase().trim();
        if (value.contains("1") || value.contains("TRUE")) {
            return true;
        } else {
            return false;
        }
    }

    //converte bool em int: false = 0; true = 1;
    public static Integer isBoolInt(boolean value) {
        if (value == true) {
            return 1;
        } else {
            return 0;
        }
    }

    //Datas e Horas

    /** Entra com uma data no formato dd/MM/YYYY string  e retorna uma data valída no format string*/
    public static Date getStrDate(String value) {
        Date data = new Date();
        String format = "dd/MM/yyyy";

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try{
            data = dateFormat.parse(value);
            return data;
        } catch (Exception e) {
            return data;
        }
    }

    /** Retorna aDta e hora atual do sistema para a data base */
    public static String getDate() {
        Date data = new Date();
        String format = "yyyy/MM/dd HH:mm/ss";
        try{
            DateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(data);
        } catch (Exception e) {
            return null;
        }
    }
}