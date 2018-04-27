package com.appdigital.projetointegradorbandasecasasdeshow.helper;

import android.widget.EditText;

import com.appdigital.projetointegradorbandasecasasdeshow.R;
import com.appdigital.projetointegradorbandasecasasdeshow.cadastro.Cadastro_De_Novo_Usuario;
import com.appdigital.projetointegradorbandasecasasdeshow.model.CasaDeShow;

public class CasaShowHelper {
    EditText campoNome;
    EditText campoSenha;
    EditText campoConfirmarSenha;
    EditText campoEmail;
    EditText campoTelefone;
    CasaDeShow casaDeShow;

//    public CasaShowHelper(Cadastro_De_Novo_Usuario activity, CasaDeShow casaDeShow){
//        this.campoNome = activity.findViewById(R.id.edtNomeCasa);
//        this.campoEmail = activity.findViewById(R.id.edtEmailContato);
//        this.campoTelefone = activity.findViewById(R.id.edtTelefoneContato);
//        this.campoSenha = activity.findViewById(R.id.edtSenhaCadastro);
//        this.campoConfirmarSenha = activity.findViewById(R.id.edtConfirmarSenhaCadastro);
//
//        this.casaDeShow = casaDeShow;
//    }
//
//    public CasaDeShow pegaCasaShow(){
//        casaDeShow.setNome(campoNome.getText().toString());
//        casaDeShow.setEmail(campoEmail.getText().toString());
//        casaDeShow.setTelefone(campoTelefone.getText().toString());
//        casaDeShow.setSenha(campoSenha.getText().toString());
//        casaDeShow.setConfirmarSenha(campoConfirmarSenha.getText().toString());
//        return casaDeShow;
//    }
}
