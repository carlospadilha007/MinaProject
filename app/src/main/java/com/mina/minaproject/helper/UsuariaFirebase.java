package com.mina.minaproject.helper;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mina.minaproject.models.Usuaria;

public class UsuariaFirebase {

    public UsuariaFirebase() {
    }

    public void cadastraFirestore(Usuaria usuaria, String id){
        FirebaseFirestore firestore= ConfiguracaoFirebase.getFirestore();

        firestore.collection("users").document(id)
                .set(usuaria)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.i("cadastro", "Sucesso ao criar o usuario");
                    }

        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("cadastro", "Error writing document", e);
                    }
        });

    }
}
