package br.com.jnsoft.mycad.helper;

public class StringFormat {

    public static String formatCEP(String Cep){
        Cep = Cep.replace(".","");
        Cep = Cep.replace("-","");
        return Cep;
    }

    public static String formatCPF(String CPF){
        CPF = CPF.replace(".","");
        CPF = CPF.replace("-","");
        return CPF;
    }

    public static String formatCNPJ(String CNPJ){
        CNPJ = CNPJ.replace(".","");
        CNPJ = CNPJ.replace("-","");
        CNPJ = CNPJ.replace("/","");
        return CNPJ;
    }





}
