package com.mina.minaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CriarContaActivity extends AppCompatActivity {
    public SharedPreferences preferences;

    //campos para cadastro
    private EditText editNome;
    private EditText editSobrenome;
    private EditText editCpf;
    private EditText editDataNascimento;
    private EditText editTelefone;
    private EditText editCidade;
    private EditText editEmail;
    private EditText editSenha;
    private Button btnContinuar;

    private String[] nomes={"Nome","Sobrenome", "CPF", "DataDeNascimento","Telefone","Cidade","Email","Senha"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        editNome=findViewById(R.id.edtNome);
        editSobrenome=findViewById(R.id.edtSobrenome);
        editCpf=findViewById(R.id.edtCpf);
        editDataNascimento=findViewById(R.id.edtDataNascimento);
        editTelefone=findViewById(R.id.edtTelefone);
        editCidade=findViewById(R.id.edtCidade);
        editEmail=findViewById(R.id.edtEmail);
        editSenha=findViewById(R.id.edtSenha);
        btnContinuar=findViewById(R.id.btnContinuar);
    }

    public void voltarParaLogin(View view){
        finish();
    }

    public void continuarCriacaoDeConta(View view){
        this.salvaPreferencias();

        if(this.confereCamposVazios()){
            startActivity(new Intent(getApplicationContext(), ValidarContaActivity.class));
        }


    }

    public void salvaPreferencias(){
        //Salva os dados em um arquivo de preferencias para posterior uso
        preferences=getSharedPreferences(getString(R.string.PREFERENCES_USUARIO), 0);//pode ser acessado dessa forma de qualquer activity
        SharedPreferences.Editor editor=preferences.edit();//instancia um editor

        editor.putString("Nome", editNome.getText().toString());
        editor.putString("Sobrenome", editSobrenome.getText().toString());
        editor.putString("CPF", editCpf.getText().toString());
        editor.putString("DataDeNascimento", editDataNascimento.getText().toString());
        editor.putString("Telefone", editTelefone.getText().toString());
        editor.putString("Cidade", editCidade.getText().toString());
        editor.putString("Email", editEmail.getText().toString());
        editor.putString("Senha", editSenha.getText().toString());
        editor.commit();//salva no Preferences

        //testando
        /*try{
            for(int i=0;i<8;i++){
                Log.i("LALA", preferences.getString(nomes[i], "Erro"));
            }
        }catch(Exception e){
            Log.i("LALA","Erro");
        }*/
    }


    public boolean confereCamposVazios(){

        if(editNome.getText().toString().equals("")){
            Toast.makeText(this, "Por favor preecha todos os campos.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
