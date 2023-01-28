package br.com.jnsoft.mycad.helper;

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

}