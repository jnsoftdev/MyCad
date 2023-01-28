package br.com.jnsoft.mycad.helper;

public class StringFormat {

    public static String formataCEP(String CEP){
        CEP = CEP.replace(".","");
        CEP = CEP.replace("-","");
        return CEP;
    }

    public static String formataCPF(String CPF){
        CPF = CPF.replace(".","");
        CPF = CPF.replace("-","");
        return CPF;
    }

    public static String formataCNPJ(String CNPJ){
        CNPJ = CNPJ.replace(".","");
        CNPJ = CNPJ.replace("-","");
        CNPJ = CNPJ.replace("/","");
        return CNPJ;
    }

}
