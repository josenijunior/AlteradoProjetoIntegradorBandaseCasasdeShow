package com.appdigital.projetointegradorbandasecasasdeshow.login;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by TARDE on 16/04/2018.
 */

public class Conexao {

    private static FirebaseAuth firebaseAuth;
    private static FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser firebaseUser;


    private void conexaoFirebase(){

    }


    public static FirebaseAuth getFirebaseAuth(){
        if (firebaseAuth == null){
            inicializarFirebaseAuth();
        }
        return firebaseAuth;
    }

    private static void inicializarFirebaseAuth() {

        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser usuario =firebaseAuth.getCurrentUser();
                if (usuario != null){
                    firebaseUser = usuario;
                }

            }
        };
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    private static void inicializatFirebaseAuth(){}

    public static FirebaseUser getFirebaseUser(){
        return firebaseUser;
    }



    public static void logout(){
        firebaseAuth.signOut();


    }
}
