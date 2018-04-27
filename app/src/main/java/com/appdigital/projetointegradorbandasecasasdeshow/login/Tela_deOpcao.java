package com.appdigital.projetointegradorbandasecasasdeshow.login;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.appdigital.projetointegradorbandasecasasdeshow.cadastro.CadastroDeBandas;
import com.appdigital.projetointegradorbandasecasasdeshow.cadastro.Cadastro_Usuario;
import com.appdigital.projetointegradorbandasecasasdeshow.cadastro.Cadastro_De_Novo_Usuario;
import com.google.android.gms.measurement.AppMeasurement;


public class Tela_deOpcao extends AppCompatActivity {
    private FloatingActionButton fabbanda, fabcasadeshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_opcao);

        fabbanda = (FloatingActionButton)findViewById(R.id.fBaBanda);
        fabcasadeshow = (FloatingActionButton)findViewById(R.id.fBaCasadeShow);

       fabbanda.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent cb = new Intent(Tela_deOpcao.this, CadastroDeBandas.class);
               startActivity(cb);
           }
       });

       fabcasadeshow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent cc = new Intent(Tela_deOpcao.this, Cadastro_De_Novo_Usuario.class);
               startActivity(cc);
           }
       });
    }

    public void statusUser(){
//        //usuario Banda
//        User user = new User();
//        user.setStatus(true);
//        Intent intentbd = new Intent();
//        Intent.putExtra("Usuario", user);
//        startActivity(intentbd);

    }
}
