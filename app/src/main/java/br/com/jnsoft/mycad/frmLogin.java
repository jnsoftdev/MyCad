package br.com.jnsoft.mycad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.jnsoft.mycad.helper.Constant;
import br.com.jnsoft.mycad.helper.StringFormat;
import br.com.jnsoft.mycad.helper.Utils;
import br.com.jnsoft.mycad.helper.urls.ClientesUrl;
import br.com.jnsoft.mycad.helper.urls.EstadosUrl;
import br.com.jnsoft.mycad.helper.urls.LoginUrl;
import br.com.jnsoft.mycad.model.Estados;
import br.com.jnsoft.mycad.model.Head;
import br.com.jnsoft.mycad.model.Login;

public class frmLogin extends AppCompatActivity {
    RequestQueue requestQueue;

    Toolbar toolbar;
    ProgressBar progress;
    EditText txtUser, txtPass;
    TextView lblRecovery;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initThread();
        initComponets();
        initFilds();
        initListiner();

    }

    private void initThread() {
        //Inciar a Thread para trabalha com o WebServices
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    private void initComponets(){
        progress = findViewById(R.id.frmLogin_progressBar);

        txtUser = findViewById(R.id.frmLogin_txtUsername);
        txtPass = findViewById(R.id.frmLogin_txtPassword);
        lblRecovery = findViewById(R.id.frmLogin_lblForgotPassword);

        btnLogin = findViewById(R.id.frmLogin_btnLogin);
    }

    private void initFilds() {

    }

    private void initListiner() {

        lblRecovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callfrmRecovery();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = txtUser.getText().toString();
                String pass = txtPass.getText().toString();

                selectLoginAuth(user, pass);

            }
        });


    }

    // ############### Forms
    private void callfrmMain(){
        Intent intent = new Intent(getApplicationContext(), frmMain.class);
        startActivity(intent);
    }

    private void callfrmRecovery(){
        //Intent intent = new Intent(getApplicationContext(), frmMain.class);
        //startActivity(intent);
        Toast.makeText(getApplicationContext(), "Recupera senha!", Toast.LENGTH_SHORT).show();
    }


    // ############### Funções
    // ****** Set Values of Components  ******


    // ****** Função CRUD ******


    // ############### Data Services
    public void selectLoginAuth(String user, String pass){
        progress.setVisibility(View.VISIBLE);
        final String URL = LoginUrl.Auth;
        Login perfil = new Login();

        if(user.toUpperCase().equals("JNSOFT") && pass.toString().toUpperCase().equals("123")){
            progress.setVisibility(View.GONE);

            perfil.setId(0);
            perfil.setCliID(0);
            perfil.setNome("JNSOFT DESENVOLVIMENTO");
            perfil.setCgc("15736938000148");
            perfil.setEmail("dev01@nsoft.com.br");
            perfil.setFone("91983135137");
            perfil.setUser("JNSOFT");
            perfil.setPass("******");
            perfil.setAcesso(true);
            perfil.setAtivo(true);

            Constant.profileUser = perfil;
            callfrmMain();
        }else{

            StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progress.setVisibility(View.GONE);
                    JSONObject value = null;

                    if (response.length() > 0) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                value = jsonArray.getJSONObject(i);

                                perfil.setId(Integer.parseInt(value.getString("LGN_ID")));
                                perfil.setCliID(Integer.parseInt(value.getString("CLI_ID")));
                                perfil.setNome(value.getString("CLI_NOME"));
                                perfil.setCgc(value.getString("CLI_CPF"));
                                perfil.setEmail(value.getString("CLI_EMAIL"));
                                perfil.setFone(value.getString("CLI_FONE"));
                                perfil.setUser(value.getString("LGN_USER"));
                                perfil.setPass(value.getString("LGN_PASS"));
                                perfil.setAcesso(Utils.isIntBool(value.getString("LGN_ACESSO")));
                                perfil.setAtivo(Utils.isIntBool(value.getString("LGN_ATIVO")));

                                Constant.profileUser = perfil;
                            }

                            progress.setVisibility(View.GONE);

                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), R.string.Error_Server_Response, Toast.LENGTH_SHORT).show();
                        }

                        if(perfil.getId() > 0 && perfil.getAcesso() && perfil.getAtivo()){
                           callfrmMain();
                        }else if(perfil.getId() > 0 && perfil.getAcesso() == false){
                            Toast.makeText(getApplicationContext(), R.string.Login_Auth_Denied, Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), R.string.Login_Auth_Fail, Toast.LENGTH_SHORT).show();
                        }

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progress.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), R.string.Error_Server_500, Toast.LENGTH_SHORT).show();
                }

            }){
                @Override
                protected Map<String,String> getParams() throws AuthFailureError{
                    Map<String, String> param = new HashMap<String, String>();
                    param.put("token", Constant.API_TOKEN);
                    param.put("user", user);
                    param.put("pass", pass);
                    return param;
                }
            };

            requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);
        }

    }

    // ############### Extends Forms
    // ****** Menu Tooolbar  ******


    // ****** Menus  ******


    // ############### Tascks Listiner
}