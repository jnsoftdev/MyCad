package br.com.jnsoft.mycad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
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
import br.com.jnsoft.mycad.helper.urls.EstadosUrl;
import br.com.jnsoft.mycad.helper.urls.LoginUrl;
import br.com.jnsoft.mycad.model.Estados;
import br.com.jnsoft.mycad.model.Head;
import br.com.jnsoft.mycad.model.Login;

public class frmRegistro extends AppCompatActivity {
    static Toolbar toolbar;
    RequestQueue requestQueue;
    ProgressBar progress;

    Spinner cbEstado;

    EditText txtNome, txtCPF, txtFone, txtEmail,
            txtUsername, txtPass, txtConfirm,
            txtCEP, txtLogradouro, txtNumero, txtBairro,
            txtCidade, txtCreate;

    CheckBox chkAtivo;
    Button btnConfirmar, btnCancelar, btnChkUser, btnBuscarCEP;

    boolean registerValidate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_registro);

        toolbarFilds();
        initThread();
        initComponets();
        initFilds();
        initListiner();

    }

    private void toolbarFilds(){

        toolbar = findViewById(R.id.frmRegistro_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("New Register");
    }

    private void initThread() {
        //Inciar a Thread para trabalha com o WebServices
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    private void initComponets(){
        progress = findViewById(R.id.frmRegistro_progressBar);

        txtNome = findViewById(R.id.frmRegistro_txtNome);
        txtCPF = findViewById(R.id.frmRegistro_txtCPF);
        txtFone = findViewById(R.id.frmRegistro_txtPhone);
        txtEmail = findViewById(R.id.frmRegistro_txtEmail);
        txtUsername = findViewById(R.id.frmRegistro_txtUsername);
        txtPass = findViewById(R.id.frmRegistro_txtPass);
        txtConfirm = findViewById(R.id.frmRegistro_txtConfirm);
        txtCEP = findViewById(R.id.frmRegistro_txtCEP);
        txtLogradouro = findViewById(R.id.frmRegistro_txtLogradouro);
        txtNumero = findViewById(R.id.frmRegistro_txtNumero);
        txtBairro = findViewById(R.id.frmRegistro_txtBairro);
        txtCidade = findViewById(R.id.frmRegistro_txtCidade);
        cbEstado = findViewById(R.id.frmRegistro_cbEstados);
        txtCreate = findViewById(R.id.frmRegistro_txtCreate);
        chkAtivo = findViewById(R.id.frmRegistro_chkAtivo);

        btnConfirmar = findViewById(R.id.frmRegistro_btnAccept);
        btnCancelar = findViewById(R.id.frmRegistro_btnCancel);
        btnChkUser = findViewById(R.id.frmRegistro_btnChkUser);
        btnBuscarCEP = findViewById(R.id.frmRegistro_btnCEP);

    }

    private void initFilds() {
        getEstadosAll(this);
    }

    private void initListiner() {
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        btnChkUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLoginValidate(v.getContext());
            }
        });

        btnBuscarCEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cep = txtCEP.getText().toString();
                if(cep.length()>0){
                    getBuscarCEP(v.getContext(), StringFormat.formataCEP(cep));
                }else{
                    Toast.makeText(v.getContext(), "Preencha o CEP primeiro!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // ############### Forms
    private void callfrmMain(){

    }


    // ############### Funções
    // ****** Set Values of Components  ******
    private void setEstados(List<Estados> estadosList){
        if(!(estadosList.size() < 1)){
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, estadosList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cbEstado.setAdapter(adapter);
        }
    }

    // ****** Função Spinner  ******
    private int getEstadoIndex(List<Estados> estadosList, String estado){
      for(int i=0; i < estadosList.size(); i++) {
          if(estadosList.get(i).getId().equals(estado)){
              return i;
          }
      }
      return 0;
    }

    // ****** Função CRUD ******
    private void endFuncion(){
        //respostas do servidor de dados aos clientes
        if(Constant.loginPermitUser == false){
            Toast.makeText(this, "Usuário já existe!", Toast.LENGTH_SHORT).show();
        }
    }



    // ############### Data Services
    protected void getEstadosAll(Context context){
        progress.setVisibility(View.VISIBLE);
        List<Estados> estadosList = new ArrayList<Estados>();
        final String URL = EstadosUrl.SelectAll;
        JSONObject value = null;

        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progress.setVisibility(View.GONE);
                JSONObject value = null;

                if (response.length() > 0) {
                    try {
                        JSONArray json = new JSONArray(response);

                        for (int i = 0; i < json.length(); i++) {
                            value = json.getJSONObject(i);
                            Estados dados = new Estados();

                            dados.setId(value.getString("EST_ID"));
                            dados.setNome(value.getString("EST_NOME"));

                            estadosList.add(dados);

                        }

                    } catch (JSONException e) {
                        Toast.makeText(context, R.string.Error_Server_Response, Toast.LENGTH_SHORT).show();
                    }

                    Constant.estadosList = estadosList;
                    setEstados(estadosList);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    progress.setVisibility(View.GONE);
                    Toast.makeText(context, R.string.Error_Server_500, Toast.LENGTH_SHORT).show();
            }

        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String, String> param = new HashMap<String, String>();
                param.put("token", Constant.API_TOKEN);
                return param;
            }
        };

        requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);

    }

    protected void getBuscarCEP(Context context, String Cep){
        progress.setVisibility(View.VISIBLE);
        final String URL = "http://viacep.com.br/ws/" + Cep + "/json/";
        JSONObject value = null;

        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progress.setVisibility(View.GONE);
                if (response.length()>0){
                    try {
                        JSONObject value = new JSONObject(response);
                        if (!value.has("erro")) {
                            txtCEP.setText(value.getString("cep").replace("-",""));
                            txtLogradouro.setText(value.getString("logradouro"));
                            //txtReferencia.setText(value.getString("complemento"));
                            txtBairro.setText(value.getString("bairro"));
                            txtCidade.setText(value.getString("localidade"));

                            cbEstado.setSelection(getEstadoIndex(Constant.estadosList,value.getString("uf")));

                        }else{
                            Toast.makeText(context, "Cep não encontrado!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progress.setVisibility(View.GONE);
                Toast.makeText(context, R.string.Error_Server_500, Toast.LENGTH_SHORT).show();
            }

        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String, String> param = new HashMap<String, String>();
                param.put("token", Constant.API_TOKEN);
                return param;
            }
        };

        requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);

    }

    protected void getLoginValidate(Context context){
        progress.setVisibility(View.VISIBLE);
        final String URL = LoginUrl.ValidUser;
        JSONObject value = null;

        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progress.setVisibility(View.GONE);

                if (response.length() > 0) {
                    try {
                        Head dados = new Head();
                        JSONArray json = new JSONArray(response);
                        JSONObject value = json.getJSONObject(0);

                        dados.setErro(Boolean.parseBoolean(value.getString("erro")));
                        dados.setMessage(value.getString("message"));
                        dados.setCode(Integer.parseInt(value.getString("code")));

                        if(dados.getErro() == true){
                            Constant.loginPermitUser = false;
                        }else{
                            Constant.loginPermitUser = true;
                        }
                        endFuncion();

                    } catch (JSONException e) {
                        Toast.makeText(context, R.string.Error_Server_Response, Toast.LENGTH_SHORT).show();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progress.setVisibility(View.GONE);
                Toast.makeText(context, R.string.Error_Server_500, Toast.LENGTH_SHORT).show();
            }

        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String, String> param = new HashMap<String, String>();
                param.put("token", Constant.API_TOKEN);
                param.put("user", txtUsername.getText().toString());
                return param;
            }
        };

        requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);

    }

    // ############### Extends Forms
    // ****** Menu Tooolbar  ******


    // ****** Menus  ******


    // ############### Tascks Listiner
}