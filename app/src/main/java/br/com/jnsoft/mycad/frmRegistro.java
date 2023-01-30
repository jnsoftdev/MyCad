package br.com.jnsoft.mycad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;

public class frmRegistro extends AppCompatActivity {
    static Toolbar toolbar;
    RequestQueue requestQueue;
    ProgressBar progress;

    Spinner cbEstado;

    EditText txtNome, txtCPF, txtFone, txtEmail,
            txtUsername, txtPass, txtConfirm,
            txtCEP, txtLougradouro, txtNumero, txtBairro,
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
        toolbar = findViewById(R.id.frmMain_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
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
        txtLougradouro = findViewById(R.id.frmRegistro_txtLogradouro);
        txtNumero = findViewById(R.id.frmRegistro_txtNumero);
        txtBairro = findViewById(R.id.frmRegistro_txtBairro);
        txtCidade = findViewById(R.id.frmRegistro_txtCidade);
        cbEstado = findViewById(R.id.frmRegistro_cbEstados);
        txtCreate = findViewById(R.id.frmRegistro_txtCreate);
        chkAtivo = findViewById(R.id.frmRegistro_txtCreate);

        btnConfirmar = findViewById(R.id.frmRegistro_btnAccept);
        btnCancelar = findViewById(R.id.frmRegistro_btnCancel);
        btnChkUser = findViewById(R.id.frmRegistro_btnChkUser);
        btnBuscarCEP = findViewById(R.id.frmRegistro_btnCEP);

    }

    private void initFilds() {

    }

    private void initListiner() {

    }

    // ############### Forms
    private void callfrmMain(){

    }


    // ############### Funções


    // ############### Data Services


    // ############### Extends Forms
    // ****** Menu Tooolbar  ******


    // ****** Menus  ******


    // ############### Tascks Listiner
}