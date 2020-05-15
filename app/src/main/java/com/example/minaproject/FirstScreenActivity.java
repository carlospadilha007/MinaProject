package com.example.minaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
    }

    public void entrarNaConta(View view){ // faz a transição da tela inicial para a de login
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void criarConta(View view){ // direciona para a tela de criação de conta
       Intent intent = new Intent(getApplicationContext(), CriarContaActivity.class);
       startActivity(intent);
    }

}
