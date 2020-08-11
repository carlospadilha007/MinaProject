package com.mina.minaproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mina.minaproject.R;

public class ValidarContaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_conta);
    }

    public void voltarParaCriacaoDeConta(View view){
        finish();
    }

    public void verificarCodigo(View view){

    }



}
