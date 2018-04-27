package com.appdigital.projetointegradorbandasecasasdeshow.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.appdigital.projetointegradorbandasecasasdeshow.cadastro.Cadastro_Usuario;
import com.appdigital.projetointegradorbandasecasasdeshow.usuario.Usuario_Banda;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAll extends AppCompatActivity {

    TextView tvregistro;
    EditText etlogin, edtsenha;
    Button btlogin, btnovo;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_all);
        btlogin =(Button)findViewById(R.id.btLogar);
        btnovo = (Button)findViewById(R.id.btnovoregistro);
        etlogin = (EditText)findViewById(R.id.editTextLogin);
        edtsenha = (EditText)findViewById(R.id.editTextSenha);
        firebaseAuth = FirebaseAuth.getInstance();
        // aqui um laço para ver se o usuário ja esta logado, se estiver vai para a tela de usuário senão vai para a tela de login
//        if (firebaseAuth.getCurrentUser()!=null){
//            startActivity(new Intent(getApplicationContext(),Usuario_Banda.class));
//            finish();
//        }

        inicializaComponentes();


        btnovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent tcn = new Intent(getApplicationContext(), Cadastro_Usuario.class);
                    startActivity(tcn);


            }

        });

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etlogin.getText().toString().trim();
                String senha = edtsenha.getText().toString().trim();
                login(email,senha);




            }
        });

    }

    private void login(String email, String senha) {
        firebaseAuth.signInWithEmailAndPassword(email,senha)
                .addOnCompleteListener(LoginAll.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //aqui é onde depois de ter logado o usuario vai para tela do usuário
                        if (task.isSuccessful()){
                            Intent to = new Intent(LoginAll.this,Tela_deOpcao.class);
                            startActivity(to);
                            finish();


                        }else{
                            alert("email ou senha errados");

                        }
                    }
                });
    }

    private void alert(String mensagem) {
        Toast.makeText(LoginAll.this,mensagem, Toast.LENGTH_SHORT ).show();

    }
    private void inicializaComponentes() { }

    @Override
    protected void onStart() {
        super.onStart();

        firebaseAuth = Conexao.getFirebaseAuth();
    }
}

