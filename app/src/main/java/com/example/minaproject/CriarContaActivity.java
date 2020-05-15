package com.example.minaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CriarContaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);
    }

    public void voltarParaLogin(View view){
        finish();
    }

    public void continuarCriacaoDeConta(View view){
        Intent intent = new Intent(getApplicationContext(), ValidarContaActivity.class);
        startActivity(intent);
    }

}
