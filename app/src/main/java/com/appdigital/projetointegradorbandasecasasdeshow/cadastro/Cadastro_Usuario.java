package com.appdigital.projetointegradorbandasecasasdeshow.cadastro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.appdigital.projetointegradorbandasecasasdeshow.login.Conexao;
import com.appdigital.projetointegradorbandasecasasdeshow.login.LoginAll;
import com.appdigital.projetointegradorbandasecasasdeshow.usuario.Usuario_Banda;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro_Usuario extends AppCompatActivity {
    private Button btregistrar, btvoltar;
    private EditText edtnomebanda,edtemail, edttelefone,edtapssword, edtconfirmarpass;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__usuario);
        btregistrar =(Button)findViewById(R.id.buttonSalvar);
        edtemail = (EditText)findViewById(R.id.edtEmailBd);
        edtapssword = (EditText)findViewById(R.id.edtSenhaBd);

//        eventoClick();
        inicializaComponentes();

        btregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String nome = edtnomebanda.getText().toString().trim();
                String email = edtemail.getText().toString().trim();
                //String telefone = edttelefone.getText().toString().trim();
                String senha = edtapssword.getText().toString().trim();
                String confirmacao = edtconfirmarpass.getText().toString().trim();
                criarUsuario(email,senha,confirmacao);
                Intent i = new Intent(Cadastro_Usuario.this, LoginAll.class);
                finish();
            }
        });


    }

//    private void eventoClick(){
//
//    }

    private void criarUsuario(String email, String senha, String confirmacao) {
        firebaseAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(Cadastro_Usuario.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            alert("Cadastro realizado com Sucesso.");
                            Intent i = new Intent(Cadastro_Usuario.this, Usuario_Banda.class);
                            startActivity(i);
                            finish();

                        }else{
                            alert("Falha ao cadastrar");
                        }
                    }
                });

    }
    private void alert(String mensagem){
        Toast.makeText(Cadastro_Usuario.this, mensagem, Toast.LENGTH_SHORT).show();
    }

    private void inicializaComponentes() {
       // edtnomebanda =(EditText)findViewById(R.id.edtNomeBd);
        edtemail = (EditText)findViewById(R.id.edtEmailBd);
        //edttelefone = (EditText) findViewById(R.id.edtTelefoneBd);
        edtapssword = (EditText)findViewById(R.id.edtSenhaBd);
        edtconfirmarpass = (EditText)findViewById(R.id.edtConfirmarSenhaBd);

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth = Conexao.getFirebaseAuth();
    }
}
