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
import com.appdigital.projetointegradorbandasecasasdeshow.model.Banda;
import com.appdigital.projetointegradorbandasecasasdeshow.usuario.Usuario_Banda;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroDeBandas extends AppCompatActivity {

    private EditText edtnome, edtintegrantes, edtgenero, edtpreco, edtcargahoraria,edtdescricao, edtemail, edttelefone, edtcpf;
    private Button btsalvardadosbanda;
    Spinner statusbandas;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_bandas);

        edtnome = (EditText)findViewById(R.id.edTNomeBd);
        edtintegrantes =(EditText)findViewById(R.id.IntegrantesBd);
        edtgenero = (EditText)findViewById(R.id.GeneroBd);
        edtpreco = (EditText)findViewById(R.id.editTextPrecoBd);
        edtcargahoraria = (EditText)findViewById(R.id.editTextCargaHorariaBd);
        edtdescricao = (EditText)findViewById(R.id.editTextDescrcaoBd);
        edtemail = (EditText)findViewById(R.id.editTextEmailBd);
        edttelefone = (EditText)findViewById(R.id.editTextTelefoneBd);
        edtcpf = (EditText)findViewById(R.id.editTextCpfBd);

        databaseReference=FirebaseDatabase.getInstance().getReference();

        statusbandas = (Spinner)findViewById(R.id.spinnerBd);

        ArrayAdapter adapterstatus = ArrayAdapter.createFromResource(this,R.array.StatusBanda,android.R.layout.simple_spinner_item);
        statusbandas.setAdapter(adapterstatus);

        // Mascara para o campo de telefone
        SimpleMaskFormatter smffone = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher mtwtelefone = new MaskTextWatcher(edttelefone,smffone);
        edttelefone.addTextChangedListener(mtwtelefone);
        // Mascara para o campo de CPF
        SimpleMaskFormatter smfcpf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtwtcpf = new MaskTextWatcher(edtcpf,smfcpf);
        edtcpf.addTextChangedListener(mtwtcpf);

        btsalvardadosbanda = (Button)findViewById(R.id.btSalvarBd);

        btsalvardadosbanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomebd = edtnome.getText().toString().trim();
                String integrantesbd = edtintegrantes.getText().toString().trim();
                String generobd = edtgenero.getText().toString().trim();
                String precobd = edtpreco.getText().toString().trim();
                String cargabd = edtcargahoraria.getText().toString().trim();
                String descrcaobd = edtdescricao.getText().toString().trim();
                String emailbd = edtemail.getText().toString().trim();
                String telefonebd = edttelefone.getText().toString().trim();
                String cpfbd = edtcpf.getText().toString().trim();
                String status = statusbandas.getSelectedItem().toString();

                limparCampos();


                // aqui é instanciada a classe onde vai ser salvo os dados no pacote modelo
                Banda banda = new Banda(nomebd,integrantesbd,generobd,precobd,cargabd,descrcaobd,emailbd,telefonebd,cpfbd,status);
                //aqui é salvo os dados e criado um node com o metodo child
                databaseReference.child("Usuario").push().setValue(banda);

                Intent intentUsusariobanda = new Intent(CadastroDeBandas.this, Usuario_Banda.class);
                startActivity(intentUsusariobanda);


            }
        });



    }

    private void limparCampos() {
        edtnome.setText("");
        edtintegrantes.setText("");
        edtgenero.setText("");
        edtpreco.setText("");
        edtcargahoraria.setText("");
        edtdescricao.setText("");
        edtemail.setText("");
        edttelefone.setText("");
        edtcpf.setText("");
    }
}
