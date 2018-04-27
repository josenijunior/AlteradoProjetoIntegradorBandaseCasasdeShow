package com.appdigital.projetointegradorbandasecasasdeshow.contrato;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appdigital.projetointegradorbandasecasasdeshow.R;

public class Notificacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacao);

//        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        // Esse método cancela a notificação após ser tocada
//        nm.cancel(R.drawable.ic_launcher_background);

        Intent intentNotificacao = getIntent();
        Bundle parametros = intentNotificacao.getExtras();

        if (parametros != null){
            String hora = parametros.getString("Hora:");
            String data = parametros.getString("Data:");
            String mes = parametros.getString("Mês:");
            String ano = parametros.getString("Ano:");
        }



    }


}
