package com.appdigital.projetointegradorbandasecasasdeshow.usuario;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.appdigital.projetointegradorbandasecasasdeshow.login.Conexao;
import com.appdigital.projetointegradorbandasecasasdeshow.login.LoginAll;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.appdigital.projetointegradorbandasecasasdeshow.login.Conexao.logout;

public class Usuario_Banda extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    TextView tvnome, tvemail, tvid;
    private Button btsair;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    Toolbar toobar;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario__banda);
        toobar = (Toolbar)findViewById(R.id.toolbar_banda);
        toobar.setTitle("Usuário Banda");
        setSupportActionBar(toobar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_menu_banda);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toobar,(R.string.Abrir),(R.string.Fechar));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();



        



    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        //aqui ele seleciona o item do menu para atribuir a ação.
        if (id==R.id.id_sairbd){
            Conexao.logout();
            Intent intentvoltarlogin = new Intent(Usuario_Banda.this, LoginAll.class);
            startActivity(intentvoltarlogin);

        }else{}
        return true;
    }
}
