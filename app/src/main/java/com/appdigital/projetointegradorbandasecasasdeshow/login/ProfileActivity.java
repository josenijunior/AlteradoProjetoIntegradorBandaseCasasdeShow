package com.appdigital.projetointegradorbandasecasasdeshow.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    TextView tvnome, tvemail, tvid;
    private Button btsair;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario__banda);

        inicializaComponentes();
        eventoonClick();


    }

    private void eventoonClick() {

        btsair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexao.logout();
                finish();
            }
        });
    }

    private void inicializaComponentes() {
        tvnome = (TextView)findViewById(R.id.textViewPerfilnome);
        tvnome = (TextView)findViewById(R.id.textViewPerfilemail);
        tvnome = (TextView)findViewById(R.id.textViewPerfilId);
        btsair = (Button)findViewById(R.id.btsair);

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth = Conexao.getFirebaseAuth();
        firebaseUser = Conexao.getFirebaseUser();
        verificaUser();
    }

    private void verificaUser() {
        if (firebaseUser==null){
            finish();
        }else{
            tvemail.setText("nomme"+ firebaseUser.getEmail());
            tvid.setText("id"+ firebaseUser.getUid());
        }

    }
}
