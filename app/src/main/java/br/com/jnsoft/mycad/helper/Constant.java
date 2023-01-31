package br.com.jnsoft.mycad.helper;

import java.util.List;

import br.com.jnsoft.mycad.model.Estados;
import br.com.jnsoft.mycad.model.Login;

public class Constant {

    public static final String ServerAddress = "192.168.1.51";
    public static final String ServerPacth = "http://" + ServerAddress + "/services/mycad/";
    public static final String API_TOKEN = "$myCadR#@GJh&5kh1>ktn$$#DAN1eLEH2023";

    public static String modo = "new";

    //preencher com dados que pode ser usando a qualquer momento e de qualquer lugar pelo sistema!

    public static Login profileUser;
    public static Boolean loginPermitUser = false;


    public static List<Estados> estadosList;

}
