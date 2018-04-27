package com.appdigital.projetointegradorbandasecasasdeshow.contrato;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.RingtonePreference;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contrato extends AppCompatActivity {

    private Spinner spinnerhora;
    private Spinner spinnerdata;
    private Spinner spinnermes;
    private Spinner spinnerano;

    private Button btcontratar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato);
        // este método é usado para não deixar a tela girar quando o celular for girado
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        spinnerhora = (Spinner)findViewById(R.id.spinnerHora);
        spinnerdata = (Spinner)findViewById(R.id.spinnerData);
        spinnermes = (Spinner)findViewById(R.id.spinnerMes);
        spinnerano = (Spinner)findViewById(R.id.spinnerAno);
        btcontratar = (Button)findViewById(R.id.buttonContratar);

        // craindo um adapter para hora
        ArrayAdapter adapterhora = ArrayAdapter.createFromResource(this,R.array.Hora,android.R.layout.simple_spinner_item);
        spinnerhora.setAdapter(adapterhora);

        // craindo um adapter para Data
        ArrayAdapter adapterdata = ArrayAdapter.createFromResource(this,R.array.Data, android.R.layout.simple_spinner_item);
        spinnerdata.setAdapter(adapterdata);

        // craindo um adapter para Mês
        ArrayAdapter adaptermes = ArrayAdapter.createFromResource(this,R.array.Mês, android.R.layout.simple_spinner_item);
        spinnermes.setAdapter(adaptermes);

        // craindo um adapter para ano
        ArrayAdapter adapterano = ArrayAdapter.createFromResource(this,R.array.Ano, android.R.layout.simple_spinner_item);




        btcontratar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hora = spinnerhora.getSelectedItem().toString();
                String data = spinnerdata.getSelectedItem().toString();
                String mes = spinnermes.getSelectedItem().toString();
                String ano = spinnerano.getSelectedItem().toString();

                Intent intentContrato = new Intent(getApplicationContext(),Notificacao.class);
                Bundle parametros = new Bundle();
                parametros.putString("Hora:",hora);
                parametros.putString("Data: ",data);
                parametros.putString("Mês", mes);
                parametros.putString("Ano", ano);

                intentContrato.putExtras(parametros);
                startActivity(intentContrato);

                gerarNotificação();


            }
        });


    }
    private void gerarNotificação() {
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        PendingIntent p =  PendingIntent.getActivity(this,0, new Intent(this,Notificacao.class),0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("Texto"); // a função do Ticker é aparecerrapidamente na parte superior da tela.
        builder.setContentTitle("Titulo");
        builder.setContentText("Descrição");
//        builder.setSmallIcon();
//        builder.setLargeIcon();
        builder.setContentIntent(p);

        Notification n = builder.build();
        n.vibrate = new long[]{150,300,150,600};
        n.flags = Notification.FLAG_AUTO_CANCEL;
        nm.notify(R.drawable.ic_launcher_background,n);

        try {

            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone toque = RingtoneManager.getRingtone(this,som);
            toque.play();

        }catch (Exception e){}

    }





}
