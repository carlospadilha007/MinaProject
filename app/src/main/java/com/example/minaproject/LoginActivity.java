package com.example.minaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void recuperarSenha(View view){ // sera usado no btn (esqueci a senha)

    }

    public void entrarNaConta(View view){ // fara a validação do login

    }

    public void criarConta(View view){// transfere para a criação de conta
        Intent intent = new Intent(getApplicationContext(), CriarContaActivity.class);
        startActivity(intent);
    }

}
