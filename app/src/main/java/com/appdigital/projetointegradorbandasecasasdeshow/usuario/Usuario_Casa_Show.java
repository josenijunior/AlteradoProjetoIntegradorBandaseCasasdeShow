package com.appdigital.projetointegradorbandasecasasdeshow.usuario;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.appdigital.projetointegradorbandasecasasdeshow.R;

public class Usuario_Casa_Show extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerCasaShow;
    android.support.v7.widget.Toolbar toolbarCasaShow;
    NavigationView naveCasaShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario__casa__show);

        drawerCasaShow = findViewById(R.id.drawerLayout_casa_show);
        toolbarCasaShow = findViewById(R.id.toolbar_casa_show);
        naveCasaShow = findViewById(R.id.nave_casa_show);
        setSupportActionBar(toolbarCasaShow);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerCasaShow,
                toolbarCasaShow, R.string.se, R.string.si);
        drawerCasaShow.addDrawerListener(toggle);
        toggle.syncState();
        naveCasaShow.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_sair_casa_showcs:
                Toast.makeText(this, "sair", Toast.LENGTH_SHORT).show();
                finish();
        }
        drawerCasaShow.closeDrawer(GravityCompat.START);
        return true;
    }
}
