package com.mina.minaproject.helper;

import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AutenticacaoEmail {
    private EditText editEmail;
    private EditText editSenha;
    private FirebaseAuth mAuth;

    public AutenticacaoEmail(EditText editEmail, EditText editSenha) {
        this.editEmail = editEmail;
        this.editSenha = editSenha;
        mAuth = FirebaseAuth.getInstance();
    }

    public EditText getEditEmail() {
        return editEmail;
    }

    public void setEditEmail(EditText editEmail) {
        this.editEmail = editEmail;
    }

    public EditText getEditSenha() {
        return editSenha;
    }

    public void setEditSenha(EditText editSenha) {
        this.editSenha = editSenha;
    }

    public void registrarUsuario(){
        String email = this.getEditEmail().getText().toString();
        String senha = this.getEditSenha().getText().toString();
        mAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("Auth", "Deu bom");
                }else{
                    Log.i("Auth", "Deu ruim");
                }
            }
        });
    }


}
