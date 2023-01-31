package br.com.jnsoft.mycad.helper.urls;

import static br.com.jnsoft.mycad.helper.Constant.ServerPacth;

public class ClientesUrl {
    private static String _selectAll = "selectAll.php";
    private static String _selectID =  "selectID.php";
    private static String _selectName = "selectName.php";
    private static String _insert =  "insert.php";
    private static String _update =  "update.php";
    private static String _delete =  "delete.php";

    private static String tabela = "clientes/";

    public static final String SelectAll = ServerPacth + tabela + _selectAll;
    public static final String SelectID =  ServerPacth + tabela + _selectID;
    public static final String SelectName =  ServerPacth + tabela + _selectName;
    public static final String Insert =  ServerPacth + tabela + _insert;
    public static final String InsertUser =  ServerPacth + tabela + "newUser.php";
    public static final String Update =  ServerPacth + tabela + _update;
    public static final String Delete =  ServerPacth + tabela + _delete;
}
