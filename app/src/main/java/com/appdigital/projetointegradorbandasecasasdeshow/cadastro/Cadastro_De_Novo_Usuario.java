package com.appdigital.projetointegradorbandasecasasdeshow.cadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.appdigital.projetointegradorbandasecasasdeshow.R;

import com.appdigital.projetointegradorbandasecasasdeshow.model.CasaDeShow;
import com.appdigital.projetointegradorbandasecasasdeshow.usuario.Usuario_Casa_Show;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.logging.SimpleFormatter;

public class Cadastro_De_Novo_Usuario extends AppCompatActivity {

    EditText edtnomecs, edtendereco, edtbairro, edtcidade, edtemail, edttelefone, edtcpf;
    Button btsalvardados;
     Spinner statuscasadeshow;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__de__novo__usuario_casadeshow);

        edtnomecs = (EditText)findViewById(R.id.edtitTextnomeCs);
        edtendereco = (EditText)findViewById(R.id.edtEnderecoCs);
        edtbairro = (EditText)findViewById(R.id.editTextBairroCs);
        edtcidade =(EditText)findViewById(R.id.editTextCidadeCs);
        edtemail = (EditText)findViewById(R.id.editTextEmailCs);
        edttelefone = (EditText)findViewById(R.id.editTextTelefoneCs);
        edtcpf = (EditText)findViewById(R.id.editTextCPFCs);
        statuscasadeshow = (Spinner)findViewById(R.id.spinnerStatusCs);

        ArrayAdapter adapter =  ArrayAdapter.createFromResource(this,R.array.Status, android.R.layout.simple_spinner_item);
        statuscasadeshow.setAdapter(adapter);



        btsalvardados = (Button)findViewById(R.id.botaoSalvarCs);



        //Mascara do telefone
        SimpleMaskFormatter smf = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher mtw =new MaskTextWatcher(edttelefone, smf);
        edttelefone.addTextChangedListener(mtw);

        SimpleMaskFormatter smfcpf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtwcpf = new MaskTextWatcher(edtcpf, smfcpf);
        edtcpf.addTextChangedListener(mtwcpf);

        btsalvardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomecs = edtnomecs.getText().toString().trim();
                String endereco = edtendereco.getText().toString().trim();
                String bairro = edtbairro.getText().toString().trim();
                String cidade = edtcidade.getText().toString().trim();
                String email = edtemail.getText().toString().trim();
                String telefone = edttelefone.getText().toString().trim();
                String cpf = edtcpf.getText().toString().trim();
                String statuscs = statuscasadeshow.getSelectedItem().toString();


                // aqui é instanciada a classe onde vai ser salvo os dados no pacote modelo
                CasaDeShow casaDeShow = new CasaDeShow(nomecs,endereco,bairro,cidade,email,telefone,cpf,statuscs);
                //aqui é salvo os dados e criado um node com o metodo child
                databaseReference.child("Usuario").push().setValue(casaDeShow);
                limparCampos();
                Intent intent =new Intent(Cadastro_De_Novo_Usuario.this, Usuario_Casa_Show.class);
                startActivity(intent);




            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference();



    }

    private void limparCampos() {

        edtnomecs.setText("");
        edtendereco.setText("");
        edtbairro.setText("");
        edtcidade.setText("");
        edtemail.setText("");
        edttelefone.setText("");
        edtcpf.setText("");

    }

}
