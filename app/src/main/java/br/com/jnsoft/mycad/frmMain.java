package br.com.jnsoft.mycad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class frmMain extends AppCompatActivity {
    static Toolbar toolbar;
    ProgressBar progress;
    FrameLayout frameLayout;

    DrawerLayout drawerLayout;
    NavigationView navDrawer;
    BottomNavigationView navBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarFilds();
        initThread();
        initComponets();
        initFilds();

        initListiner();
        listierMenuDrawer();

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
        progress = findViewById(R.id.frmMain_progressBar);

        drawerLayout = findViewById(R.id.frmMain_drawerNavBar);
        navDrawer = findViewById(R.id.frmMain_MenuPrincipal);
        navBottom = findViewById(R.id.frmMain_navBottom);
        frameLayout = findViewById(R.id.frmMain_frameLayout);
    }

    private void initFilds() {
        //Inicia fragmentos = home

    }

    private void initListiner() {

    }

    // ############### Forms
    private void callFrmMain(){

    }


    // ############### Funções


    // ############### Data Services


    // ############### Extends Forms
    // ****** Menu Tooolbar  ******
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuMain_navBarAction:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    // ****** Menus  ******
    private void listierMenuDrawer() {

        //Menu tipo gaveta
        navDrawer.setNavigationItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.navMain_Home:
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.navMain_CadPessoa:
                    Toast.makeText(this, "Cadastro", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });

        navBottom.setOnNavigationItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.menuMainBotton_Home:
                    Toast.makeText(this, "Home bottom", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menuMainBotton_Chat:
                    Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menuMainBotton_Agenda:
                    Toast.makeText(this, "Agenda", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menuMainBotton_History:
                    Toast.makeText(this, "History", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });




    }

    // ############### Tascks Listiner


}